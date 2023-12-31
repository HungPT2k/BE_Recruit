package com.vn.recruit.service.impl;

import com.vn.recruit.core.Constants;
import com.vn.recruit.dto.ResponseDTO;
import com.vn.recruit.dto.UserDTO;
import com.vn.recruit.entity.OTP;
import com.vn.recruit.entity.Role;
import com.vn.recruit.entity.User;
import com.vn.recruit.repository.AuthenticateRepository;
import com.vn.recruit.repository.OTPRepository;
import com.vn.recruit.repository.RoleRepository;
import com.vn.recruit.repository.UserRepository;
import com.vn.recruit.security.jwt.TokenProvider;
import com.vn.recruit.service.AuthenticateService;
import com.vn.recruit.service.email.EmailService;
import com.vn.recruit.service.mapper.UserMapper;
import com.vn.recruit.web.vm.ChangePassVM;
import com.sun.xml.internal.ws.handler.HandlerException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@Slf4j
public class AuthenticateServiceImpl implements AuthenticateService {

    public final AuthenticateRepository authenticateRepository;

    public final UserMapper userMapper;

    public final RoleRepository roleRepository;

    public final UserRepository userRepository;

    public final OTPRepository otpRepository;

    private final PasswordEncoder passwordEncoder;

    private final EmailService emailService;

    private final AuthenticationManagerBuilder authenticationManagerBuilder;

    private final TokenProvider tokenProvider;

    public final String linkActiveAccount = "http://localhost:4200/active?code=";

    public AuthenticateServiceImpl(AuthenticateRepository authenticateRepository, UserMapper userMapper, RoleRepository roleRepository, UserRepository userRepository, OTPRepository otpRepository, PasswordEncoder passwordEncoder, EmailService emailService, AuthenticationManagerBuilder authenticationManagerBuilder, TokenProvider tokenProvider) {
        this.authenticateRepository = authenticateRepository;
        this.userMapper = userMapper;
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
        this.otpRepository = otpRepository;
        this.passwordEncoder = passwordEncoder;
        this.emailService = emailService;
        this.authenticationManagerBuilder = authenticationManagerBuilder;
        this.tokenProvider = tokenProvider;
    }

    @Override
    public ResponseDTO signup(UserDTO dto) {
        User userName = userRepository.findByUserName(dto.getUserName());
        User email = userRepository.findUserByEmail(dto.getEmail());
        if (userName != null) throw new NullPointerException();
        if (email != null) throw new HandlerException("email");
        List<Role> roles = roleRepository.findByCode(Constants.Role.USER);
        User user = userMapper.toEntity(dto);
        user.setDelete(false);
        user.setActivate(false);
        user.setRoles(roles);
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String enCryptPassword = bCryptPasswordEncoder.encode(dto.getPassword());
        user.setPassword(enCryptPassword);
        userRepository.save(user);
        OTP otp = new OTP(user);
        otpRepository.save(otp);
        String link = linkActiveAccount + otp.getCode();
        String emails = emailService.buildActiveLink(link);
        emailService.sendEmail(user.getEmail(), emails);
        return new ResponseDTO("Signup success");
    }

    @Override
    public ResponseDTO changePassword(ChangePassVM changePassVM) {
        User user = userRepository.findUserByEmail(changePassVM.getEmail());
        if (user != null) {
            OTP optdb = otpRepository.findByUser(user);
            if(optdb.isExpired()) throw new HandlerException("OTP Expired");
            if (optdb.getCode().equals(changePassVM.getCode())) {
                user.setPassword(passwordEncoder.encode(changePassVM.getPassword()));
                userRepository.save(user);
                return new ResponseDTO("Change password success");
            }
            else throw new NullPointerException();
        }
        else {
            return new ResponseDTO("Fail");
        }
    }
}

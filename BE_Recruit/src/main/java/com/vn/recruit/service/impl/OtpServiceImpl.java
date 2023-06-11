package com.vn.recruit.service.impl;

import com.vn.recruit.dto.ResponseDTO;
import com.vn.recruit.entity.OTP;
import com.vn.recruit.entity.User;
import com.vn.recruit.repository.OTPRepository;
import com.vn.recruit.repository.UserRepository;
import com.vn.recruit.service.OtpService;
import com.vn.recruit.service.email.EmailService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class OtpServiceImpl implements OtpService {
    private final UserRepository userRepository;

    private final OTPRepository otpRepository;

    private final EmailService emailService;

    public OtpServiceImpl(UserRepository userRepository, OTPRepository otpRepository, EmailService emailService) {
        this.userRepository = userRepository;
        this.otpRepository = otpRepository;
        this.emailService = emailService;
    }
    @Override
    public ResponseDTO sendOTP(String email) {
        User user=userRepository.findUserByEmail(email);
        if(user==null) throw new UsernameNotFoundException("");
        OTP otp=new OTP(user);
        OTP oldOTP=otpRepository.findByUser(user);
        if(oldOTP!=null){
            oldOTP.setCode(otp.getCode());
            oldOTP.setIssueAt(otp.getIssueAt());
            otpRepository.save(oldOTP);
        }
        else{
            otpRepository.save(otp);
        }

        String emails=emailService.buildOtpEmail(user.getUserName(), otp.getCode());
        emailService.sendEmail(user.getEmail(),emails);
        return new ResponseDTO("Send sucess");
    }
}

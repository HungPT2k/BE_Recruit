package com.vn.recruit.service;


import com.vn.recruit.dto.ResponseDTO;
import com.vn.recruit.dto.UserDTO;
import com.vn.recruit.web.vm.ChangePassVM;

public interface AuthenticateService {
    public ResponseDTO signup(UserDTO dto);

    public ResponseDTO changePassword(ChangePassVM changePassVM);
}

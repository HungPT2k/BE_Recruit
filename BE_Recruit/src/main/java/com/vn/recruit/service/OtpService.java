package com.vn.recruit.service;

import com.vn.recruit.dto.ResponseDTO;

public interface OtpService {
   ResponseDTO sendOTP(String email);
}

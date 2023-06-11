package com.vn.recruit.repository;

import com.vn.recruit.entity.OTP;
import com.vn.recruit.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OTPRepository extends JpaRepository<OTP,Long> {
    OTP findByUser(User user);

    OTP findByCode(String code);
}

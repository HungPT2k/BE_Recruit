package com.vn.recruit.repository;

import com.vn.recruit.entity.StatusJobRegister;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatusJobRegisterRepository extends JpaRepository<StatusJobRegister,Long> {

    StatusJobRegister findStatusJobRegisterByCode(String code);

    StatusJobRegister findStatusJobRegisterById(Long id);
}

package com.vn.recruit.repository;

import com.vn.recruit.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthenticateRepository extends JpaRepository<User, Long> {

}

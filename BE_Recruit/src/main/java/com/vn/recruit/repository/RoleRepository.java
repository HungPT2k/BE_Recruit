package com.vn.recruit.repository;

import com.vn.recruit.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findRoleByCode(String code);

    List<Role> findByCode(String code);

}

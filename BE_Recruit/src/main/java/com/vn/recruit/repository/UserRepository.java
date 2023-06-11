package com.vn.recruit.repository;

import com.vn.recruit.entity.User;
import com.vn.recruit.repository.repoext.UserRepositoryExt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User, Long>, UserRepositoryExt, PagingAndSortingRepository<User,Long> {
    User findByUserName(String userName);

    User findUserByEmail(String email);

    User findUserById(Long id);

    String findAllByUserName(String userName);

    String findAllByEmail(String email);

}

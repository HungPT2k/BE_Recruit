package com.vn.recruit.repository;

import com.vn.recruit.entity.StatusJob;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatusJobRepository extends JpaRepository<StatusJob,Long> {

    StatusJob findStatusJobById(Long statusJobId);

    StatusJob findStatusJobByCode(String code);
}

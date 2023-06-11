package com.vn.recruit.repository;

import com.vn.recruit.entity.JobPosition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobPositionRepository extends JpaRepository<JobPosition,Long> {

    JobPosition findJobPositionById(Long jobid);
}

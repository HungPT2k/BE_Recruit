package com.vn.recruit.repository;

import com.vn.recruit.entity.JobsRegister;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface JobsRegisterRepository extends PagingAndSortingRepository<JobsRegister,Long> {

    JobsRegister findJobsRegisterById(Long id);

}

package com.vn.recruit.repository;

import com.vn.recruit.entity.Job;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobRepository extends PagingAndSortingRepository<Job,Long> {
    Job findJobById(Long id);

}

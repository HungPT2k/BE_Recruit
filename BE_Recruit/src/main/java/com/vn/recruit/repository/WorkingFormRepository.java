package com.vn.recruit.repository;

import com.vn.recruit.entity.WorkingForm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkingFormRepository extends JpaRepository<WorkingForm,Long> {

    WorkingForm findWorkingFormById(Long wokingFormId);
}

package com.vn.recruit.repository;

import com.vn.recruit.entity.AcademicLevel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AcademicLevelRepository extends JpaRepository<AcademicLevel,Long> {

    AcademicLevel findAcademicLevelById(Long academicLevelId);
}

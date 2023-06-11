package com.vn.recruit.service;

import com.vn.recruit.entity.AcademicLevel;
import com.vn.recruit.repository.AcademicLevelRepository;

import java.util.List;

public class ProfileService {
    private final AcademicLevelRepository academicLevelRepository;

    public ProfileService(AcademicLevelRepository academicLevelRepository) {
        this.academicLevelRepository = academicLevelRepository;
    }

    public List<AcademicLevel> getAll(){
        return academicLevelRepository.findAll();
    }
}

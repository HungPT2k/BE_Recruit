package com.vn.recruit.web.vm;

import com.vn.recruit.entity.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class JobFieldVM {
    List<AcademicLevel> academicLevels;

    List<JobPosition> jobPositions;

    List<Rank> ranks;

    List<WorkingForm> workingForms;

    List<User> users;

    List<Company> companies;
}

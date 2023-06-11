package com.vn.recruit.service;

import com.vn.recruit.dto.JobsRegisterDTO;
import com.vn.recruit.dto.ResponseDTO;
import com.vn.recruit.dto.request.JobRegisterRequest;
import com.vn.recruit.entity.JobsRegister;
import com.vn.recruit.entity.Profile;
import com.vn.recruit.web.vm.JobsRegisterVM;
import org.springframework.core.io.Resource;

public interface JobsRegisterService {

    public JobsRegisterVM getAllJobsRegister(int pageNo, int pageSize, String sortBy, String sortDir);
    //

    public JobsRegister getById(Long id);

    public Profile getProfileByJobRegister(Long id);

    public ResponseDTO changeStatus(Long id,String code);

    public ResponseDTO rejectStatus(Long id,String code,String reason);

    public ResponseDTO scheduleInterview(JobsRegisterDTO jobsRegisterDTO);

    public JobsRegisterVM searchJobRegister(JobsRegisterVM jobsRegisterVM);

    public ResponseDTO addJobRegister(JobRegisterRequest request);

    public Resource downloadCv(String filename);
}

package com.vn.recruit.service;

import com.vn.recruit.dto.JobDTO;
import com.vn.recruit.dto.ResponseDTO;
import com.vn.recruit.dto.request.JobSearchRequest;
import com.vn.recruit.dto.respone.JobDetailResponse;
import com.vn.recruit.entity.Job;
import com.vn.recruit.web.vm.JobFieldVM;
import com.vn.recruit.web.vm.JobVM;
import com.vn.recruit.web.vm.StatisticalVm;

import java.io.IOException;
import java.util.List;

public interface JobService {

    public JobVM getAllJob(int pageNo, int pageSize, String sortBy, String sortDir);

    public Job createNewJob(JobDTO jobDTO);

    public Job getJobById(Long id);

    public JobDetailResponse getJobDetailById(Long id);

    public JobFieldVM getAllFieldSelect();

    public ResponseDTO changeStatus(Long id,String code);

    public List<Job> getJobPublic(String type);

    public ResponseDTO rejectStatus(Long id,String code,String reason);

    public ResponseDTO deleteJobById(Long id);

    public JobVM searchJob(JobVM jobVM);

    public byte[] exportData() throws IOException;

    public byte[] exportDataDashboard(StatisticalVm statisticalVm) throws IOException;

}

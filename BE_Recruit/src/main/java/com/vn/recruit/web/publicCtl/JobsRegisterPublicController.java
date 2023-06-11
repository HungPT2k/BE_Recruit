package com.vn.recruit.web.publicCtl;

import com.vn.recruit.core.Constants;


import com.vn.recruit.dto.ResponseDTO;

import com.vn.recruit.dto.request.JobRegisterRequest;
import com.vn.recruit.service.FilePdfService;
import com.vn.recruit.service.JobsRegisterService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping(value = Constants.Api.Path.PUBLIC)
public class JobsRegisterPublicController {
    private final JobsRegisterService jobsRegisterService;

    private final FilePdfService filePdfService;

    public JobsRegisterPublicController(JobsRegisterService jobsRegisterService, FilePdfService filePdfService) {
        this.jobsRegisterService = jobsRegisterService;
        this.filePdfService = filePdfService;
    }

    @PostMapping("/register-job-public")
    public ResponseEntity<ResponseDTO> registerJobPublic(JobRegisterRequest request) throws IOException {
        return ResponseEntity.ok().body(jobsRegisterService.addJobRegister(request));
    }

}

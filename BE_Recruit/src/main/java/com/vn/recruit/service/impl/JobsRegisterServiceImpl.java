package com.vn.recruit.service.impl;

import com.vn.recruit.dto.JobsRegisterDTO;
import com.vn.recruit.dto.ResponseDTO;
import com.vn.recruit.dto.request.JobRegisterRequest;
import com.vn.recruit.entity.*;
import com.vn.recruit.repository.*;
import com.vn.recruit.repository.repoimpl.ProfileRepositoryImpl;
import com.vn.recruit.service.JobsRegisterService;
import com.vn.recruit.service.email.EmailService;
import com.vn.recruit.utils.SecurityUtil;
import com.vn.recruit.web.vm.JobsRegisterVM;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.net.MalformedURLException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;

@Service
public class JobsRegisterServiceImpl implements JobsRegisterService {

    private final JobsRegisterRepository jobsRegisterRepository;

    private final ProfileRepositoryImpl profileRepositoryImpl;

    private final StatusJobRegisterRepository statusJobRegisterRepository;

    private final UserRepository userRepository;

    private final JobRepository jobRepository;
    private final FilePdfRepository filePdfRepository;

    private final EmailService emailService;

    public JobsRegisterServiceImpl(JobsRegisterRepository jobsRegisterRepository, ProfileRepositoryImpl profileRepositoryImpl, StatusJobRegisterRepository statusJobRegisterRepository, UserRepository userRepository, JobRepository jobRepository, FilePdfRepository filePdfRepository,EmailService emailService) {
        this.jobsRegisterRepository = jobsRegisterRepository;
        this.profileRepositoryImpl = profileRepositoryImpl;
        this.statusJobRegisterRepository = statusJobRegisterRepository;
        this.userRepository = userRepository;
        this.jobRepository = jobRepository;
        this.filePdfRepository = filePdfRepository;
        this.emailService = emailService;
    }

    @Override
    public JobsRegisterVM getAllJobsRegister(int pageNo, int pageSize, String sortBy, String sortDir) {
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending()
                : Sort.by(sortBy).descending();// custom sort , check điều kiện để trả về tăng hoặc giảm

        Pageable pageable = PageRequest.of(pageNo, pageSize, sort); // custom page trả về

        Page<JobsRegister> jobsRegisters = jobsRegisterRepository.findAll(pageable);
        JobsRegisterVM jobsRegisterVM = new JobsRegisterVM(jobsRegisters.getContent(), jobsRegisters.getNumber(), jobsRegisters.getSize(), jobsRegisters.getTotalElements(),
                jobsRegisters.getTotalPages(), jobsRegisters.isLast());
        return jobsRegisterVM;
    }

    @Override
    public JobsRegister getById(Long id) {
        return jobsRegisterRepository.findJobsRegisterById(id);
    }

    public Profile getProfileByJobRegister(Long id) { // lấy thông tin người ứng tuyển
        JobsRegister jobsRegister = jobsRegisterRepository.findJobsRegisterById(id);
        return profileRepositoryImpl.getProfileByUser(jobsRegister.getUser());
    }

    @Override
    public ResponseDTO changeStatus(Long id, String code) {
        JobsRegister jobsRegister = jobsRegisterRepository.findJobsRegisterById(id);
        StatusJobRegister statusJobRegister = statusJobRegisterRepository.findStatusJobRegisterByCode(code);
        jobsRegister.setStatusJobRegister(statusJobRegister);
        jobsRegisterRepository.save(jobsRegister);
        return new ResponseDTO("Change status success");
    }

    @Override
    public ResponseDTO rejectStatus(Long id, String code, String reason) {
        JobsRegister jobsRegister = jobsRegisterRepository.findJobsRegisterById(id);
        StatusJobRegister statusJobRegister = statusJobRegisterRepository.findStatusJobRegisterByCode(code);
        jobsRegister.setStatusJobRegister(statusJobRegister);
        jobsRegister.setReason(reason);
        jobsRegisterRepository.save(jobsRegister);
        return new ResponseDTO("Change status success");
    }

    @Override
    public ResponseDTO scheduleInterview(JobsRegisterDTO jobsRegisterDTO) {
        JobsRegister jobsRegister = jobsRegisterRepository.findJobsRegisterById(jobsRegisterDTO.getId());
        jobsRegister.setStatusJobRegister(statusJobRegisterRepository.findStatusJobRegisterByCode("Đang phỏng vấn"));
        jobsRegister.setMethodInterview(jobsRegister.getMethodInterview());
        jobsRegister.setDateInterview(jobsRegister.getDateInterview());
        Job job = jobRepository.findJobById(jobsRegister.getJob().getId());
        String email = emailService.buildMailInterview(job.getName(),jobsRegisterDTO.getTimeInterview().toString(),jobsRegisterDTO.getDateInterview().toString(),
                jobsRegisterDTO.getMethodInterview(),job.getUserContact().getName(),job.getUserContact().getPhoneNumber(),jobsRegister.getUser().getUserName());
        jobsRegisterRepository.save(jobsRegister);
        ResponseDTO response = new ResponseDTO();
        response.setCode("Success");
        return response;
    }

    @Override
    public JobsRegisterVM searchJobRegister(JobsRegisterVM jobsRegisterVM) {
        return null;
    }

    @Override
    public ResponseDTO addJobRegister(JobRegisterRequest request) {
        Job job = jobRepository.findJobById(request.getJobId());
        String username = SecurityUtil.getCurrentUserLogin().get();
        User user = userRepository.findByUserName(username);
        Path root = Paths.get("Files-Upload");
        try {
            Files.copy(request.getCvFile().getInputStream(), root.resolve(request.getCvFile().getOriginalFilename()));
        } catch (Exception e) {
            if (e instanceof FileAlreadyExistsException) {
                return new ResponseDTO(HttpStatus.BAD_REQUEST, "A file of that name already exists.");
            }

            return new ResponseDTO(HttpStatus.INTERNAL_SERVER_ERROR,e.getMessage());
        }

        StatusJobRegister statusJobRegister = statusJobRegisterRepository.findStatusJobRegisterByCode("Chờ duyệt");
        JobsRegister jobsRegister = new JobsRegister();
        jobsRegister.setJob(job);
        jobsRegister.setUser(user);
        jobsRegister.setDateRegister(new Date());
        jobsRegister.setStatusJobRegister(statusJobRegister);
        jobsRegister.setDelete(false);
        jobsRegister.setCvFile(request.getCvFile().getOriginalFilename());
        jobsRegisterRepository.save(jobsRegister);

        return new ResponseDTO(HttpStatus.OK,"Apply success");
    }

    @Override
    public Resource downloadCv(String filename) {
        Path root = Paths.get("Files-Upload");
        try {
            Path file = root.resolve(filename);
            Resource resource = new UrlResource(file.toUri());

            if (resource.exists() || resource.isReadable()) {
                return resource;
            } else {
                throw new RuntimeException("Could not read the file!");
            }
        } catch (MalformedURLException e) {
            throw new RuntimeException("Error: " + e.getMessage());
        }
    }
}

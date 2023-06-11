package com.vn.recruit.web.admin;

import com.vn.recruit.core.Constants;
import com.vn.recruit.dto.request.CompanyRequest;
import com.vn.recruit.entity.Company;
import com.vn.recruit.service.CompanyService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping(value = Constants.Api.Path.ADMIN)
@CrossOrigin
public class CompanyController {
    private CompanyService companyService;
    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }
    @GetMapping(value = "/company/{id}")
    public ResponseEntity<Company> getCompany(@PathVariable("id") Long id){
        return ResponseEntity.ok().body(companyService.findCompanyById(id));
    }

    @GetMapping(value = "/company")
    public ResponseEntity<Company> getCompanyByName(@PathVariable("name") String name){
        return ResponseEntity.ok().body(companyService.findCompanyByName(name));
    }
    @PostMapping("/company")
    public ResponseEntity<Object> createCompany(CompanyRequest request) throws IOException {
        return ResponseEntity.ok().body(companyService.createCompany(request));
    }
}

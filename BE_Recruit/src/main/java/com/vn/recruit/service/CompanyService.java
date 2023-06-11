package com.vn.recruit.service;

import com.vn.recruit.dto.ResponseDTO;
import com.vn.recruit.dto.request.CompanyRequest;
import com.vn.recruit.entity.Company;
import org.springframework.http.ResponseEntity;

import java.io.IOException;

public interface CompanyService {
    public Company findCompanyById(long id);
    public Company findCompanyByName(String name);
    public ResponseEntity<ResponseDTO> createCompany(CompanyRequest request) throws IOException;
}

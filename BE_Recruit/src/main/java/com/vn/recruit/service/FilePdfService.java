package com.vn.recruit.service;

import com.vn.recruit.dto.ResponseDTO;
import com.vn.recruit.web.vm.FilePdfVM;
import org.springframework.http.ResponseEntity;

public interface FilePdfService {
    public ResponseEntity<ResponseDTO>  addFilePdf(FilePdfVM filePdfVM);
}

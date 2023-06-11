package com.vn.recruit.repository;

import com.vn.recruit.entity.FilePdf;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilePdfRepository extends JpaRepository<FilePdf, Long> {
}

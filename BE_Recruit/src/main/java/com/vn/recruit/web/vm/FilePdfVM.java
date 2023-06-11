package com.vn.recruit.web.vm;

import lombok.*;



@Data
public class FilePdfVM {
    private Long id;
    private String file_name;
    private String download_uri;
    private Long size_url;
    private byte[] data;
}

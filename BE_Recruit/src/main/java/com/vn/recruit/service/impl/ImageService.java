package com.vn.recruit.service.impl;

import com.vn.recruit.dto.ResponseDTO;
import com.vn.recruit.entity.Image;
import com.vn.recruit.repository.ImageRepository;
import com.vn.recruit.utils.ImageUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class ImageService {

    private final ImageRepository imageRepository;

    public ImageService(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }

    public ResponseDTO uploadImage(MultipartFile file) throws IOException {
        Image image = Image.builder().name(file.getOriginalFilename())
                                     .type(file.getContentType())
                                     .image(ImageUtils.compressImage(file.getBytes())).build();
        imageRepository.save(image);
        return new ResponseDTO("Upload image success");
    }

    public Image getImageByName(String name) throws IOException{
        Image image=imageRepository.findImageByName(name);
        image.setImage(ImageUtils.decompressImage(image.getImage()));
        return image;
    }
}

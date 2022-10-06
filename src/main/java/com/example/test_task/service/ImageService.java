package com.example.test_task.service;

import com.example.test_task.entity.Image;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface ImageService {
    String save(MultipartFile image) throws IOException;



    Image findImageById(String fileId);
}

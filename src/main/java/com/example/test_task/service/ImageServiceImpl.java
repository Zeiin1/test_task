package com.example.test_task.service;

import com.example.test_task.entity.Image;
import com.example.test_task.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.IOException;

@Service
public class ImageServiceImpl implements ImageService{
    @Autowired
    private ImageRepository imageRepository;

    @Override
    public String save(MultipartFile file) throws IOException {
        Image image = new Image(file.getBytes());
        imageRepository.save(image);
        String uri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/download/")
                .path(image.getId())
                .toUriString();//специальная ссылка для каждого юзера на свою
        // аватарку в базе данных перейдя по нему юзер может скачать свою аватарку
        return uri;

    }

    @Override
    public Image findImageById(String fileId) {
        return imageRepository.findImageById(fileId);
    }
}

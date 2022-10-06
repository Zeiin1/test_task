package com.example.test_task.controller;

import com.example.test_task.entity.Image;
import com.example.test_task.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/*I checked all my roots using by postman and everything works correctly*/
// 1 task
@RestController
public class ImageController {

    @Autowired
    private ImageService imageService;

    @PostMapping("/upload")
    public String saveFile(@RequestParam("image")MultipartFile image) throws IOException, HttpMediaTypeNotAcceptableException {
        String fileType = image.getContentType();
        if(fileType.contains("jpeg") || fileType.contains("jpg"))
            return imageService.save(image);
        else throw new HttpMediaTypeNotAcceptableException(
                "File type must be in format jpg or jpeg, your file type is "+ fileType);
    }
    // Сперва проверяем тип файла. Если тип файла в формате jpeg или jpg мы сохроняем файл и возвращаем
    // клиенту URI файла чтобы он дальше ее мог вставить чтобы зарегистрироваться
    // Если тип файла в другом формате мы возвращаем ему exception с сообщением



    @GetMapping("/download/{fileId}")
    public ResponseEntity<Resource> downloadFile(@PathVariable String fileId) throws Exception {
        Image image = null;
        image = imageService.findImageById(fileId);
        return  ResponseEntity.ok()
                .contentType(MediaType.IMAGE_JPEG)
                .header(HttpHeaders.CONTENT_DISPOSITION,
                        "attachment; filename=\"" + image.getId()
                                + "\"")
                .body(new ByteArrayResource(image.getData()));
    }
    // Этот рут для того чтобы клиент смог скачать аватарку (Если будет нужно)(Добавил подумав что будет нужно))


}

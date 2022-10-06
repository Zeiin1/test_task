package com.example.test_task.repository;

import com.example.test_task.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

@Repository
public interface ImageRepository extends JpaRepository<Image,String>{
   String findIdByData(byte[] data);
   Image findImageById(String id);




}

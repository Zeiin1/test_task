package com.example.test_task.entity;

import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data

//Класс User
//С помощью spring data jpa создал таблицу с этими значениями

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String userName;
    private String email;
    private String status;

    private String image_uri;//это uri я использовал чтобы скачать
    // фотографию и еще чтобы у всех юзеров была разная ссылка на фото
    public User (String userName, String email, String image_uri)
    {
        this.userName = userName;
        this.email = email;
        this.image_uri = image_uri;
    }

    public User() {

    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

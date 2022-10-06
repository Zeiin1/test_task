package com.example.test_task.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
@Entity
@Data

@Getter
@Setter
@ToString
//класс Image
//С помощью Spring Data Jpa создал таблицу в MySQL database. В этой таблице я храню image id и саму фотографию
public class Image {
        @Id
        @GeneratedValue(generator = "uuid")
        @GenericGenerator(name = "uuid", strategy = "uuid2")
        private String id;
        @Lob
        private byte [] data;


        public Image(byte[] data)
        {
            this.data =data;
        }


    public Image(String id, byte[] data) {
            this.id = id;
            this.data = data;

    }

    public Image() {

    }
}

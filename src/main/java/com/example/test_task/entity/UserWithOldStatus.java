package com.example.test_task.entity;

import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import lombok.Data;
import lombok.ToString;

@Data
@JacksonStdImpl
@ToString
//создал этот класс для 4го задания чтобы возвращать id, status и старый статус
public class UserWithOldStatus {
    private Long id;
    private String newStatus;
    private String oldStatus;
    public UserWithOldStatus(Long id,String newStatus, String oldStatus )
    {
        this.id = id;
        this.newStatus= newStatus;
        this.oldStatus = oldStatus;
    }

    public Long getId() {
        return id;
    }
}

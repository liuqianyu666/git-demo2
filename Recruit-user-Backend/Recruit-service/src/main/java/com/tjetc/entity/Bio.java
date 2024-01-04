package com.tjetc.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Bio {
    private Long id;
    private Long userId;
    private String username;
    private String phone;
    private String email;
    private String sex;
    private String position;
    private String education;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate startDay;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate endDay;
    private String introduction;

    public Bio(Long userId, String username, String phone, String email, String sex, String position, String education, LocalDate startDay, LocalDate endDay, String introduction) {
        this.userId = userId;
        this.username = username;
        this.phone = phone;
        this.email = email;
        this.sex = sex;
        this.position = position;
        this.education = education;
        this.startDay = startDay;
        this.endDay = endDay;
        this.introduction = introduction;
    }
}

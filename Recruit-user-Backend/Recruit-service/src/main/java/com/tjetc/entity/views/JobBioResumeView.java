package com.tjetc.entity.views;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobBioResumeView {
    private Long jId;
    private Long comId;
    private String jName;

    private Long rId;
    private Long bioId;
    private Long jobId;
    private String state;

    private Long bId;
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
}

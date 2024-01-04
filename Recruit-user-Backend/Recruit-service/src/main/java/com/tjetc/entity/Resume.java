package com.tjetc.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Resume {
    private Long id;//简历投递表编号
    private Long bioId;//简历编号
    private Long jobId;//工作编号
    private String state;//简历投递状态

    public Resume(Long bioId, Long jobId, String state) {
        this.bioId = bioId;
        this.jobId = jobId;
        this.state = state;
    }
}

package com.tjetc.entity.views;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobCompanyView {
    private Long jobId;//工作id
    private String jobName;//工作名字
    private Long jobSalaryMin;//工资下限
    private Long jobSalaryMax;//工资上限
    private String jEducationalRequire;//学历要求
    private Long comId;//公司id
    private String comName;//公司名
}

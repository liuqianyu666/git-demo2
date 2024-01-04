package com.tjetc.entity;

import com.tjetc.enums.EnumCompanyState;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResumeJobView {
    private Long id;//简历投递表编号
    private Long bioId;//简历编号
    private Long jobId;//工作编号
    private String jobName;//工作名字
    private Long jobSalaryMin;//工资下限
    private Long jobSalaryMax;//工资上限
    private String jobExperience;//工作经验要求
    private String jEducationalRequire;//学历要求
    private Long comId;//公司id
    private String comName;//公司名
    private String comType;//公司类型
    private String comLocation;//公司地址
    private String comLeaderName;//招聘负责人姓名
    private String phone;//招聘人电话
    private String state;//简历投递状态
}

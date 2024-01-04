package com.tjetc.entity.views;

import com.tjetc.enums.EnumCompanyState;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobDetailsView {
    private Long jobId;//工作id
    private String jobName;//工作名字
    private String jobDescribe;//工作介绍
    private Long jobSalaryMin;//工资下限
    private Long jobSalaryMax;//工资上限
    private String jobExperience;//工作经验要求
    private String jEducationalRequire;//学历要求
    private Long comId;//公司id
    private String comName;//公司名
    private String comType;//公司类型
    private EnumCompanyState comFinancingState;//公司融资状态（枚举对象）
    private String stateName;//状态名
    private String comScale;//公司规模
    private String comLocation;//公司地址
    private String comIntroduce;//公司简介
    private Long userId;//招聘负责人编号
    private String comLeaderName;//招聘负责人姓名
}

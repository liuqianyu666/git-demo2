package com.tjetc.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 【请填写功能名称】对象 t_job
 * 
 * @author ruoyi
 * @date 2023-11-06
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TJob implements Serializable
{
    private static final long serialVersionUID = 1L;

    /** 岗位id */
    private Long jId;

    /** 公司id */
    private Long comId;

    /** 岗位名称 */
    private String jName;

    /** 职位描述 */
    private String jDescribe;

    /** 每月最低工资 */
    private Long jSaralyMix;

    /** 工资上限 */
    private Long jSaralyMax;

    /** 工作经验 */
    private String jExperience;

    /** 学历要求 */
    private String jEducationalRequire;

}

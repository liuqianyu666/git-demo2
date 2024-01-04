package com.tjetc.entity;

import com.tjetc.enums.EnumCompanyState;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompanyInformation {
    private Long comId;
    private String comName;
    private String comType;
    private EnumCompanyState comState;
    private String statusName;
    private Integer comScale;
    private String comLocation;
    private String comIntroduce;
    private String comBusinessLicence;
    private String comLeaderName;
    private String comLeaderPhone;
}

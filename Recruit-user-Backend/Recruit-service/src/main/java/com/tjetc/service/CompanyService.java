package com.tjetc.service;

import com.tjetc.common.JsonResult;
import com.tjetc.entity.CompanyInformation;

public interface CompanyService {
    JsonResult findByUsername(String phoneNum);
    JsonResult modifyInfoById(CompanyInformation companyInformation);
    JsonResult findBioByComId(Long comId);
    JsonResult modifyStateByBioId(Long rId,String state);
    JsonResult findBio();
}

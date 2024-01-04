package com.tjetc.service.impl;

import com.tjetc.common.JsonResult;
import com.tjetc.dao.CompanyMapper;
import com.tjetc.entity.Bio;
import com.tjetc.entity.CompanyInformation;
import com.tjetc.entity.views.JobBioResumeView;
import com.tjetc.enums.EnumCompanyState;
import com.tjetc.service.CompanyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
@Slf4j
public class CompanyServiceImpl implements CompanyService {
    @Resource
    private CompanyMapper companyMapper;

    @Override
    public JsonResult findByUsername(String phoneNum) {
        CompanyInformation companyInformation = companyMapper.selectByUsername(phoneNum);
        if (companyInformation != null) {
            log.info(companyInformation.getComState().getName());
            log.info(companyInformation.toString());
            companyInformation.setStatusName(companyInformation.getComState().getName());
            return new JsonResult<>(0, "查询成功", companyInformation);
        } else {
            return new JsonResult<>(0, "查询失败", null);
        }
    }

    @Override
    public JsonResult modifyInfoById(CompanyInformation companyInformation) {
        log.info(companyInformation.toString());
        companyInformation.setComState(EnumCompanyState.getByName(companyInformation.getStatusName()));
        int i = companyMapper.updateComInfo(companyInformation);
        if (i==0){
            return new JsonResult<>(1,"修改失败",null);
        }else {

            return new JsonResult<>(0,"修改成功",null);
        }
    }
    @Override
    public JsonResult findBioByComId(Long comId) {
        List<JobBioResumeView> jobBioResumeViews = companyMapper.selectBioByComId(comId);
        if (jobBioResumeViews != null){
            return new JsonResult<>(0,"查询成功",jobBioResumeViews);
        }else {
            return new JsonResult<>(0,"查询失败",null);
        }
    }

    @Override
    public JsonResult modifyStateByBioId(Long rId,String state) {
        int i = companyMapper.updateStateByBioId(rId,state);
        if (i!=0){
            return new JsonResult<>(0,"修改成功",null);
        }else {
            return new JsonResult<>(1,"修改失败",null);
        }
    }
    @Override
    public JsonResult findBio() {
        List<Bio> bios = companyMapper.selectBio();
        if (bios != null){
            return new JsonResult<>(0,"查询成功",bios);
        }else {
            return new JsonResult<>(0,"查询失败",null);
        }
    }
}

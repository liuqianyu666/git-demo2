package com.tjetc.dao;

import com.tjetc.entity.Bio;
import com.tjetc.entity.CompanyInformation;
import com.tjetc.entity.views.JobBioResumeView;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CompanyMapper {
    //查看企业信息
    CompanyInformation selectByUsername(@Param("phoneNum")String phoneNum);
    int updateComInfo(CompanyInformation companyInformation);
    int insertBaseInformation(CompanyInformation companyInformation);
    //渲染投递的人员的数据
    List<JobBioResumeView> selectBioByComId(Long comId);
    //修改投递的状态
    int updateStateByBioId(@Param("rId") Long rId,@Param("state") String state);
    List<Bio> selectBio();
}

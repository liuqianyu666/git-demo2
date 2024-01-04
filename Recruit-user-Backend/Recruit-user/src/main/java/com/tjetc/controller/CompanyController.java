package com.tjetc.controller;

import com.tjetc.common.JsonResult;
import com.tjetc.entity.CompanyInformation;
import com.tjetc.entity.User;
import com.tjetc.entity.views.JobBioResumeView;
import com.tjetc.service.CompanyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpSession;
@RestController
@Slf4j
@RequestMapping("company")
public class CompanyController {
    @Autowired
    private CompanyService companyService;
    @RequestMapping("selectInfo")
    public JsonResult findComInfo(HttpSession session){
        User user = (User)session.getAttribute("comUser");
        JsonResult jsonResult = companyService.findByUsername(user.getPhone());
        return jsonResult;
    }
    @RequestMapping("updateInfo")
    public JsonResult modifyInfo(CompanyInformation companyInformation){
        System.out.println(companyInformation);
        JsonResult jsonResult = companyService.modifyInfoById(companyInformation);
        return jsonResult;
    }
    //渲染投递人员请求
    @RequestMapping("selectBio")
    public JsonResult findBio(CompanyInformation companyInformation) {
        Long comId = companyInformation.getComId();
        log.info("111");
        JsonResult bioByComId = companyService.findBioByComId(comId);
        log.info("111");
        return bioByComId;
    }

    //修改投递状态
    @RequestMapping("modifyState1")
    public JsonResult modifyState1(JobBioResumeView jobBioResumeView) {
        log.info(jobBioResumeView.toString());
        Long rId = jobBioResumeView.getRId();
        String state="待面试";
        JsonResult jsonResult = companyService.modifyStateByBioId(rId,state);
        return jsonResult;
    }

    @RequestMapping("modifyState2")
    public JsonResult modifyState2(JobBioResumeView jobBioResumeView) {
        Long rId = jobBioResumeView.getRId();
        String state="已打回";
        JsonResult jsonResult = companyService.modifyStateByBioId(rId,state);
        return jsonResult;
    }
    @RequestMapping("selectBios")
    public JsonResult findBios() {
        JsonResult jsonResult = companyService.findBio();
        return jsonResult;
    }
}

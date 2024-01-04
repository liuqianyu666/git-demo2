package com.tjetc.service;

import com.github.pagehelper.PageInfo;
import com.tjetc.common.JsonResult;
import com.tjetc.entity.Bio;
import com.tjetc.entity.Resume;
import com.tjetc.entity.User;

public interface UserService {
    JsonResult findByUsernameAndIdentity(String username,String password,Long identify);
    JsonResult registerUser(User user);
    JsonResult findBioByUserId(Long userId);
    //创建简历
    JsonResult registerBio(Bio bio);
    JsonResult changeBio(Bio bio);
    JsonResult selectNicknameById(Long id);

    JsonResult findAllJob();

    JsonResult findPageJob(int pageNum, int pageSize);

    //查询工作详情
    JsonResult findJobDetails(Long jobId);
    //添加简历投递表
    JsonResult addResume(Resume resume);
    //查询简历状态
    JsonResult findResumesByBioId(int pageNum, int pageSize,Long userId);
    //取消投递
    JsonResult delResume(Long id);
}

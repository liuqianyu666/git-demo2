package com.tjetc.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tjetc.common.JsonResult;
import com.tjetc.dao.CompanyMapper;
import com.tjetc.dao.UserMapper;
import com.tjetc.entity.*;
import com.tjetc.entity.views.JobCompanyView;
import com.tjetc.entity.views.JobDetailsView;
import com.tjetc.enums.EnumCompanyState;
import com.tjetc.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
@Slf4j
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private CompanyMapper companyMapper;
    @Override
    public JsonResult findByUsernameAndIdentity(String username, String password, Long identify) {
        User user = userMapper.selectByUsernameAndIdentity(username, identify);
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        if (user == null) {
            return new JsonResult<>(1, "用户名不存在", null);
        } else {
            if (!Objects.equals(user.getDelFlag(), "0")) {
                return new JsonResult<>(1, "用户已注销", null);
            }
            if (!Objects.equals(user.getStatus(), "0")) {
                return new JsonResult<>(1, "该账户已停用,请联系管理员", null);
            }
            if (passwordEncoder.matches(password, user.getPassword())) {
                user.setPassword("");
                return new JsonResult<>(0, "登录成功", user);
            }
            return new JsonResult<>(1, "密码错误", null);
        }
    }

    @Transactional
    @Override
    public JsonResult registerUser(User user) {
        User user1 = userMapper.selectByUsernameAndIdentity(user.getUsername(), user.getDeptId());
        if (user1 != null) {
            if (!Objects.equals(user1.getDelFlag(), "0")) {
                int id = userMapper.registerUser(user);
                if (user1.getDeptId() == 102) {
                    CompanyInformation companyInformation = new CompanyInformation(1L, "无", "无", EnumCompanyState.G, EnumCompanyState.G.getName(), 0, "无", "无", "无", user1.getUsername(), user1.getPhone());
                    companyMapper.insertBaseInformation(companyInformation);
                }
                return new JsonResult<>(0, "注册成功", id);
            }
            if (!Objects.equals(user1.getStatus(), "0")) {
                return new JsonResult<>(1, "该账户已停用", null);
            }
            return new JsonResult<>(1, "该账户已存在", null);
        } else {
            int id = userMapper.registerUser(user);
            if (user.getDeptId() == 102) {
                CompanyInformation companyInformation = new CompanyInformation(1L, "无", "无", EnumCompanyState.G, EnumCompanyState.G.getName(), 0, "无", "无", "无", user.getUsername(), user.getPhone());
                companyMapper.insertBaseInformation(companyInformation);
            }
            return new JsonResult<>(0, "注册成功", id);
        }
    }

    @Override
    public JsonResult findBioByUserId(Long userId) {
        Bio bio = userMapper.selectBioByUserId(userId);
        if(bio==null){
            return new JsonResult<>(2,"暂无简历",null);
        }
        return new JsonResult<>(0,"查询成功",bio);
    }

    @Transactional
    @Override
    public JsonResult registerBio(Bio bio) {
        int id = userMapper.insertBio(bio);
        return new JsonResult<>(0,"简历保存成功",id);
    }

    @Transactional
    @Override
    public JsonResult changeBio(Bio bio) {
        int id=userMapper.updateBio(bio);
        return new JsonResult<>(0,"简历更新成功",id);
    }

    @Override
    public JsonResult findAllJob() {
        List<JobCompanyView> list = userMapper.selectListJob();
        return new JsonResult<>(0, "查询工作成功", list);
    }

    @Override
    public JsonResult findPageJob(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<JobCompanyView> jobs = userMapper.selectListJob();
        if (jobs.size() == 0) {
            return new JsonResult<>(1, "暂未查询到数据", null);
        }
        PageInfo<JobCompanyView> jobsPageInfo = new PageInfo<>(jobs);
        return new JsonResult<>(0, "分页查询", jobsPageInfo);
    }

    //查询工作详情
    @Override
    public JsonResult findJobDetails(Long jobId) {
        JobDetailsView jobDetailsView = userMapper.selectJobByJobId(jobId);
        jobDetailsView.setStateName(jobDetailsView.getComFinancingState().getName());
        if (jobDetailsView == null) {
            return new JsonResult<>(1, "暂未查询到数据，观察后台清空", null);
        }
        return new JsonResult<>(0, "查询工作详情", jobDetailsView);
    }
    @Override
    public JsonResult selectNicknameById(Long id) {
        String nickname = userMapper.selectNicknameById(id);
        return new JsonResult(0,"查询成功",nickname);
    }
    //添加简历投递
    @Transactional
    @Override
    public JsonResult addResume(Resume resume) {
        Resume resume1 = userMapper.selectResume(resume.getBioId(), resume.getJobId());
        if(resume1!=null){
            return new JsonResult<>(1,"已向该公司投递简历，请勿重复投递",resume1);
        }
        int id = userMapper.insertSendBio(resume);
        return new JsonResult<>(0,"简历投递成功",id);
    }
    //获取简历
    @Override
    public JsonResult findResumesByBioId(int pageNum, int pageSize,Long userId) {
        PageHelper.startPage(pageNum, pageSize);
        Bio bio = userMapper.selectBioByUserId(userId);
        if(bio==null){
            return new JsonResult<>(1,"简历尚未完成，请先完善简历",null);
        }
        List<ResumeJobView> resumes=userMapper.selectResumesByBioId(bio.getId());
        if(resumes.size()==0){
            return new JsonResult<>(1,"你还尚未投送简历",null);
        }
        PageInfo<ResumeJobView> resumesPageInfo=new PageInfo<>(resumes);
        return new JsonResult<>(0,"查询成功",resumesPageInfo);
    }
    //取消投递简历
    @Override
    @Transactional
    public JsonResult delResume(Long id) {
        int i = userMapper.cancelSend(id);
        if(i==0){
            return new JsonResult<>(1,"取消失败，请观察后台信息",null);
        }
        return new JsonResult<>(0,"取消成功",i);
    }
}

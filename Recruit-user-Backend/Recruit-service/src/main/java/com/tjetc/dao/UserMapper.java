package com.tjetc.dao;

import com.tjetc.entity.Bio;
import com.tjetc.entity.Resume;
import com.tjetc.entity.ResumeJobView;
import com.tjetc.entity.User;
import com.tjetc.entity.views.JobCompanyView;
import com.tjetc.entity.views.JobDetailsView;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    //登录查询
    User selectByUsernameAndIdentity(@Param("username")String username,@Param("identify")Long identify);
    //注册
    int registerUser(User user);
    //获取简历信息
    Bio selectBioByUserId(Long userId);
    //新建简历
    int insertBio(Bio bio);
    //修改简历
    int updateBio(Bio bio);
//    //公司查询
//    List<> selectListPosition();
//    //模糊查询
//    List<> selectListByKeyword(String keyword);
    //工作岗位查询
    List<JobCompanyView> selectListJob();
    //工作详情（包含公司信息）
    JobDetailsView selectJobByJobId(@Param("jobId") Long jobId);
    //简历投递
    int insertSendBio(@Param("bioId")String bioId,@Param("jobId")String jobId);
    String selectNicknameById(Long id);
    //查询简历是否投递
    Resume selectResume(@Param("bioId")Long bioId, @Param("jobId")Long jobId);
    //简历投递
    int insertSendBio(Resume resume);
    //查看简历投递状况
    List<ResumeJobView> selectResumesByBioId(@Param("bioId")Long bioId);
    //取消投递
    int cancelSend(Long id);
}

package com.tjetc.controller;

import com.tjetc.common.JsonResult;
import com.tjetc.entity.Bio;
import com.tjetc.entity.Resume;
import com.tjetc.entity.TJob;
import com.tjetc.entity.User;
import com.tjetc.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping("user")
@Slf4j
public class UserController {
    @Autowired
    private UserService userService;
    JsonResult jsonResult;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate startDay;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate endDay;

    @RequestMapping("login")
    public JsonResult login(String username, String password, String identify, HttpSession session) {
        Long identifyNum = Long.parseLong(identify);
        //调用service的根据用户名或者密码返回用户信息
        jsonResult = userService.findByUsernameAndIdentity(username, password, identifyNum);
        if (jsonResult.getState() == 0) {
            //session存储登录信息
            User data = (User) jsonResult.getData();
            if (data.getDeptId() == 101L) {
                session.setAttribute("user", jsonResult.getData());
            }else {
                session.setAttribute("comUser",jsonResult.getData());
            }
            jsonResult = new JsonResult<>(0, session.getId(), jsonResult.getData());
        }
        return jsonResult;
    }

    @RequestMapping("register")
    public JsonResult register(String username, String phone, String email, String sex, String password, String identify) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        Long identifyNum = Long.parseLong(identify);
        String encode = passwordEncoder.encode(password);
        User user = new User(username, username, encode, identifyNum, email, phone, sex, LocalDateTime.now(), username);
        jsonResult = userService.registerUser(user);
        return jsonResult;
    }

    @RequestMapping("logout")
    public JsonResult logout(HttpSession session) {
        session.invalidate();
//            session.removeAttribute("user");
        jsonResult = new JsonResult<>(0, "登录信息已删除", null);
        return jsonResult;
    }

    @RequestMapping("getBio")
    public JsonResult getBio(HttpSession session) {
        User user = (User) session.getAttribute("user");
        jsonResult = userService.findBioByUserId(user.getId());
        return jsonResult;
    }

    @RequestMapping("setBio")
    public JsonResult setBio(String username, String phone, String email, String sex, String position, String education, String date1, String date2, String desc, HttpSession session) {
        startDay = LocalDate.parse(date1);
        endDay = LocalDate.parse(date2);
        if (desc == null) {
            desc = "空";
        }
        User user = (User) session.getAttribute("user");
        Bio bio = new Bio(user.getId(), username, phone, email, sex, position, education, startDay, endDay, desc);
        jsonResult = userService.registerBio(bio);
        return jsonResult;
    }

    @RequestMapping("exchangeBio")
    public JsonResult exchangeBio(String username, String phone, String email, String sex, String position, String education, String date1, String date2, String desc, HttpSession session) {
        startDay = LocalDate.parse(date1);
        endDay = LocalDate.parse(date2);
        if (desc == null) {
            desc = "空";
        }
        User user = (User) session.getAttribute("user");
        Bio bio = new Bio(user.getId(), username, phone, email, sex, position, education, startDay, endDay, desc);
        jsonResult = userService.changeBio(bio);
        return jsonResult;
    }

    @RequestMapping("home/selectJobs")
    public JsonResult selectJobs(String pageNum, String pageSize) {
        int pageNumNum = Integer.parseInt(pageNum);
        int pageSizeNum = Integer.parseInt(pageSize);
        jsonResult = userService.findPageJob(pageNumNum, pageSizeNum);
        return jsonResult;
    }

    @RequestMapping("home/Information")
    public JsonResult selectJobDetails(String jobId) {
        Long jobIdNum = Long.parseLong(jobId);
        jsonResult = userService.findJobDetails(jobIdNum);
        return jsonResult;
    }

    @RequestMapping("SendResume")
    public JsonResult sendResume(String bioId, String jobId) {
        Long bioIdNum = Long.parseLong(bioId);
        Long jobIdNum = Long.parseLong(jobId);
        Resume resume = new Resume(bioIdNum, jobIdNum, "未处理");
        jsonResult = userService.addResume(resume);
        return jsonResult;
    }

    @RequestMapping("findSends")
    public JsonResult selectResumes(String pageNum, String pageSize, HttpSession session) {
        int pageNumNum = Integer.parseInt(pageNum);
        int pageSizeNum = Integer.parseInt(pageSize);
        User user = (User) session.getAttribute("user");
        jsonResult = userService.findResumesByBioId(pageNumNum, pageSizeNum, user.getId());
        return jsonResult;
    }

    @RequestMapping("cancelSend")
    public JsonResult cancelSend(String id) {
        Long idNum = Long.parseLong(id);
        jsonResult = userService.delResume(idNum);
        return jsonResult;
    }
}

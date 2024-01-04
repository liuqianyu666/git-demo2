package com.tjetc.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {
    private Long id;//用户id
    private String username;//用户账号
    private String nickName;//用户昵称
    private String password;//用户密码
    private Long deptId;//用户部门
    private String email;//邮箱
    private String phone;//手机号
    private String sex;//性别
    //创建时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;
    //更新时间
    //返回或者接收json的格式定义
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateTime;
    private String status;//账号是否停用
    private String delFlag;//账号是否删除
    private String createBy;//创建者

    public User(String username, String nickName, String password, Long deptId, String email, String phone, String sex, LocalDateTime createTime, String createBy) {
        this.username = username;
        this.nickName = nickName;
        this.password = password;
        this.deptId = deptId;
        this.email = email;
        this.phone = phone;
        this.sex = sex;
        this.createTime = createTime;
        this.createBy = createBy;
    }
}

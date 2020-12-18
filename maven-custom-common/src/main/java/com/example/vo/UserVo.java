package com.example.vo;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * <p>
 * 用户表
 * </p>
 *
 * @author LLY
 * @since 2020-12-11
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("user")
public class UserVo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户id
     */
    @TableId("user_id")
    private Integer userId;

    /**
     * 用户登录名
     */
    @TableField("login_name")
    private String loginName;

    /**
     * 用户密码
     */
    @TableField("password")
    private String password;

    /**
     * 昵称
     */
    @TableField("name")
    private String name;

    /**
     * 电话
     */
    @TableField("phone")
    private String phone;

    /**
     * 创建时间
     */
    @TableField("create_time")
    @JSONField(format = "yyyy-MM-dd hh:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date createTime;


}

package com.example.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * <p>
 * 员工表
 * </p>
 *
 * @author LLY
 * @since 2020-12-11
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("staff")
public class StaffVo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户id
     */
    @TableId(value = "staff_id", type = IdType.AUTO)
    private Integer staffId;

    /**
     * 登录用户名
     */
    @TableField("login_name")
    private String loginName;

    /**
     * 登录密码
     */
    @TableField("password")
    private String password;

    /**
     * 昵称
     */
    @TableField("name")
    private String name;

    /**
     * 头像
     */
    @TableField("head_image")
    private String headImage;

    /**
     * 员工邮箱
     */
    @TableField("email")
    private String email;

    /**
     * 员工电话
     */
    @TableField("phone")
    private String phone;

    /**
     * 员工性别
     */
    @TableField("sex")
    private Integer sex;

    /**
     * 创建时间
     */
    @TableField("create_time")
    private Date createTime;


}

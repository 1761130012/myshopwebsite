package com.example.vo;

import com.alibaba.excel.annotation.ExcelProperty;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;

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
    @ExcelProperty(value = "昵称")
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
    @ExcelProperty(value = "邮箱")
    private String email;

    /**
     * 员工电话
     */
    @TableField("phone")
    @ExcelProperty(value = "电话")
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
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    @TableField(exist = false)
    @ExcelProperty(value = "性别")
    private String sexStr;
}

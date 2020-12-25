package com.example.vo;

import com.alibaba.fastjson.annotation.JSONField;
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
 * 采购记录表
 * </p>
 *
 * @author LLY
 * @since 2020-12-11
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName(value = "purchase", resultMap = "purchaseMap")
public class PurchaseVo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 采购单编号
     */
    @TableId("pur_id")
    private String purId;

    /**
     * 采购主题
     */
    @TableField("title")
    private String title;

    /**
     * 采购员工
     */
    @TableField("pur_staff_id")
    private Integer purStaffId;

    /**
     * 采购日期
     */
    @TableField("data_time")
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    @JSONField(format = "yyyy-MM-dd hh:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss", timezone = "GMT+8")
    private Date dataTime;

    /**
     * 采购总金额
     */
    @TableField("money")
    private Double money;

    /**
     * 采购状态
     */
    @TableField("state")
    private Integer state;

    /**
     * 审批人
     */
    @TableField("apr_staff_id")
    private Integer aprStaffId;

    /**
     * 审批日期
     */
    @TableField("apr_date")
    private Date aprDate;

    /**
     * 删除状态
     */
    @TableField("is_delete")
    private Integer isDelete;

    /*
     *申请人
     */
    @TableField(exist = false)
    private StaffVo purStaff;
    /*
     *审批人
     */
    @TableField(exist = false)
    private StaffVo aprStaff;

    //开始日期
    @TableField(exist = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JSONField(format = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date startDataTime;

    //结束日期
    @TableField(exist = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JSONField(format = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date endDataTime;

}

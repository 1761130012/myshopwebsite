package com.example.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 采购记录表
 * </p>
 *
 * @author LLY
 * @since 2020-12-10
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("purchase")
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
    private LocalDateTime dataTime;

    /**
     * 采购总金额
     */
    @TableField("money")
    private Float money;

    /**
     * 采购状态 0待审批,1通过 ,2驳回
     */
    @TableField("state")
    private Integer state;

    /**
     * 审批人
     */
    @TableField("approval_staff_id")
    private Integer approvalStaffId;

    /**
     * 审批日期
     */
    @TableField("approval_date")
    private LocalDateTime approvalDate;

    /**
     * 删除状态 0:显示,1: 已经删除,隐藏
     */
    @TableField("is_delete")
    private Integer isDelete;


}

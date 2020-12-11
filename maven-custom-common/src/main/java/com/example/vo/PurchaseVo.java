package com.example.vo;

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
 * 采购记录表
 * </p>
 *
 * @author LLY
 * @since 2020-12-11
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


}

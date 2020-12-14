package com.example.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 订单表
 * </p>
 *
 * @author LLY
 * @since 2020-12-11
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("order_goods")
public class OrderVo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 订单id
     */
    @TableId("order_id")
    private String orderId;

    /**
     * 用户id
     */
    @TableField("user_id")
    private Integer userId;

    /**
     * 订单时间
     */
    @TableField("time")
    private Date time;

    /**
     * 订单总金额
     */
    @TableField("money")
    private Double money;

    /**
     * 备注
     */
    @TableField("remark")
    private String remark;

    /**
     * 物流状态
     */
    @TableField("state")
    private Integer state;

    /**
     * 删除状态
     */
    @TableField("is_delete")
    private Integer isDelete;


}

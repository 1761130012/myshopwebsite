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
 * 订单表
 * </p>
 *
 * @author LLY
 * @since 2020-12-10
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("order")
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
    private LocalDateTime time;

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
     * 物流状态 0 未发货 1 已发货 2 到达商户 3 已收货
     */
    @TableField("state")
    private Integer state;

    /**
     * 删除状态 0:显示,1: 已经删除,隐藏
     */
    @TableField("is_delete")
    private Integer isDelete;


}

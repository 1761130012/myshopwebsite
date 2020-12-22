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
 * 订单表
 * </p>
 *
 * @author LLY
 * @since 2020-12-10
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName(value = "order_goods",resultMap = "joinType")
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
     * 用户id
     */
    @TableField("shop_id")
    private Integer shopId;


    /**
     * 订单开始时间
     */
    @TableField("start_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date startTime;

    /**
     * 订单结束时间
     */
    @TableField("end_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date endTime;

    /**
     * 支付状态
     * 0 未支付 1 已支付
     */
    @TableField("pay_state")
    private Integer payState;


    /**
     * 订单时间
     */
    @TableField("time")
    @JSONField(format = "yyyy-MM-dd hh:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
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
     * 物流状态 0 未发货 1 已发货 2 到达商户 3 已收货
     */
    @TableField("state")
    private Integer state;

    /**
     * 删除状态 0:显示,1: 已经删除,隐藏
     */
    @TableField("is_delete")
    private Integer isDelete;

    @TableField(exist = false)
    private UserVo userVo;


}

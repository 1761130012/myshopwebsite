package com.example.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * <p>
 * 订单详情(商品)表
 * </p>
 *
 * @author LLY
 * @since 2020-12-11
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName(value = "order_shop", resultMap = "joinType")
public class OrderShopVo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 编号
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 订单号
     */
    @TableField("order_id")
    private String orderId;

    /**
     * 商品id
     */
    @TableField("goods_id")
    private Integer goodsId;

    /**
     * 单价
     */
    @TableField("goods_price")
    private Float goodsPrice;

    /**
     * 购买数量
     */
    @TableField("pay_number")
    private Integer payNumber;

    /**
     *   商品详情
     */
    @TableField(exist = false)
    private GoodsVo goodsVo;

}

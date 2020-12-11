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
 * 进出库记录
 * </p>
 *
 * @author LLY
 * @since 2020-12-11
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("warehouse_inout_info")
public class WarehouseInoutInfoVo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 编号
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 仓库编号
     */
    @TableField("warehouse_id")
    private Integer warehouseId;

    /**
     * 采购编号
     */
    @TableField("pur_id")
    private String purId;

    /**
     * 订单编号
     */
    @TableField("order_id")
    private String orderId;

    /**
     * 商品id
     */
    @TableField("goods_id")
    private Integer goodsId;

    /**
     * 商品出厂价
     */
    @TableField("factory_price")
    private Double factoryPrice;

    /**
     * 进出库量
     */
    @TableField("count")
    private Integer count;

    /**
     * 状态
     */
    @TableField("state")
    private Integer state;


}

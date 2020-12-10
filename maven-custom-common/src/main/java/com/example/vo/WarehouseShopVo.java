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
 * 仓库详情表
 * </p>
 *
 * @author LLY
 * @since 2020-12-10
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("warehouse_shop")
public class WarehouseShopVo implements Serializable {

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
     * 商品id 一个仓库 唯一商品id
     */
    @TableField("goods_id")
    private Integer goodsId;

    /**
     * 商品出厂价
     */
    @TableField("factory_price")
    private Float factoryPrice;

    /**
     * 商品存量
     */
    @TableField("count")
    private Integer count;


}

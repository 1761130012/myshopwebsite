package com.example.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * <p>
 * 采购详情表
 * </p>
 *
 * @author LLY
 * @since 2020-12-10
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("purchase_shop")
public class PurchaseShopVo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 编号
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 采购单编号
     */
    @TableField("pur_id")
    private String purId;

    /**
     * 供应商编号
     */
    @TableField("sup_id")
    private Integer supId;

    /**
     * 商品编号
     */
    @TableField("shop_id")
    private Integer shopId;

    /**
     * 商品数量
     */
    @TableField("shop_count")
    private Integer shopCount;

    /**
     * 出厂价
     */
    @TableField("factory_price")
    private Float factoryPrice;

    /**
     * 生产日期
     */
    @TableField("create_time")
    private LocalDate createTime;

    /**
     * 保质期
     */
    @TableField("save_time")
    private Integer saveTime;


}

package com.example.vo;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.IdType;
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
 * 采购详情表
 * </p>
 *
 * @author LLY
 * @since 2020-12-11
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName(value = "purchase_shop", resultMap = "purchaseShopMap")
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
    @TableField("goods_id")
    private Integer goodsId;

    /**
     * 商品数量
     */
    @TableField("goods_count")
    private Integer goodsCount;

    /**
     * 出厂价
     */
    @TableField("factory_price")
    private Double factoryPrice;

    /**
     * 生产日期
     */


    @TableField("create_time")
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    @JSONField(format = "yyyy-MM-dd hh:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss", timezone = "GMT+8")
    private Date createTime;

    /**
     * 保质期
     */
    @TableField("save_time")
    private Integer saveTime;

    /*
     *供货商
     */
    @TableField(exist = false)
    private SupplierVo supplierVo;

    /**
     * 商品
     */
    @TableField(exist = false)
    private GoodsVo goodsVo;
}

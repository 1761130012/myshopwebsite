package com.example.vo;

import com.alibaba.excel.annotation.ExcelProperty;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * 商品表
 * </p>
 *
 * @author LLY
 * @since 2020-12-11
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName(value = "goods", resultMap = "joinType")
public class GoodsVo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 商品编号
     */
    @TableId(value = "goods_id", type = IdType.AUTO)
    private Integer goodsId;

    /**
     * 商品名称
     */
    @TableField("name")
    @ExcelProperty(value = "名称")
    private String name;

    /**
     * 商品类型id
     */
    @TableField("type_id")
    private Integer typeId;

    /**
     * 商品售价
     */
    @TableField("price")
    @ExcelProperty(value = "售价")
    private Double price;

    /**
     * 商品描述
     */
    @TableField("remark")
    @ExcelProperty(value = "描述")
    private String remark;

    @TableField(exist = false)
    private GoodsTypeVo goodsTypeVo;

    @TableField(exist = false)
    private String image;

    /**
     * 数量总和
     */
    @TableField(exist = false)
    private Integer countNum;

    /**
     * 图片数
     */
    @TableField(exist = false)
    private List<String> images;
}

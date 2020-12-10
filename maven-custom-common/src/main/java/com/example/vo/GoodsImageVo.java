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
 * 商品图片表
 * </p>
 *
 * @author LLY
 * @since 2020-12-10
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("goods_image")
public class GoodsImageVo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 商品图片编号
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 商品编号
     */
    @TableField("goods_id")
    private Integer goodsId;

    /**
     * 商品图片地址
     */
    @TableField("adders")
    private String adders;


}

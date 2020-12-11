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
 * 仓库表
 * </p>
 *
 * @author LLY
 * @since 2020-12-11
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("warehouse")
public class WarehouseVo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 编号
     */
    @TableId(value = "warehouse_id", type = IdType.AUTO)
    private Integer warehouseId;

    /**
     * 仓库名称
     */
    @TableField("name")
    private String name;

    /**
     * 省
     */
    @TableField("province_id")
    private Integer provinceId;

    /**
     * 市
     */
    @TableField("city_id")
    private Integer cityId;

    /**
     * 区/县
     */
    @TableField("area_id")
    private Integer areaId;

    /**
     * 仓库详细地址
     */
    @TableField("address")
    private String address;

    /**
     * 现存数量
     */
    @TableField("new_count")
    private Integer newCount;

    /**
     * 仓库上限
     */
    @TableField("max_count")
    private Integer maxCount;
}

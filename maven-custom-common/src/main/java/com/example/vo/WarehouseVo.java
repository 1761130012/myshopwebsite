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
 * @since 2020-12-10
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
     * 仓库地址
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

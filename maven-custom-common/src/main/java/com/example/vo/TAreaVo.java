package com.example.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * <p>
 * 区/县
 * </p>
 *
 * @author LLY
 * @since 2020-12-11
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("t_area")
public class TAreaVo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 区/县id
     */
    @TableField("area_id")
    private Integer areaId;

    /**
     * 区/县名
     */
    @TableField("area_name")
    private String areaName;

    /**
     * 市id
     */
    @TableField("city_id")
    private Integer cityId;


}

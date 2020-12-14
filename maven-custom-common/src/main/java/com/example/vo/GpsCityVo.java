package com.example.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * <p>
 * 市
 * </p>
 *
 * @author LLY
 * @since 2020-12-13
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("gps_city")
public class GpsCityVo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 市id
     */
    @TableId("city_id")
    private Integer cityId;

    /**
     * 市名
     */
    @TableField("name")
    private String name;

    /**
     * 省id
     */
    @TableField("province_id")
    private Integer provinceId;


}

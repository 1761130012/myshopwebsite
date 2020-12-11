package com.example.vo;

import com.baomidou.mybatisplus.annotation.TableField;
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
 * @since 2020-12-11
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("t_city")
public class TCityVo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 市id
     */
    @TableField("city_id")
    private Integer cityId;

    /**
     * 市名
     */
    @TableField("city_name")
    private String cityName;

    /**
     * 省id
     */
    @TableField("province_id")
    private Integer provinceId;


}

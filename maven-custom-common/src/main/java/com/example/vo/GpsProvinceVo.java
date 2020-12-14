package com.example.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * <p>
 * 省
 * </p>
 *
 * @author LLY
 * @since 2020-12-13
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("gps_province")
public class GpsProvinceVo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 省id
     */
    @TableId("province_id")
    private Integer provinceId;

    /**
     * 省名
     */
    @TableField("name")
    private String name;


}

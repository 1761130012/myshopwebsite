package com.example.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
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
 * @since 2020-12-13
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("gps_area")
public class GpsAreaVo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 区/县id
     */
    @TableId("area_id")
    private Integer areaId;

    /**
     * 区/县名
     */
    @TableField("name")
    private String name;

    /**
     * 市id
     */
    @TableField("city_id")
    private Integer cityId;


}

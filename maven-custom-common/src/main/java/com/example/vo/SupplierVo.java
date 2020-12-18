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
 * 供应商表
 * </p>
 *
 * @author LLY
 * @since 2020-12-11
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName(value = "supplier",resultMap = "joinType")
public class SupplierVo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 店铺id
     */
    @TableId(value = "sup_id", type = IdType.AUTO)
    private Integer supId;

    /**
     * 供应商名
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
     * 供应商详细地址
     */
    @TableField("address")
    private String address;

    /**
     * 联系电话
     */
    @TableField("phone")
    private String phone;

    /**
     * 联系人
     */
    @TableField("join_name")
    private String joinName;

    /**
     *省
     */
    @TableField(exist = false)
    private GpsProvinceVo gpsProvinceVo;

    /**
     *市
     */
    @TableField(exist = false)
    private GpsCityVo gpsCityVo;

    /**
     *县
     */
    @TableField(exist = false)
    private GpsAreaVo gpsAreaVo;

}

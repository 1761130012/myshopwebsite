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
 * 店铺表
 * </p>
 *
 * @author LLY
 * @since 2020-12-11
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName(value = "shop",resultMap = "selectPageVoMap")
public class ShopVo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 店铺id
     */
    @TableId(value = "shop_id", type = IdType.AUTO)
    private Integer shopId;

    /**
     * 商铺名
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
     * 店铺详细地址
     */
    @TableField("address")
    private String address;

    /**
     * 联系电话
     */
    @TableField("phone")
    private String phone;

    /**
     * 联系人  0 未审核 1 通过 2 驳回  3上线 4 下线
     */
    @TableField("join_name")
    private String joinName;

    /**
     * 用户id
     */
    @TableField("user_id")
    private Integer userId;

    /**
     * 状态
     */
    @TableField("state")
    private Integer state;


    @TableField(exist = false)
    private UserVo userVo;

    @TableField(exist = false)
    private GpsProvinceVo provinceVo;

    @TableField(exist = false)
    private GpsCityVo cityVo;

    @TableField(exist = false)
    private GpsAreaVo areaVo;
}

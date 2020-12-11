package com.example.vo;

import com.baomidou.mybatisplus.annotation.TableField;
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
 * @since 2020-12-11
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("t_province")
public class TProvinceVo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 省id
     */
    @TableField("province_id")
    private Integer provinceId;

    /**
     * 省名
     */
    @TableField("province_name")
    private String provinceName;


}

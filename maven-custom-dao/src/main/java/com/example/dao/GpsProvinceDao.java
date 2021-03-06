package com.example.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.vo.GpsProvinceVo;

import java.util.List;

/**
 * <p>
 * 省 Mapper 接口
 * </p>
 *
 * @author LLY
 * @since 2020-12-13
 */
public interface GpsProvinceDao extends BaseMapper<GpsProvinceVo> {

    List<GpsProvinceVo> select(GpsProvinceVo gpsProvinceVo);
}

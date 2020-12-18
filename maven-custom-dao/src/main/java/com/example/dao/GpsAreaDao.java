package com.example.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.vo.GpsAreaVo;

import java.util.List;

/**
 * <p>
 * 区/县 Mapper 接口
 * </p>
 *
 * @author LLY
 * @since 2020-12-13
 */
public interface GpsAreaDao extends BaseMapper<GpsAreaVo> {

    List<GpsAreaVo> select(GpsAreaVo gpsAreaVo);
}

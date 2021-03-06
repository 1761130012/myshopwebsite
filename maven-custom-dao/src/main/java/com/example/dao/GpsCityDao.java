package com.example.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.vo.GpsCityVo;

import java.util.List;

/**
 * <p>
 * 市 Mapper 接口
 * </p>
 *
 * @author LLY
 * @since 2020-12-13
 */
public interface GpsCityDao extends BaseMapper<GpsCityVo> {

    List<GpsCityVo> select(GpsCityVo gpsCityVo);
}

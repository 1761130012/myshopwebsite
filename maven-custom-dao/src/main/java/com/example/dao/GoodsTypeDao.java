package com.example.dao;

import com.example.vo.GoodsTypeVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 商品类型表 Mapper 接口
 * </p>
 *
 * @author LLY
 * @since 2020-12-10
 */
public interface GoodsTypeDao extends BaseMapper<GoodsTypeVo> {

    List<GoodsTypeVo> select();
}

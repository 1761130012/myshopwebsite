package com.example.dao;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.vo.GoodsTypeVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

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

    Page<GoodsTypeVo> selectTypeAll(@Param("page") Page<GoodsTypeVo> page, @Param("goodsTypeVo") GoodsTypeVo goodsTypeVo);
}

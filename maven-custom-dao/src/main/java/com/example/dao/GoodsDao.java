package com.example.dao;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.vo.GoodsVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.vo.UserVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 商品表 Mapper 接口
 * </p>
 *
 * @author LLY
 * @since 2020-12-10
 */
public interface GoodsDao extends BaseMapper<GoodsVo> {


    Page<GoodsVo> selectPageVo(@Param("goodsVoPage") Page<GoodsVo> goodsVoPage, @Param("goodsVo") GoodsVo goodsVo);

}

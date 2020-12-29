package com.example.dao;

import com.example.vo.GoodsImageVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

import java.util.List;

/**
 * <p>
 * 商品图片表 Mapper 接口
 * </p>
 *
 * @author LLY
 * @since 2020-12-10
 */
public interface GoodsImageDao extends BaseMapper<GoodsImageVo> {
    List<GoodsImageVo> queryGoodsImgBygId(int goodId);

    int deleteGoodsImage(int id);

    /**
     * 根据 商品 id 查询 商品 地址
     *
     * @param goodsId
     * @return
     */
    List<String> selectAddressByGoodsId(@Param("goodsId") Integer goodsId);
}

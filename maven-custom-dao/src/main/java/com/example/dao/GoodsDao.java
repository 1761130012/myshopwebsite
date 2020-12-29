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

    /**
     * 根据 类型 id 查询 商品 id
     *
     * @param typeId
     * @return
     */
    List<GoodsVo> selectShopIdByTypeId(@Param("typeId") Integer typeId);

    /**
     * 根据 商品id 查询 类型 id
     *
     * @param goodsId
     * @return
     */
    Integer selectGoodsTypeIdByGoodsId(@Param("goodsId") Integer goodsId);

    /**
     * 根据 商品 id 查询 单价
     *
     * @param goodsId
     * @return
     */
    Float selectPriceByGoodsId(Integer goodsId);

    List<GoodsVo> list();

    /**
     * 根据商品 id 查询 商品
     *
     * @param goodsIds
     * @return
     */
    List<GoodsVo> selectGoodsVoByIds(@Param("goodsIds") List<Integer> goodsIds);
}

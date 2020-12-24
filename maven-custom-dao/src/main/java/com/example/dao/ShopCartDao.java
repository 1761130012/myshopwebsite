package com.example.dao;

import com.example.vo.ShopCartVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 购物车表 Mapper 接口
 * </p>
 *
 * @author LLY
 * @since 2020-12-10
 */
public interface ShopCartDao extends BaseMapper<ShopCartVo> {

    List<ShopCartVo> select(ShopCartVo shopCartVo);

    void updateCar(ShopCartVo shopCartVo);

    int updateNum(ShopCartVo shopCartVo);
}

package com.example.dao;

import com.example.vo.OrderShopVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 订单详情(商品)表 Mapper 接口
 * </p>
 *
 * @author LLY
 * @since 2020-12-10
 */
public interface OrderShopDao extends BaseMapper<OrderShopVo> {

    List<OrderShopVo> select(OrderShopVo orderShopVo);
}

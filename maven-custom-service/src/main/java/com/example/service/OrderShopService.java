package com.example.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.vo.OrderShopVo;
import com.example.vo.OrderVo;

import java.util.List;

/**
 * <p>
 * 订单表 服务类
 * </p>
 *
 * @author LLY
 * @since 2020-12-08
 */
public interface OrderShopService extends IService<OrderShopVo> {

    List<OrderShopVo> select(OrderShopVo orderShopVo);

}

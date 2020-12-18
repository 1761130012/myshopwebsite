package com.example.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.vo.OrderVo;
import com.example.vo.SupplierVo;

/**
 * <p>
 * 订单表 服务类
 * </p>
 *
 * @author LLY
 * @since 2020-12-08
 */
public interface OrderService extends IService<OrderVo> {

    Page<OrderVo> selectPageVo(Page<OrderVo> orderVoPage, OrderVo orderVo);

    int delete(String id);

    int update(OrderVo orderVo);

    int add(OrderVo orderVo);
}

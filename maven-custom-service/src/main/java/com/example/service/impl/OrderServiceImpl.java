package com.example.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.dao.OrderDao;
import com.example.service.OrderService;
import com.example.vo.OrderVo;
import com.example.vo.SupplierVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 订单表 服务实现类
 * </p>
 *
 * @author LLY
 * @since 2020-12-08
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderDao, OrderVo> implements OrderService {

    @Autowired
    OrderDao orderDao;

    @Override
    public Page<OrderVo> selectPageVo(Page<OrderVo> orderVoPage, OrderVo orderVo) {

        return orderDao.selectPageVo(orderVoPage,orderVo);
    }
}

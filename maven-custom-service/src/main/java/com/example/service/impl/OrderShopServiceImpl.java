package com.example.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.dao.OrderShopDao;
import com.example.service.OrderShopService;
import com.example.vo.OrderShopVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 订单表 服务实现类
 * </p>
 *
 * @author LLY
 * @since 2020-12-08
 */
@Service
public class OrderShopServiceImpl extends ServiceImpl<OrderShopDao, OrderShopVo> implements OrderShopService {

    @Autowired
    OrderShopDao orderShopDao;

    @Override
    public List<OrderShopVo> select(OrderShopVo orderShopVo) {
        return orderShopDao.select(orderShopVo);
    }

    @Override
    public int add(OrderShopVo orderShopVo) {
        return orderShopDao.insert(orderShopVo);
    }

}

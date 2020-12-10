package com.example.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.dao.OrderDao;
import com.example.service.OrderService;
import com.example.vo.OrderVo;
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

}

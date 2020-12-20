package com.example.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.dao.OrderDao;
import com.example.dao.OrderShopDao;
import com.example.dao.ShopDao;
import com.example.dao.UserDao;
import com.example.service.OrderService;
import com.example.vo.OrderShopVo;
import com.example.vo.OrderVo;
import com.example.vo.SupplierVo;
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
public class OrderServiceImpl extends ServiceImpl<OrderDao, OrderVo> implements OrderService {

    @Autowired
    OrderDao orderDao;

    @Autowired
    private OrderShopDao orderShopDao;

    @Autowired
    private UserDao userDao;
    @Autowired
    private ShopDao shopDao;

    @Override
    public Page<OrderVo> selectPageVo(Page<OrderVo> orderVoPage, OrderVo orderVo) {

        return orderDao.selectPageVo(orderVoPage,orderVo);
    }

    @Override
    public int delete(String id) {
        return orderDao.deleteById(id);
    }

    @Override
    public int update(OrderVo orderVo) {
        return orderDao.updateById(orderVo);
    }

    @Override
    public int add(OrderVo orderVo) {
        return orderDao.insert(orderVo);
    }



    @Override
    public List<OrderShopVo> selectOrderShopById(String orderId) {
        return orderShopDao.selectListByOrderId(orderId);
    }

    @Override
    public boolean deleteOrderShopById(String orderShopId) {
        return orderShopDao.deleteById(orderShopId) > 0;
    }

    @Override
    public boolean deleteBathOrderShopByIds(List<Integer> list) {
        return orderShopDao.deleteBatchIds(list) > 0;
    }

    @Override
    public Float selectCountMoneyByOrderId(String orderId) {
        Float countMoney = orderShopDao.selectCountMoneyByOrderId(orderId);

        //进行 写到总 价格 中
        orderDao.updateCountMoneyById(orderId, countMoney);
        return countMoney;
    }

    @Override
    public OrderVo selectPayStateByOrderId(String orderId) {
        return orderDao.selectPayStateByOrderId(orderId);
    }

    @Override
    public Page<OrderShopVo> selectPageVoByOrderId(Page<OrderShopVo> page, String orderId) {
        return orderShopDao.selectPageVoByOrderId(page, orderId);
    }

    @Override
    public boolean updateStateByOrderId(String orderId) {
        OrderVo orderVo = new OrderVo();
        orderVo.setOrderId(orderId);
        //设置状态为 收货
        orderVo.setState(3);
        return orderDao.updateById(orderVo) > 0;
    }

    @Override
    public boolean updatePayNumberByOrderShopId(List<OrderShopVo> orderShopVos) {
        for (OrderShopVo orderShopVo : orderShopVos) {
            //进行 修改
            if (orderShopDao.updateById(orderShopVo) == 0) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean updatePayStateByOrderId(String orderId) {
        OrderVo orderVo = new OrderVo();
        orderVo.setOrderId(orderId);
        //设置状态为 收货
        orderVo.setPayState(1);
        return orderDao.updateById(orderVo) > 0;
    }

    @Override
    public List<OrderVo> queryTimeCountMoneyByTime(String userLoginName, OrderVo orderVo) {
        //根据 登录 名 进行 查询  商户 id
        Integer shopId = shopDao.selectIdByUserId(userDao.selectIdByLoginName(userLoginName));
        return orderDao.selectTimeCountMoneyByTime(shopId, orderVo);
    }
}

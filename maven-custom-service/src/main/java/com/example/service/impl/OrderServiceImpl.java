package com.example.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.dao.*;
import com.example.service.OrderService;
import com.example.vo.GoodsTypeVo;
import com.example.vo.GoodsVo;
import com.example.vo.OrderShopVo;
import com.example.vo.OrderVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    private OrderDao orderDao;

    @Autowired
    private OrderShopDao orderShopDao;

    @Autowired
    private UserDao userDao;
    @Autowired
    private ShopDao shopDao;

    @Autowired
    private GoodsDao goodsDao;
    @Autowired
    private GoodsTypeDao goodsTypeDao;

    @Override
    public Page<OrderVo> selectPageVo(Page<OrderVo> orderVoPage, OrderVo orderVo) {

        return orderDao.selectPageVo(orderVoPage, orderVo);
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

    @Override
    public List<GoodsVo> selectGoodsNameNumberTypeId(Date startTime, Date endTime, Integer typeId) {
        //根据 类型 id  查询 有什么 商品
        List<GoodsVo> goodsVos = goodsDao.selectShopIdByTypeId(typeId);

        //根据 时间 段查询 出 有 哪些 订单 出货
        List<String> orderIds = orderDao.selectOrderIdByTime(startTime, endTime);

        //根据 订单 id 进行 查询 商品 id 和  数量
        List<Map<String, Integer>> mapList = orderShopDao.selectGoodsIdCountByOrderId(orderIds);

        //提取 出来
        //Map<Integer(商品编号), Integer(数量)>
        Map<Integer, Integer> goodsVoMap = new HashMap<>();
        for (Map<String, Integer> map : mapList) {
            //goodsId  countNum 依照数据库 查询 语句 定
            goodsVoMap.put(map.get("goodsId"), map.get("countNum"));
        }

        //在 根据 商品 id 进行 匹配 id 是否 所属
        for (GoodsVo goodsVo : goodsVos) {
            goodsVo.setCountNum(goodsVoMap.get(goodsVo.getGoodsId()));
        }

        //获取
        return goodsVos;
    }

    @Override
    public List<GoodsTypeVo> selectGoodTypeNumByTime(Date startTime, Date endTime) {
        //查询 出 所有 类型 id 和  类型 名
        List<GoodsTypeVo> goodsTypeVos = goodsTypeDao.select();

        //根据 时间  查询 出 订单 id
        List<String> orders = orderDao.selectOrderIdByTime(startTime, endTime);

        //在 根据


        return null;
    }
}

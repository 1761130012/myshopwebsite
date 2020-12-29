package com.example.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.dao.*;
import com.example.service.OrderService;
import com.example.utils.ServiceImplUtil;
import com.example.utils.TimeGroupUtil;
import com.example.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

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
    private ServiceImplUtil serviceImplUtil;

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

    @Autowired
    private UserShopDao userShopDao;

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
        return orderDao.selectCountMoneyByOrderId(orderId);
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
    public boolean updatePayNumberByOrderShopId(List<OrderShopVo> orderShopVos, Integer shopId, String orderId) {
        //进行 修改 订单 的 商户 id
        orderDao.updateShopIdByOrderId(orderId, shopId);

        float countMoney = 0;
        for (OrderShopVo orderShopVo : orderShopVos) {
            //进行 修改
            if (orderShopDao.updateById(orderShopVo) == 0) {
                return false;
            }
            countMoney += goodsDao.selectPriceByGoodsId(orderShopVo.getGoodsId()) * orderShopVo.getPayNumber();
        }

        //进行 修改
        orderDao.updateCountMoneyById(orderId, (float) (Math.round(100 * countMoney) / 100));
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
    public List<OrderVo> queryTimeCountMoneyByTime(String userLoginName, Date startTime, Date endTime) {
        //根据 登录 名 进行 查询  商户 id
        Integer shopId = shopDao.selectIdByUserId(userDao.selectIdByLoginName(userLoginName));
        List<OrderVo> orderVos = orderDao.selectTimeCountMoneyByTime(shopId, startTime, endTime);
        for (OrderVo vo : orderVos) {
            //0.005 是 用 代收 费
            vo.setMoney((float) (vo.getMoney() * 0.05));
        }
        return orderVos;
    }

    @Override
    public List<GoodsVo> selectGoodsNameNumberTypeId(Date startTime, Date endTime, Integer typeId) {
        //根据 类型 id  查询 有什么 商品
        List<GoodsVo> goodsVos = goodsDao.selectShopIdByTypeId(typeId);

        //根据 时间 段查询 出 有 哪些 订单 出货
        List<String> orderIds = orderDao.selectOrderIdByTime(startTime, endTime);

        //有可能 没 订单
        if (orderIds.size() == 0) {
            return null;
        }

        //根据 订单 id 进行 查询 商品 id 和  数量
        List<Map<String, Object>> mapList = orderShopDao.selectGoodsIdCountByOrderId(orderIds);

        //提取 出来
        Map<Object, Object> goodsVoMap = serviceImplUtil.getMapIdAndNum(mapList, "goodsId", "countNum");

        //在 根据 商品 id 进行 匹配 id 是否 所属
        for (GoodsVo goodsVo : goodsVos) {
            if (goodsVoMap.containsKey(goodsVo.getGoodsId())) {
                goodsVo.setCountNum(Integer.parseInt((goodsVoMap.get(goodsVo.getGoodsId())).toString()));
            }
        }

        //获取
        return goodsVos;
    }

    @Override
    public List<GoodsTypeVo> selectGoodTypeNumByTime(Date startTime, Date endTime) {
        //查询 出 所有 类型 id 和  类型 名
        List<GoodsTypeVo> goodsTypeVos = goodsTypeDao.select();
        Map<Integer, GoodsTypeVo> goodsTypeVoMap = new HashMap<>();
        //进行 打包 根据 id 进行  打包 成map
        for (GoodsTypeVo goodsTypeVo : goodsTypeVos) {
            goodsTypeVoMap.put(goodsTypeVo.getTypeId(), goodsTypeVo);
        }


        //根据 时间  查询 出 订单 id
        List<String> orderIds = orderDao.selectOrderIdByTime(startTime, endTime);

        //有可能 没 订单
        if (orderIds.size() == 0) {
            return null;
        }


        //在 根据 订单 id 查询 商品 id 和 数量
        List<Map<String, Object>> mapList = orderShopDao.selectGoodsIdCountByOrderId(orderIds);
        //提取 出来  商品 id : 数量
        Map<Object, Object> goodsVoMap = serviceImplUtil.getMapIdAndNum(mapList, "goodsId", "countNum");
        //循环 根据 商品 id 查询 类型 id
        for (Object goodsId : goodsVoMap.keySet()) {
            //查询 返回 类型 id
            Integer typeId = goodsDao.selectGoodsTypeIdByGoodsId((Integer) goodsId);
            if (goodsTypeVoMap.containsKey(typeId)) {
                //获取 对象
                GoodsTypeVo goodsTypeVo = goodsTypeVoMap.get(typeId);
                //赋予 数据
                goodsTypeVo.setCountNum(Integer.parseInt((goodsVoMap.get(typeId)).toString()));
            }
        }
        return new ArrayList<>(goodsTypeVoMap.values());
    }

    @Override
    public Map<Object, Object> queryIncomeByTime(Date startTime, Date endTime) {
        //根据 时间 查询 订单 id 和 时间 和 金额
        List<Map<String, Object>> mapList = orderDao.selectOrderTimeCountNumByTime(startTime, endTime);

        //进行 提取
        return serviceImplUtil.getMapIdAndNum(mapList, "endTime", "money");
    }

    @Override
    public Page<OrderVo> queryAllOrderByShopIdState(Page<OrderVo> page, OrderVo orderVo, String loginName) {
        //根据 登录 id 进行 查询 用户 id  根据 用户 id 查询 商户 id
        Integer shopId = shopDao.selectIdByUserId(userDao.selectIdByLoginName(loginName));
        orderVo.setShopId(shopId);
        return orderDao.selectAllOrderByShopIdState(page, orderVo);
    }

    @Override
    public Page<OrderShopVo> queryOrderShopByOrderId(Page<OrderShopVo> page, String orderId) {
        return orderShopDao.selectPageVoByOrderId(page, orderId);
    }

    @Override
    public String insertOrderByOneGoods(Integer goodsId, Integer num, String loginName) {
        //进行获取 订单 
        String orderId = TimeGroupUtil.getTimeGroupId();

        //根据 商品 id 进行 查询
        Float price = goodsDao.selectPriceByGoodsId(goodsId);

        //进行 添加
        OrderVo orderVo = new OrderVo();
        orderVo.setOrderId(orderId);
        orderVo.setUserId(userDao.selectIdByLoginName(loginName));
        orderVo.setStartTime(new Date());
        orderVo.setPayState(0);
        orderVo.setState(0);
        orderVo.setIsDelete(0);

        //进行 添加
        orderDao.insert(orderVo);

        //进行 添加 订单 商品表
        OrderShopVo orderShopVo = new OrderShopVo();
        orderShopVo.setOrderId(orderId);
        orderShopVo.setGoodsId(goodsId);
        orderShopVo.setGoodsPrice(price);
        orderShopVo.setPayNumber(num);
        //添加 订单商品表
        orderShopDao.insert(orderShopVo);
        return orderId;
    }

    @Override
    public boolean updateNumberById(OrderShopVo orderShopVo) {
        return orderShopDao.updateById(orderShopVo) > 0;
    }

    @Override
    public String selectRemarkByOrderId(String orderId) {
        return orderDao.selectRemarkByOrderId(orderId);
    }

    @Override
    public Page<OrderVo> queryAllOrderByUserIdState(Page<OrderVo> page, OrderVo orderVo, String loginName) {
        Integer userId = userDao.selectIdByLoginName(loginName);
        orderVo.setUserId(userId);
        return orderDao.selectAllOrderByUserIdState(page, orderVo);
    }

    @Override
    public List<GoodsVo> selectGoodsUpdateFive() {
        //查询 销量 前五的 id
        List<Integer> goodsIds = orderShopDao.selectGoodsIdUpdateFive();
        return goodsDao.selectGoodsVoByIds(goodsIds);
    }

    @Override
    public boolean updateDeleteIdByOrderIds(List<String> list, Integer state) {
        return orderDao.updateDeleteIdByOrderIds(list, state) > 0;
    }

    @Override
    public int updateDeliver(OrderVo orderVo) {
        return orderDao.updateDeliver(orderVo);
    }

    @Override
    public Integer getShopId(Integer userId) {
        return userShopDao.getShopId(userId);
    }
}

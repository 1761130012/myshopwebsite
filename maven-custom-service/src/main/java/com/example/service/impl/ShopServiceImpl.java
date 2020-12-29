package com.example.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.dao.OrderDao;
import com.example.dao.ShopDao;
import com.example.dao.UserDao;
import com.example.dao.UserShopDao;
import com.example.service.ShopService;
import com.example.vo.OrderVo;
import com.example.vo.ShopVo;
import com.example.vo.UserShopVo;
import com.example.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 店铺表 服务实现类
 * </p>
 *
 * @author LLY
 * @since 2020-12-08
 */
@Service
public class ShopServiceImpl extends ServiceImpl<ShopDao, ShopVo> implements ShopService {

    @Autowired
    private ShopDao shopDao;

    @Autowired
    private UserDao userDao;

    @Autowired
    private UserShopDao userShopDao;
    @Autowired
    private OrderDao orderDao;

    @Override
    public Page<ShopVo> selectPageVo(Page<ShopVo> page, ShopVo shopVo) {
        return shopDao.selectPageVo(page, shopVo);
    }

    @Override
    public Page<ShopVo> selectPage(Page<ShopVo> page, ShopVo shopVo) {
        return shopDao.selectPage(page, shopVo);
    }


    @Override
    public int delete(String id) {
        return shopDao.deleteById(id);
    }

    @Override
    public int update(ShopVo shopVo) {
        return shopDao.updateById(shopVo);
    }

    @Override
    public int add(ShopVo shopVo) {
        return shopDao.insert(shopVo);
    }


    @Override
    public Map<String, Object> selectAllShopVoByLoginName(String loginName, String orderId) {
        Map<String, Object> map = new HashMap<>();
        //查询 选中 的  商品 id
        Integer shopId = orderDao.selectShopIdByOrderId(orderId);

        //根据 登录 编号 进行 查询 有 什么
        List<UserShopVo> userShopVos = userShopDao.selectAllByUserId(userDao.selectIdByLoginName(loginName));
        //根据 登录编号 进行 查询
        Integer defaultShopId = null;
        List<ShopVo> shopVoList = new ArrayList<>();
        for (UserShopVo userShopVo : userShopVos) {
            ShopVo shopVo = userShopVo.getShopVo();
            //设置 shopvo 内部 state
            shopVo.setState(0);
            shopVoList.add(shopVo);
            if (userShopVo.getState() == 1) {
                //设置 shopvo 内部 state
                shopVo.setState(1);
                defaultShopId = userShopVo.getShopId();
            }
        }

        map.put("selectShopId", shopId == null || shopId == 0 ? defaultShopId : shopId);
        map.put("shopVos", shopVoList);
        return map;
    }

    @Override
    public Map<String, Object> selectShopVoByLoginName(String loginName, String orderId) {
        Map<String, Object> map = new HashMap<>();

        //根据 登录编号 进行 查询
        Integer userId = userDao.selectIdByLoginName(loginName);

        //查询 根据 订单 id  进行 查询 是否 有 商户
        Integer shopId = orderDao.selectShopIdByOrderId(orderId);

        //根据 登录 id 查询 用户商户表 默认地址 商户 id  1 是 默认商户
        Integer shopIdDefault = userShopDao.selectShopVoByState(userId, 1);
        //true 是 默认 false  不是 默认  shopIdDefault 需要保证  不是空
        map.put("state", shopId == null || shopId <= 0 || shopIdDefault.equals(shopId));
        map.put("shopVo", shopDao.selectById(shopId));
        return map;
    }

    @Override
    public ShopVo queryShopVo(UserVo userVos) {
        //根据 userid 和 默认 （1） 查询 店铺信息
        return userShopDao.selectShopVoByUserIdState(userVos.getUserId(), 1).getShopVo();
        //return shopDao.queryShopVo(userVos);
    }

    @Override
    public UserVo queryUserVoByShopId(Integer shopId) {
        Integer userId = shopDao.selectUserIdByShopId(shopId);
        return userDao.selectUserVoById(userId);
    }

    @Override
    public List<ShopVo> selectById(ShopVo shopVo) {
        return shopDao.selectId(shopVo);
    }

    @Override
    public ShopVo queryId(Integer shopId) {
        return shopDao.selectByShopId(shopId);
    }

    @Override
    public UserVo getUserId(UserVo userVo) {
        return userDao.query(userVo);
    }

    @Override
    public Integer getShopId(UserShopVo userShopVo) {
        return userShopDao.getShopId(userShopVo.getUserId());
    }

    @Override
    public List<ShopVo> updateErrorState(Integer[] shopIds) {
        return shopDao.updateErrorState(shopIds);
    }

    @Override
    public List<UserShopVo> selectShopById(UserVo userVo) {
        return userShopDao.selectShopById(userVo);
    }

    @Override
    public int addUserShop(UserShopVo userShopVo) {
        return userShopDao.insert(userShopVo);
    }
}

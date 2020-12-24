package com.example.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.dao.ShopDao;
import com.example.dao.UserDao;
import com.example.dao.UserShopDao;
import com.example.service.ShopService;
import com.example.vo.ShopVo;
import com.example.vo.UserShopVo;
import com.example.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public List<UserShopVo> selectAllShopVoByLoginName(String loginName) {
        //根据 登录编号 进行 查询
        Integer userId = userDao.selectIdByLoginName(loginName);
        //根据 登录 编号 进行 查询 有 什么
        return userShopDao.selectAllByUserId(userId);
    }

    @Override
    public ShopVo selectShopVoByLoginName(String loginName) {
        //根据 登录编号 进行 查询
        Integer userId = userDao.selectIdByLoginName(loginName);
        //根据 登录 id 查询 用户商户表 默认地址 商户 id  1 是 默认商户
        Integer shopId = userShopDao.selectShopVoByState(userId, 1);
        return shopDao.selectById(shopId);
    }

    @Override
    public ShopVo queryShopVo(UserVo userVos) {
        return shopDao.queryShopVo(userVos);
    }

    @Override
    public UserVo queryUserVoByShopId(Integer shopId) {
        Integer userId = shopDao.selectUserIdByShopId(shopId);
        return userDao.selectUserVoById(userId);
    }
}

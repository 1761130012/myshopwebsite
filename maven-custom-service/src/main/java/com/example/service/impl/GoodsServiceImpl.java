package com.example.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.dao.GoodsDao;
import com.example.dao.GoodsTypeDao;
import com.example.dao.ShopCartDao;
import com.example.dao.UserDao;
import com.example.service.GoodsService;
import com.example.vo.GoodsTypeVo;
import com.example.vo.GoodsVo;
import com.example.vo.ShopCartVo;
import com.example.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 商品表 服务实现类
 * </p>
 *
 * @author LLY
 * @since 2020-12-08
 */
@Service
public class GoodsServiceImpl extends ServiceImpl<GoodsDao, GoodsVo> implements GoodsService {

    @Autowired
    GoodsDao goodsDao;

    @Autowired
    GoodsTypeDao goodsTypeDao;

    @Autowired
    ShopCartDao shopCartDao;

    @Autowired
    UserDao userDao;

    @Override
    public Page<GoodsVo> query(Page<GoodsVo> page, GoodsVo goodsVo) {
        return goodsDao.selectPageVo(page,goodsVo);
    }

    @Override
    public List<GoodsTypeVo> queryType() {
        return goodsTypeDao.select();
    }

    @Override
    public int addCar(ShopCartVo shopCartVo) {
        return shopCartDao.insert(shopCartVo);
    }

    @Override
    public List<ShopCartVo> select(ShopCartVo shopCartVo) {
        return shopCartDao.select(shopCartVo);
    }

    @Override
    public void updateCar(ShopCartVo shopCartVo) {
        shopCartDao.updateCar(shopCartVo);
    }

    @Override
    public UserVo queryUser(UserVo userVo) {
        return userDao.query(userVo);
    }


}

package com.example.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.dao.*;
import com.example.service.GoodsService;
import com.example.utils.ServiceImplUtil;
import com.example.vo.*;
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
    private GoodsImageDao goodsImageDao;

    @Autowired
    ShopCartDao shopCartDao;

    @Autowired
    UserDao userDao;

    @Autowired
    private ServiceImplUtil serviceImplUtil;

    @Override
    public Page<GoodsVo> query(Page<GoodsVo> page, GoodsVo goodsVo) {
        return goodsDao.selectPageVo(page, goodsVo);
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

    @Override
    public GoodsVo selectGoodsVoByGoodId(Integer goodsId) {
        //根据 商品 id 查询 图片
        List<String> images = goodsImageDao.selectAddressByGoodsId(goodsId);
        GoodsVo goodsVo = goodsDao.selectById(goodsId);
        goodsVo.setImages(images);
        return goodsVo;
    }

    @Override
    public List<ShopCartVo> queryCar(ShopCartVo shopCartVo) {
        return shopCartDao.select(shopCartVo);
    }

    @Override
    public int updateCarNum(ShopCartVo shopCartVo) {
        return shopCartDao.updateNum(shopCartVo);
    }

    @Override
    public int deleteCar(ShopCartVo shopCartVo) {
        return shopCartDao.deleteById(shopCartVo);
    }

    @Override
    public int addGoodsImage(GoodsImageVo goodsImageVo) {
        return goodsImageDao.insert(goodsImageVo);
    }

    @Override
    public List<GoodsImageVo> goodsImgList(int goodsId) {
        return goodsImageDao.queryGoodsImgBygId(goodsId);
    }

    @Override
    public int deleteGoodsImage(int id) {
        return goodsImageDao.deleteGoodsImage(id);
    }

    @Override
    public GoodsImageVo queryGoodsImgById(int id) {
        return goodsImageDao.selectById(id);
    }

    @Override
    public int updateGoodsImage(GoodsImageVo goodsImageVo) {
        return goodsImageDao.updateById(goodsImageVo);
    }

    @Override
    public Page<GoodsTypeVo> selectTypeAll(Page<GoodsTypeVo> page, GoodsTypeVo goodsTypeVo) {
        return goodsTypeDao.selectTypeAll(page, goodsTypeVo);
    }

    @Override
    public int addType(GoodsTypeVo goodsTypeVo) {
        return goodsTypeDao.insert(goodsTypeVo);
    }

    @Override
    public int updateType(GoodsTypeVo goodsTypeVo) {
        return goodsTypeDao.updateById(goodsTypeVo);
    }

    @Override
    public int deleteType(Integer id) {
        return goodsTypeDao.deleteById(id);
    }

    @Override
    public GoodsTypeVo queryBTypeId(Integer id) {
        return goodsTypeDao.selectById(id);
    }

    @Override
    public List<GoodsVo> list() {
        return goodsDao.list();
    }

    @Override
    public List<GoodsVo> readFileGoods(String absolutePath) {
        return serviceImplUtil.readFile(GoodsVo.class, absolutePath);
    }

    @Override
    public List<GoodsTypeVo> queryAllType() {
        return goodsTypeDao.selectList(null);
    }
}

package com.example.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.vo.*;

import java.util.List;

/**
 * <p>
 * 商品表 服务类
 * </p>
 *
 * @author LLY
 * @since 2020-12-08
 */
public interface GoodsService extends IService<GoodsVo> {


    Page<GoodsVo> query(Page<GoodsVo> page, GoodsVo goodsVo);

    List<GoodsTypeVo> queryType();

    int addCar(ShopCartVo shopCartVo);

    List<ShopCartVo> select(ShopCartVo shopCartVo);

    void updateCar(ShopCartVo shopCartVo);

    UserVo queryUser(UserVo userVo);

    List<ShopCartVo> queryCar(ShopCartVo shopCartVo);

    int updateCarNum(ShopCartVo shopCartVo);

    int deleteCar(ShopCartVo shopCartVo);

    int addGoodsImage(GoodsImageVo goodsImageVo);

    List<GoodsImageVo> goodsImgList(int goodsId);

    int deleteGoodsImage(int id);

    GoodsImageVo queryGoodsImgById(int id);

    int updateGoodsImage(GoodsImageVo goodsImageVo);
}

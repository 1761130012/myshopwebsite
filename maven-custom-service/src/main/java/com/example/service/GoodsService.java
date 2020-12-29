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

    /**
     * 根据商品id 查询商品
     *
     * @param goodsId
     * @return
     */
    GoodsVo selectGoodsVoByGoodId(Integer goodsId);

    List<ShopCartVo> queryCar(ShopCartVo shopCartVo);

    int updateCarNum(ShopCartVo shopCartVo);

    int deleteCar(ShopCartVo shopCartVo);

    @Override
    List<GoodsVo> list();

    Page<GoodsTypeVo> selectTypeAll(Page<GoodsTypeVo> page, GoodsTypeVo goodsTypeVo);
    int addType(GoodsTypeVo goodsTypeVo);
    int updateType(GoodsTypeVo goodsTypeVo);
    int deleteType(Integer id);
    GoodsTypeVo queryBTypeId(Integer id);

    int addGoodsImage(GoodsImageVo goodsImageVo);

    List<GoodsImageVo> goodsImgList(int goodsId);

    int deleteGoodsImage(int id);

    GoodsImageVo queryGoodsImgById(int id);

    int updateGoodsImage(GoodsImageVo goodsImageVo);

    /**
     * 读文件 获取
     * @param absolutePath
     * @return
     */
    List<GoodsVo> readFileGoods(String absolutePath);

    List<GoodsTypeVo> queryAllType();
}

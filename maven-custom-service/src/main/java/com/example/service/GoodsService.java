package com.example.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.vo.GoodsTypeVo;
import com.example.vo.GoodsVo;
import com.example.vo.ShopCartVo;
import com.example.vo.UserVo;

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
}

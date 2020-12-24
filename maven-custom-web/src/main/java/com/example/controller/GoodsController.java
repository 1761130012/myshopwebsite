package com.example.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.dao.UserDao;
import com.example.service.GoodsService;
import com.example.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 商品表 前端控制器
 * </p>
 *
 * @author LLY
 * @since 2020-12-08
 */
@RestController
@RequestMapping("/goods")
@CrossOrigin
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    @RequestMapping("/queryGoodsVo")
    public Page<GoodsVo> queryPageVo(@RequestParam(value = "page", defaultValue = "1") int page,
                                     @RequestParam(value = "rows", defaultValue = "6") int rows,
                                     GoodsVo goodsVo) {
        return goodsService.query(new Page<GoodsVo>(page, rows), goodsVo);
    }

    @RequestMapping("/queryGoodsTypeVo")
    public List<GoodsTypeVo> queryTypeVo() {
        return goodsService.queryType();
    }


    @RequestMapping("/addCar")
    public void addCar(ShopCartVo shopCartVo, UserVo userVo) {

        UserVo userVos = goodsService.queryUser(userVo);

        shopCartVo.setUserId(userVos.getUserId());

        int num = goodsService.select(shopCartVo).size();
        if (num != 0) {
            goodsService.updateCar(shopCartVo);
        } else {
            goodsService.addCar(shopCartVo);
        }
    }

    @RequestMapping("/queryGoodsVoByGoodId")
    public GoodsVo queryGoodsVoByGoodId(Integer goodsId) {
        return goodsService.selectGoodsVoByGoodId(goodsId);
    }

}

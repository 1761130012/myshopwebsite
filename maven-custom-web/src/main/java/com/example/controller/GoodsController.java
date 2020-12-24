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

import java.util.Arrays;
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

    //帮你修改了个名字
    @RequestMapping("/queryGoodsVo")
    public Page<GoodsVo> queryPageVo(@RequestParam(value = "page", defaultValue = "1") int page,
                                     @RequestParam(value = "rows", defaultValue = "6") int rows,
                                     GoodsVo goodsVo) {
        return goodsService.query(new Page<GoodsVo>(page, rows), goodsVo);
    }

    //帮你修改了个名字
    @RequestMapping("/queryGoodsVo")
    public Page<GoodsVo> queryGoodsVo(@RequestParam(value = "page", defaultValue = "1") int page,
                                      @RequestParam(value = "rows", defaultValue = "6") int rows,
                                      GoodsVo goodsVo) {
        return goodsService.query(new Page<GoodsVo>(page, rows), goodsVo);
    }

    //查询全部商品类型
    @RequestMapping("/queryGoodsTypeVo")
    public List<GoodsTypeVo> queryTypeVo(){
        return goodsService.queryType();
    }

    //添加商品
    @RequestMapping("addGoods")
    public boolean addGoods(GoodsVo goodsVo) {
        System.out.println("------------------------------------" + goodsVo);
        return goodsService.save(goodsVo);
    }

    //根据id查询商品信息
    @RequestMapping("queryGoodsById")
    public GoodsVo queryGoodsById(Integer goodsId) {
        return goodsService.getById(goodsId);
    }
    //根据id修改商品信息
    @RequestMapping("updGoodsById")
    public boolean updGoodsById(GoodsVo goodsVo){
        return goodsService.updateById(goodsVo);
    }
    //删除
    @RequestMapping("delGoogsGyId")
    public boolean delGoogsGyId(String ids){
        String [] id=ids.split(",");
        return goodsService.removeByIds(Arrays.asList(id));
    }

    @RequestMapping("/addCar")
    public void addCar(ShopCartVo shopCartVo,UserVo userVo){

        UserVo userVos = goodsService.queryUser(userVo);

        shopCartVo.setUserId(userVos.getUserId());

        int num = goodsService.select(shopCartVo).size();
        if(num!=0){
            goodsService.updateCar(shopCartVo);
        }else {
            goodsService.addCar(shopCartVo);
        }
    }

    @RequestMapping("/queryGoodsVoByGoodId")
    public GoodsVo queryGoodsVoByGoodId(Integer goodsId) {
        return goodsService.selectGoodsVoByGoodId(goodsId);
    }

    @RequestMapping("/queryCar")
    public List<ShopCartVo> queryCar(ShopCartVo shopCartVo,UserVo userVo){
        UserVo userVos = goodsService.queryUser(userVo);
        shopCartVo.setUserId(userVos.getUserId());
        return goodsService.queryCar(shopCartVo);
    }

    @RequestMapping("/updateCarNum")
    public int updateCarNum(ShopCartVo shopCartVo,UserVo userVo){
        UserVo userVos = goodsService.queryUser(userVo);
        shopCartVo.setUserId(userVos.getUserId());
        return goodsService.updateCarNum(shopCartVo);
    }

    @RequestMapping("/deleteCar")
    public int deleteCar(ShopCartVo shopCartVo){
        return goodsService.deleteCar(shopCartVo);
    }

}

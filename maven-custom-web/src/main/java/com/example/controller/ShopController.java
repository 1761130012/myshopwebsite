package com.example.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.service.GoodsService;
import com.example.service.ShopService;
import com.example.vo.ShopVo;
import com.example.vo.UserShopVo;
import com.example.vo.UserVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 店铺表 前端控制器
 * </p>
 *
 * @author LLY
 * @since 2020-12-08
 */
@RestController
@RequestMapping("/shop")
@CrossOrigin
public class ShopController {

    @Autowired
    private ShopService shopService;

    @Autowired
    GoodsService goodsService;


    @RequestMapping("/selectShopVo")
    public Page<ShopVo> select(@RequestParam(value = "page", defaultValue = "1") int page,
                               @RequestParam(value = "rows", defaultValue = "5") int rows
            , ShopVo shopVo) {

        return shopService.selectPage(new Page<ShopVo>(page, rows), shopVo);
    }


    @RequestMapping("/deleteShopVo")
    public int delete(String id) {
        return shopService.delete(id);
    }

    @RequestMapping("/updateShopVo")
    public int delete(ShopVo shopVo, UserVo userVo) {
        UserVo userVos = goodsService.queryUser(userVo);
        shopVo.setUserId(userVos.getUserId());
        return shopService.update(shopVo);
    }

    @RequestMapping("/addShopVo")
    public int add(ShopVo shopVo) {
        return shopService.add(shopVo);
    }

    @RequestMapping("/queryPageVo")
    public Page<ShopVo> queryPageVo(Page<ShopVo> page, ShopVo shopVo) {
        //进行 数据 处理
        if (shopVo != null && StringUtils.isNotEmpty(shopVo.getName())) {
            shopVo.setName(shopVo.getName().trim());
        }
        return shopService.selectPageVo(page, shopVo);
    }


    /**
     * 传输 根据 用户id 查询 的 商铺 id
     *
     * @return
     */
    @RequestMapping("/queryAllShopVoByLoginName")
    public List<UserShopVo> queryAllShopVoByLoginName(@RequestParam("loginName") String loginName) {
        return shopService.selectAllShopVoByLoginName(loginName);
    }

    /**
     * 传输 根据 用户id 查询 商铺信息
     *
     * @param userVo
     * @return
     */
    @RequestMapping("/queryShopVo")
    public ShopVo queryShopVo(UserVo userVo) {
        UserVo userVos = goodsService.queryUser(userVo);

        return shopService.queryShopVo(userVos);
    }


    //默认 查询 状态 为 默认 选择 的
    @RequestMapping("/queryShopVoByLoginName")
    public ShopVo queryShopVoByLoginName(String loginName) {
        return shopService.selectShopVoByLoginName(loginName);
    }
}

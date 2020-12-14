package com.example.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.service.ShopService;
import com.example.vo.ShopVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @RequestMapping("/queryPageVo")
    public Page<ShopVo> queryPageVo(Page<ShopVo> page, ShopVo shopVo) {
        //进行 数据 处理
        if (shopVo != null && StringUtils.isNotEmpty(shopVo.getName())) {
            shopVo.setName(shopVo.getName().trim());
        }
        return shopService.selectPageVo(page, shopVo);
    }
}

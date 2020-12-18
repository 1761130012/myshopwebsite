package com.example.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.service.ShopService;
import com.example.vo.ShopVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    public int delete(ShopVo shopVo) {
        return shopService.update(shopVo);
    }

    @RequestMapping("/addShopVo")
    public int add(ShopVo shopVo) {
        return shopService.add(shopVo);
    }

}

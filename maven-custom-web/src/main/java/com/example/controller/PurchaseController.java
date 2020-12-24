package com.example.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.service.PurchaseService;
import com.example.vo.GoodsVo;
import com.example.vo.PurchaseShopVo;
import com.example.vo.PurchaseVo;
import com.example.vo.WarehouseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 采购记录表 前端控制器
 * </p>
 *
 * @author LLY
 * @since 2020-12-08
 */
@RestController
@RequestMapping("/purchase")
@CrossOrigin
public class PurchaseController {
    @Autowired
    PurchaseService purchaseService;

    @RequestMapping("queryshenpiPageVo")
    public Page<PurchaseVo> queryshenpiPageVo(@RequestParam(value = "page", defaultValue = "1") int page,
                                              @RequestParam(value = "rows", defaultValue = "5") int rows,
                                              PurchaseVo purchaseVo) {
        purchaseVo.setState(0);
        return purchaseService.selectPageVo(new Page<PurchaseVo>(page, rows), purchaseVo);
    }

    //采购单信息
    @RequestMapping("queryPageVo")
    public Page<PurchaseVo> queryPageVo(@RequestParam(value = "page", defaultValue = "1") int page,
                                        @RequestParam(value = "rows", defaultValue = "5") int rows,
                                        PurchaseVo purchaseVo) {

        return purchaseService.selectPageVo(new Page<PurchaseVo>(page, rows), purchaseVo);
    }

    //采购单详情信息查询
    @RequestMapping("selectShopPageVo")
    public Page<PurchaseShopVo> selectShopPageVo(@RequestParam(value = "page", defaultValue = "1") int page,
                                                 @RequestParam(value = "rows", defaultValue = "5") int rows,
                                                 PurchaseShopVo purchaseShopVo, String name) {

        GoodsVo goodsVo = new GoodsVo();
        goodsVo.setName(name);
        purchaseShopVo.setGoodsVo(goodsVo);
        return purchaseService.selectShopPageVo(new Page<PurchaseShopVo>(page, rows), purchaseShopVo);
    }

}

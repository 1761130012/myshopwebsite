package com.example.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.service.SupplierService;
import com.example.vo.GoodsVo;
import com.example.vo.SupplierGoodsVo;
import com.example.vo.SupplierVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 供应商表 前端控制器
 * </p>
 *
 * @author LLY
 * @since 2020-12-08
 */
@RestController
@RequestMapping("/supplier")
@CrossOrigin
public class SupplierController {

    @Autowired
    SupplierService supplierService;

    @RequestMapping("/selectSupplierVo")
    public Page<SupplierVo> select(@RequestParam(value = "page", defaultValue = "1") int page,
                                   @RequestParam(value = "rows", defaultValue = "5") int rows
                                    , SupplierVo supplierVo) {
        return supplierService.selectPageVo(new Page<SupplierVo>(page,rows),supplierVo);
    }

    @RequestMapping("/selectSupplierShopVo")
    public Page<SupplierGoodsVo> selectShop(@RequestParam(value = "page", defaultValue = "1") int page,
                                            @RequestParam(value = "rows", defaultValue = "5") int rows
            , SupplierGoodsVo supplierGoodsVo, GoodsVo goodsVo) {
        supplierGoodsVo.setGoodsVo(goodsVo);
        return supplierService.selectGoodsPageVo(new Page<SupplierGoodsVo>(page,rows),supplierGoodsVo);
    }

    @RequestMapping("/deleteSupplierVo")
    public int delete(@RequestParam(value = "id", defaultValue = "0")Integer id) {
        return supplierService.delete(id);
    }

    @RequestMapping("/updateSupplierVo")
    public int update(SupplierVo supplierVo) {
        return supplierService.update(supplierVo);
    }

    @RequestMapping("/addSupplierVo")
    public int add(SupplierVo supplierVo) { return supplierService.add(supplierVo);
    }

    @RequestMapping("/deleteSupplierGoodsVo")
    public int deleteSupplierGoodsVo(@RequestParam(value = "id", defaultValue = "0")Integer id) {
        return supplierService.deleteGoods(id);
    }

    @RequestMapping("/updateSupplierGoodsVo")
    public int updateSupplierGoodsVo(SupplierGoodsVo supplierGoodsVo) {
        return supplierService.updateGoods(supplierGoodsVo);
    }

    @RequestMapping("/addSupplierGoodsVo")
    public int addSupplierGoodsVo(SupplierGoodsVo supplierGoodsVo) { return supplierService.addGoods(supplierGoodsVo);
    }


}

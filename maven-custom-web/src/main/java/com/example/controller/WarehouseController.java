package com.example.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.service.WarehouseService;
import com.example.vo.GoodsVo;
import com.example.vo.UserVo;
import com.example.vo.WarehouseShopVo;
import com.example.vo.WarehouseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

/**
 * <p>
 * 仓库表 前端控制器
 * </p>
 *
 * @author LLY
 * @since 2020-12-08
 */
@RestController
@RequestMapping("/warehouse")
@CrossOrigin
public class WarehouseController {
    @Autowired
    WarehouseService warehouseService;
    @RequestMapping("queryPageVo")
    public Page<WarehouseVo> queryPageVo(@RequestParam(value = "page", defaultValue = "1") int page,
                                         @RequestParam(value = "rows", defaultValue = "5") int rows,
                                         WarehouseVo warehouseVo) {
        return warehouseService.selectPageVo(new Page<WarehouseVo>(page, rows), warehouseVo);
    }


    @RequestMapping("delWarehouse")
    public boolean delWarehouse(String ids) {
        String[] nums = ids.split(",");
        return warehouseService.removeByIds(Arrays.asList(nums));
    }
    @RequestMapping("queryWarehouseById")
    public WarehouseVo queryWarehouseById(Integer id) {

        return warehouseService.getById(id);
    }

    @RequestMapping("addWarehouse")
    public boolean addWarehouse( WarehouseVo warehouseVo) {
        return warehouseService.save(warehouseVo);
    }
    @RequestMapping("updWarehouse")
    public boolean updWarehouse(WarehouseVo warehouseVo) {
        System.out.println("----------------------------"+warehouseVo);
        return warehouseService.updateById(warehouseVo);
    }

    @RequestMapping("particulars")
    public Page<WarehouseShopVo> queryPageVo(@RequestParam(value = "page", defaultValue = "1") int page,
                                             @RequestParam(value = "rows", defaultValue = "5") int rows,
                                             WarehouseShopVo warehouseShopVo,String name) {
        GoodsVo good=new GoodsVo();
        good.setName(name);
        warehouseShopVo.setGoodsVo(good);
        System.out.println("---------------------------"+warehouseShopVo);
        return warehouseService.selectPageVo1(new Page<WarehouseShopVo>(page, rows), warehouseShopVo);
    }


}

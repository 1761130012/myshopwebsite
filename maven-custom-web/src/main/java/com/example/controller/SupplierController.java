package com.example.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.service.SupplierService;
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
    @CrossOrigin
    public Page<SupplierVo> select(@RequestParam(value = "page", defaultValue = "1") int page,
                                   @RequestParam(value = "rows", defaultValue = "5") int rows
                                    , SupplierVo supplierVo) {


        return supplierService.selectPageVo(new Page<SupplierVo>(page,rows),supplierVo);
    }


}

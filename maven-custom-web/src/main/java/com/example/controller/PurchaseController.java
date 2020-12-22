package com.example.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.service.PurchaseService;
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

    @RequestMapping("queryPageVo")
    public Page<PurchaseVo> queryPageVo(@RequestParam(value = "page", defaultValue = "1") int page,
                                        @RequestParam(value = "rows", defaultValue = "5") int rows,
                                        PurchaseVo purchaseVo) {

        return purchaseService.selectPageVo(new Page<PurchaseVo>(page, rows), purchaseVo);
    }

}

package com.example.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.service.OrderService;
import com.example.service.OrderShopService;
import com.example.service.SupplierService;
import com.example.vo.OrderShopVo;
import com.example.vo.OrderVo;
import com.example.vo.SupplierVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

/**
 * <p>
 * 订单表 前端控制器
 * </p>
 *
 * @author LLY
 * @since 2020-12-08
 */
@RestController
@RequestMapping("/order")
@CrossOrigin
public class OrderController {

    @Autowired
    OrderService orderService;

    @Autowired
    OrderShopService orderShopService;

    @RequestMapping("/selectOrderVo")
    public Page<OrderVo> select(@RequestParam(value = "page", defaultValue = "1") int page,
                                @RequestParam(value = "rows", defaultValue = "5") int rows
            , OrderVo orderVo) {

        return orderService.selectPageVo(new Page<OrderVo>(page, rows), orderVo);
    }


    @RequestMapping("/deleteOrderVo")
    public int delete(String id) {
        return orderService.delete(id);
    }

    @RequestMapping("/updateOrderVo")
    public int delete(OrderVo orderVo) {
        return orderService.update(orderVo);
    }

    @RequestMapping("/addOrderVo")
    public int add(OrderVo orderVo) {
        return orderService.add(orderVo);
    }


    @RequestMapping("/selectOrderShopVo")
    public List<OrderShopVo> select(OrderShopVo orderShopVo) {
        return orderShopService.select(orderShopVo);
    }


}

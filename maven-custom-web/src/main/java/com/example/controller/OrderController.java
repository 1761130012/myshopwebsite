package com.example.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.service.OrderService;
import com.example.service.OrderShopService;
import com.example.service.SupplierService;
import com.example.vo.*;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Map;

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

    @RequestMapping("/queryOrderShopById")
    public List<OrderShopVo> queryOrderShopById(String orderId) {
        return orderService.selectOrderShopById(orderId);
    }


    @RequestMapping("/deleteOrderShopById")
    public boolean deleteOrderShopById(String orderShopId) {
        return orderService.deleteOrderShopById(orderShopId);
    }

    @RequestMapping("/deleteBathOrderShopByIds")
    public boolean deleteBathOrderShopByIds(@RequestBody List<Integer> list) {
        return orderService.deleteBathOrderShopByIds(list);
    }

    @RequestMapping("/queryCountMoneyByOrderId")
    public Float queryCountMoneyByOrderId(String orderId) {
        return orderService.selectCountMoneyByOrderId(orderId);
    }

    @RequestMapping("/queryPayStateByOrderId")
    public OrderVo queryPayStateByOrderId(String orderId) {
        return orderService.selectPayStateByOrderId(orderId);
    }

    @RequestMapping("/queryPageVoByOrderId")
    public Page<OrderShopVo> queryPageVoByOrderId(Page<OrderShopVo> page, String orderId) {
        return orderService.selectPageVoByOrderId(page, orderId);
    }

    @RequestMapping("/updateStateByOrderId")
    public boolean updateStateByOrderId(String orderId) {
        return orderService.updateStateByOrderId(orderId);
    }

    @RequestMapping("/updatePayNumberByOrderShopId")
    public boolean updatePayNumberByOrderShopId(@RequestBody List<OrderShopVo> orderShopVos) {
        return orderService.updatePayNumberByOrderShopId(orderShopVos);
    }

    @RequestMapping("/queryTimeCountMoneyByTime")
    public List<OrderVo> queryTimeCountMoneyByTime(@DateTimeFormat(pattern = "yyyy-MM-dd") Date startTime,
                                                   @DateTimeFormat(pattern = "yyyy-MM-dd") Date endTime,
                                                   String loginName) throws ParseException {
        return orderService.queryTimeCountMoneyByTime(loginName, startTime, endTime);
    }

    @RequestMapping("/queryGoodTypeNumByTime")
    public List<GoodsTypeVo> queryGoodTypeNumByTime(@DateTimeFormat(pattern = "yyyy-MM-dd") Date startTime,
                                                    @DateTimeFormat(pattern = "yyyy-MM-dd") Date endTime) {

        return orderService.selectGoodTypeNumByTime(startTime, endTime);
    }

    @RequestMapping("/queryGoodsNameNumberTypeId")
    public List<GoodsVo> queryGoodsNameNumberTypeId(@DateTimeFormat(pattern = "yyyy-MM-dd") Date startTime,
                                                    @DateTimeFormat(pattern = "yyyy-MM-dd") Date endTime,
                                                    Integer typeId) {

        return orderService.selectGoodsNameNumberTypeId(startTime, endTime, typeId);
    }


    @RequestMapping("/queryIncomeByTime")
    public Map<Object, Object> queryIncomeByTime(@DateTimeFormat(pattern = "yyyy-MM-dd") Date startTime,
                                                 @DateTimeFormat(pattern = "yyyy-MM-dd") Date endTime) {
        return orderService.queryIncomeByTime(startTime, endTime);
    }

    @RequestMapping("/queryAllOrderByShopId")
    public Page<OrderVo> queryAllOrderByShopId(Page<OrderVo> page, OrderVo orderVo, String loginName) {
        //设置 为 -1 也就是 所有
        orderVo.setState(-1);
        return orderService.queryAllOrderByShopIdState(page, orderVo, loginName);
    }

    @RequestMapping("/queryOrderShopByOrderId")
    public Page<OrderShopVo> queryOrderShopByOrderId(Page<OrderShopVo> page, String orderId) {
        return orderService.queryOrderShopByOrderId(page, orderId);
    }
}

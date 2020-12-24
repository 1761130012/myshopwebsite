package com.example.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.service.OrderService;
import com.example.service.OrderShopService;
import com.example.service.SupplierService;
import com.example.vo.*;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
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
        OrderVo orderVo = new OrderVo();
        orderVo.setOrderId(orderId);
        orderVo.setState(3);
        orderVo.setEndTime(new Date());
        return orderService.updateById(orderVo);
    }

    @RequestMapping("/updatePayNumberByOrderShopId")
    public boolean updatePayNumberByOrderShopId(@RequestBody Map<String, Object> map) {
        List<OrderShopVo> orderShopVos = new ObjectMapper().convertValue(
                (List<OrderShopVo>) map.get("orderShopVos"),
                new TypeReference<List<OrderShopVo>>() {
                });

        return orderService.updatePayNumberByOrderShopId(orderShopVos,
                (Integer) map.get("shopId"),
                (String) map.get("orderId"));
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
        return orderService.queryAllOrderByShopIdState(page, orderVo, loginName);
    }

    @RequestMapping("/queryOrderShopByOrderId")
    public Page<OrderShopVo> queryOrderShopByOrderId(Page<OrderShopVo> page, String orderId) {
        return orderService.queryOrderShopByOrderId(page, orderId);
    }

    /**
     * 商户 进行 确提货
     *
     * @param orderId
     * @return
     */
    @RequestMapping("/updateShopCommitStateByOrderId")
    public boolean updateShopCommitStateByOrderId(String orderId) {
        OrderVo orderVo = new OrderVo();
        orderVo.setOrderId(orderId);
        orderVo.setState(2);
        return orderService.updateById(orderVo);
    }

    @RequestMapping("/insertOrderByOneGoods")
    public String insertOrderByOneGoods(Integer goodsId, Integer num, String loginName) {
        return orderService.insertOrderByOneGoods(goodsId, num, loginName);
    }
}

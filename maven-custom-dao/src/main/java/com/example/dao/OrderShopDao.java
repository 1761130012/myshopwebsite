package com.example.dao;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.vo.OrderShopVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 订单详情(商品)表 Mapper 接口
 * </p>
 *
 * @author LLY
 * @since 2020-12-10
 */
public interface OrderShopDao extends BaseMapper<OrderShopVo> {

    List<OrderShopVo> select(OrderShopVo orderShopVo);

    /**
     * 根据 订单id查询 信息
     * @param orderId
     * @return
     */
    List<OrderShopVo> selectListByOrderId(@Param("orderId") String orderId);


    /**
     * 根据 订单 id 查询 商品 默认获取订单商品表 外层的 价格  商品内部的 价格不统计
     *
     * @param orderId 订单id
     * @return 总金额
     */
    Float selectCountMoneyByOrderId(@Param("orderId") String orderId);

    /**
     * 根据 订单 id 进行查询 分页
     *
     * @param page
     * @param orderId
     * @return
     */
    Page<OrderShopVo> selectPageVoByOrderId(@Param("page") Page<OrderShopVo> page, @Param("orderId") String orderId);

}

package com.example.dao;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.vo.OrderShopVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.vo.OrderVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

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
     *
     * @param orderId
     * @return
     */
    List<OrderShopVo> selectListByOrderId(@Param("orderId") String orderId);

    /**
     * 根据 订单 id 进行查询 分页
     *
     * @param page
     * @param orderId
     * @return
     */
    Page<OrderShopVo> selectPageVoByOrderId(@Param("page") Page<OrderShopVo> page, @Param("orderId") String orderId);

    /**
     * 根据 订单 id 进行 查询 商品 id 和 数量
     *
     * @param orderIds
     * @return
     */
    List<Map<String, Object>> selectGoodsIdCountByOrderId(@Param("orderIds") List<String> orderIds);

    List<OrderShopVo> selectByOrderIds(@Param("orderIds") List<String> orderIds);



    /**
     * 查询 销量 前五的 id
     * @return
     */
    List<Integer> selectGoodsIdUpdateFive();
}

package com.example.dao;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.vo.OrderVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.vo.SupplierVo;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 订单表 Mapper 接口
 * </p>
 *
 * @author LLY
 * @since 2020-12-10
 */
public interface OrderDao extends BaseMapper<OrderVo> {

    Page<OrderVo> selectPageVo(@Param("orderVoPage") Page<OrderVo> orderVoPage, @Param("orderVo") OrderVo orderVo);

    /**
     * 根据订单id 查询 两种 状态
     *
     * @param orderId 订单id
     * @return
     */
    OrderVo selectPayStateByOrderId(@Param("orderId") String orderId);

    /**
     * 查询 时间 和 金额 而且 要
     *
     * @param shopId    商品 id
     * @param startTime 条 开始时间 结束时间 状态
     * @param endTime   条 开始时间 结束时间 状态
     * @return
     */
    List<OrderVo> selectTimeCountMoneyByTime(@Param("shopId") Integer shopId,
                                             @Param("startTime") Date startTime,
                                             @Param("endTime") Date endTime);

    /**
     * 根据 订单 id 进行 修改 总 金额
     *
     * @param orderId
     * @param countMoney
     */
    void updateCountMoneyById(@Param("orderId") String orderId, @Param("countMoney") Float countMoney);

    /**
     * 限定 结束 时间 范围
     *
     * @param startTime
     * @param endTime
     * @return
     */
    List<String> selectOrderIdByTime(@Param("startTime") Date startTime, @Param("endTime") Date endTime);

    /**
     * 根据 时间 进行 查询 具体时间和 总金额
     *  默认 扣除 0.05
     * @param startTime
     * @param endTime
     * @return
     */
    List<Map<String, Object>> selectOrderTimeCountNumByTime(@Param("startTime") Date startTime, @Param("endTime") Date endTime);

    /**
     * 根据 商户 id 和 状态 进行查询 订单
     *
     * @param page
     * @param orderVo
     * @return
     */
    Page<OrderVo> selectAllOrderByShopIdState(@Param("page") Page<OrderVo> page, @Param("orderVo") OrderVo orderVo);

    /**
     * 进行 修改 商户id 根据 订单id
     * @param orderId
     */
    void updateShopIdByOrderId(@Param("orderId") String orderId, @Param("shopId") Integer shopId);

    /**
     * 进行 查询
     * @param orderId
     * @return
     */
    Float selectCountMoneyByOrderId(@Param("orderId") String orderId);

    /**
     * 查询 商品 id 根据 订单id
     * @param orderId
     * @return
     */
    Integer selectShopIdByOrderId(@Param("orderId") String orderId);

    /**
     * 查询 备注 根据 订单id
     * @param orderId
     * @return
     */
    String selectRemarkByOrderId(@Param("orderId") String orderId);

    Page<OrderVo> selectAllOrderByUserIdState(@Param("page") Page<OrderVo> page, @Param("orderVo") OrderVo orderVo);

    /**
     * 修改
     * @param orderIds
     * @param state
     * @return
     */
    Integer updateDeleteIdByOrderIds(@Param("orderIds") List<String> orderIds, @Param("state") Integer state);

    int updateDeliver(OrderVo orderVo);
}

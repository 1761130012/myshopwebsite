package com.example.dao;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.vo.OrderVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.vo.SupplierVo;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

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
     * @param shopId  商品 id
     * @param orderVo 条 开始时间 结束时间 状态
     * @return
     */
    List<OrderVo> selectTimeCountMoneyByTime(@Param("shopId") Integer shopId,
                                             @Param("orderVo") OrderVo orderVo);

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
}

package com.example.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.vo.*;

import javax.xml.crypto.Data;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 订单表 服务类
 * </p>
 *
 * @author LLY
 * @since 2020-12-08
 */
public interface OrderService extends IService<OrderVo> {

    Page<OrderVo> selectPageVo(Page<OrderVo> orderVoPage, OrderVo orderVo);

    int delete(String id);

    int update(OrderVo orderVo);

    int add(OrderVo orderVo);

    /**
     * 根据订单id 删除 商品
     *
     * @param orderId
     * @return
     */
    List<OrderShopVo> selectOrderShopById(String orderId);

    /**
     * 删除订单 商品
     *
     * @param orderShopId
     * @return
     */
    boolean deleteOrderShopById(String orderShopId);

    /**
     * 批量 删除 订单 下 的 商品
     *
     * @param list
     * @return
     */
    boolean deleteBathOrderShopByIds(List<Integer> list);

    /**
     * 根据订单id 进行查询 本订单下 商品的总金额
     *
     * @param orderId
     * @return
     */
    Float selectCountMoneyByOrderId(String orderId);

    /**
     * 根据订单id 查询 两种 状态
     *
     * @param orderId 订单id
     * @return
     */
    OrderVo selectPayStateByOrderId(String orderId);

    /**
     * 进行 分页 根据 订单id
     *
     * @param page
     * @param orderId
     * @return
     */
    Page<OrderShopVo> selectPageVoByOrderId(Page<OrderShopVo> page, String orderId);


    /**
     * 根据订单商品表 id 进行 更改 数量
     *
     * @param orderShopVos
     * @return
     */
    boolean updatePayNumberByOrderShopId(List<OrderShopVo> orderShopVos, Integer shopId, String orderId);

    /**
     * 修改 支付类型 根据 订单 id
     *
     * @param orderId
     * @return
     */
    boolean updatePayStateByOrderId(String orderId);

    /**
     * 进行 查询 类型 所 对应的 商品 数量 完成的  条件
     *
     * @param userLoginName 用户登录名
     * @param startTime     初始时间
     * @param endTime       初始时间
     * @return
     */
    List<OrderVo> queryTimeCountMoneyByTime(String userLoginName, Date startTime, Date endTime);

    /**
     * 根据类型 id 查询 商品名称 和 销售数量
     *
     * @param typeId
     * @return
     */
    List<GoodsVo> selectGoodsNameNumberTypeId(Date startTime, Date endTime, Integer typeId);

    /**
     * 根据 时间 查询 商品 类型  和 类型id 和 数量
     *
     * @param startTime
     * @param endTime
     * @return
     */
    List<GoodsTypeVo> selectGoodTypeNumByTime(Date startTime, Date endTime);

    /**
     * 根据 时间 进行 查询 计算 总收入
     *
     * @param startTime
     * @param endTime
     * @return
     */
    Map<Object, Object> queryIncomeByTime(Date startTime, Date endTime);

    /**
     * 查询 所有 的 订单 根据 商户 id 和 状态查询
     *
     * @param page
     * @param loginName
     * @return
     */
    Page<OrderVo> queryAllOrderByShopIdState(Page<OrderVo> page, OrderVo orderVo, String loginName);

    /**
     * 根据 订单 id 查询 商品
     *
     * @param orderId
     * @return
     */
    Page<OrderShopVo> queryOrderShopByOrderId(Page<OrderShopVo> page, String orderId);

    /**
     * 进行 添加 菜单
     *
     * @param goodsId
     * @param num
     * @return
     */
    String insertOrderByOneGoods(Integer goodsId, Integer num, String loginName);

    /**
     * 根据 商品 id 和 订单id 修改 数量
     *
     * @param orderShopVo
     * @return
     */
    boolean updateNumberById(OrderShopVo orderShopVo);

    /**
     * 根据  订单id 查询 备注
     *
     * @param orderId
     * @return
     */
    String selectRemarkByOrderId(String orderId);

    /**
     * 我的订单
     */
    Page<OrderVo> queryAllOrderByUserIdState(Page<OrderVo> page, OrderVo orderVo, String loginName);

    /**
     * 查询 商品 前五
     *
     * @return
     */
    List<GoodsVo> selectGoodsUpdateFive();

    /**
     * 进行 修改 为 已删除状态
     *
     * @param list
     * @return
     */
    boolean updateDeleteIdByOrderIds(List<String> list, Integer state);

    /**
     * 订单 发货
     * @param orderVo
     * @return
     */
    int updateDeliver(OrderVo orderVo);
}

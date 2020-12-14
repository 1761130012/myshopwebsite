package com.example.dao;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.vo.OrderVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.vo.SupplierVo;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 订单表 Mapper 接口
 * </p>
 *
 * @author LLY
 * @since 2020-12-10
 */
public interface OrderDao extends BaseMapper<OrderVo> {

    Page<OrderVo> selectPageVo(@Param("orderVoPage")Page<OrderVo> orderVoPage, @Param("orderVo")OrderVo orderVo);
}

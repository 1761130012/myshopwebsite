package com.example.dao;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.vo.PurchaseVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.vo.WarehouseShopVo;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 采购记录表 Mapper 接口
 * </p>
 *
 * @author LLY
 * @since 2020-12-10
 */
public interface PurchaseDao extends BaseMapper<PurchaseVo> {
    Page<PurchaseVo> selectPageVo(@Param("purchaseVo") Page<PurchaseVo> purchaseVoPage, @Param("purchaseVo") PurchaseVo purchaseVo);

}

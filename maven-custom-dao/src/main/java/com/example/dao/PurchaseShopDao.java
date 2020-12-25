package com.example.dao;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.vo.PurchaseShopVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.vo.PurchaseVo;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 采购详情表 Mapper 接口
 * </p>
 *
 * @author LLY
 * @since 2020-12-10
 */
public interface PurchaseShopDao extends BaseMapper<PurchaseShopVo> {
    Page<PurchaseShopVo> selectPageVo(@Param("purchaseShopVo") Page<PurchaseShopVo> purchaseShopVoPage, @Param("purchaseShopVo") PurchaseShopVo purchaseShopVo);

}

package com.example.dao;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.vo.SupplierGoodsVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.vo.SupplierVo;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 供应商商品表 Mapper 接口
 * </p>
 *
 * @author LLY
 * @since 2020-12-10
 */
public interface SupplierGoodsDao extends BaseMapper<SupplierGoodsVo> {

    Page<SupplierGoodsVo> selectPageVo(@Param("supplierVoPage") Page<SupplierGoodsVo> supplierVoPage, @Param("supplierGoodsVo") SupplierGoodsVo supplierGoodsVo);
}

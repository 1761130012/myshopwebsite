package com.example.dao;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.vo.SupplierVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 供应商表 Mapper 接口
 * </p>
 *
 * @author LLY
 * @since 2020-12-10
 */
public interface SupplierDao extends BaseMapper<SupplierVo> {


    Page<SupplierVo> selectPageVo(@Param("supplierVoPage") Page<SupplierVo> supplierVoPage, @Param("supplierVo") SupplierVo supplierVo);
}

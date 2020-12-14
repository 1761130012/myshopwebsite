package com.example.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.vo.SupplierVo;

/**
 * <p>
 * 供应商表 服务类
 * </p>
 *
 * @author LLY
 * @since 2020-12-08
 */
public interface SupplierService extends IService<SupplierVo> {


    Page<SupplierVo> selectPageVo(Page<SupplierVo> supplierVoPage, SupplierVo supplierVo);
}

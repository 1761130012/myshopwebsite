package com.example.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.vo.SupplierGoodsVo;
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

    Page<SupplierGoodsVo> selectGoodsPageVo(Page<SupplierGoodsVo> supplierVoPage, SupplierGoodsVo supplierGoodsVo);

    int delete(int id);

    int update(SupplierVo supplierVo);

    int add(SupplierVo supplierVo);

    int deleteGoods(Integer id);

    int updateGoods(SupplierGoodsVo supplierGoodsVo);

    int addGoods(SupplierGoodsVo supplierGoodsVo);
}

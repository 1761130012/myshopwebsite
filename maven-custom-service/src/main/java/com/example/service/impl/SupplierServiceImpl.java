package com.example.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.dao.SupplierDao;
import com.example.dao.SupplierGoodsDao;
import com.example.service.SupplierService;
import com.example.vo.SupplierGoodsVo;
import com.example.vo.SupplierVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 供应商表 服务实现类
 * </p>
 *
 * @author LLY
 * @since 2020-12-08
 */
@Service
public class SupplierServiceImpl extends ServiceImpl<SupplierDao, SupplierVo> implements SupplierService {

    @Autowired
    SupplierDao supplierDao;

    @Autowired
    SupplierGoodsDao supplierGoodsDao;

    @Override
    public Page<SupplierVo> selectPageVo(Page<SupplierVo> supplierVoPage, SupplierVo supplierVo) {
        return supplierDao.selectPageVo(supplierVoPage,supplierVo);
    }

    @Override
    public Page<SupplierGoodsVo> selectGoodsPageVo(Page<SupplierGoodsVo> supplierVoPage, SupplierGoodsVo supplierGoodsVo) {
        return supplierGoodsDao.selectPageVo(supplierVoPage,supplierGoodsVo);
    }

    @Override
    public int delete(int id) {
        return supplierDao.deleteById(id);
    }

    @Override
    public int update(SupplierVo supplierVo) {
        return supplierDao.updateById(supplierVo);
    }

    @Override
    public int add(SupplierVo supplierVo) {
        return supplierDao.insert(supplierVo);
    }

    @Override
    public int deleteGoods(Integer id) {
        return supplierGoodsDao.deleteById(id);
    }

    @Override
    public int updateGoods(SupplierGoodsVo supplierGoodsVo) {
        return supplierGoodsDao.updateById(supplierGoodsVo);
    }

    @Override
    public int addGoods(SupplierGoodsVo supplierGoodsVo) {
        return supplierGoodsDao.insert(supplierGoodsVo);
    }

}

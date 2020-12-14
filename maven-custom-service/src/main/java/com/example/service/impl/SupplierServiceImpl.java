package com.example.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.dao.SupplierDao;
import com.example.service.SupplierService;
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


    @Override
    public Page<SupplierVo> selectPageVo(Page<SupplierVo> supplierVoPage, SupplierVo supplierVo) {
        return supplierDao.selectPageVo(supplierVoPage,supplierVo);
    }
}

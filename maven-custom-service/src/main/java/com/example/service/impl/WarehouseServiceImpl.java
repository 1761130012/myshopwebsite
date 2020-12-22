package com.example.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.dao.WarehouseDao;
import com.example.dao.WarehouseShopDao;
import com.example.service.WarehouseService;
import com.example.vo.WarehouseShopVo;
import com.example.vo.WarehouseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 仓库表 服务实现类
 * </p>
 *
 * @author LLY
 * @since 2020-12-08
 */
@Service
public class WarehouseServiceImpl extends ServiceImpl<WarehouseDao, WarehouseVo> implements WarehouseService {
@Autowired
WarehouseDao warehouseDao;
@Autowired
WarehouseShopDao warehouseShopDao;
    @Override
    public Page<WarehouseVo> selectPageVo(Page<WarehouseVo> warehouseVoPage, WarehouseVo warehouseVo) {
        return warehouseDao.selectPageVo(warehouseVoPage,warehouseVo);
    }

    @Override
    public Page<WarehouseShopVo> selectPageVo1(Page<WarehouseShopVo> warehouseShopVoPage, WarehouseShopVo warehouseShopVo) {
        return warehouseShopDao.selectPageVo(warehouseShopVoPage,warehouseShopVo);
    }
}

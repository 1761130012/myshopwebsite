package com.example.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.dao.PurchaseDao;
import com.example.dao.PurchaseShopDao;
import com.example.service.PurchaseService;
import com.example.vo.PurchaseShopVo;
import com.example.vo.PurchaseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 采购记录表 服务实现类
 * </p>
 *
 * @author LLY
 * @since 2020-12-08
 */
@Service
public class PurchaseServiceImpl extends ServiceImpl<PurchaseDao, PurchaseVo> implements PurchaseService {
    @Autowired
    PurchaseDao purchaseDao;
    @Autowired
    PurchaseShopDao purchaseShopDao;

    @Override
    public Page<PurchaseVo> selectPageVo(Page<PurchaseVo> purchaseVoPage, PurchaseVo purchaseVo) {
        return purchaseDao.selectPageVo(purchaseVoPage, purchaseVo);
    }

    @Override
    public Page<PurchaseShopVo> selectShopPageVo(Page<PurchaseShopVo> purchaseShopVoPage, PurchaseShopVo purchaseShopVo) {
        return purchaseShopDao.selectPageVo(purchaseShopVoPage,purchaseShopVo);
    }
}

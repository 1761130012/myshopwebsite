package com.example.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.dao.ShopDao;
import com.example.service.ShopService;
import com.example.vo.ShopVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 店铺表 服务实现类
 * </p>
 *
 * @author LLY
 * @since 2020-12-08
 */
@Service
public class ShopServiceImpl extends ServiceImpl<ShopDao, ShopVo> implements ShopService {

    @Autowired
    private ShopDao shopDao;

    @Override
    public Page<ShopVo> selectPageVo(Page<ShopVo> page, ShopVo shopVo) {
        return shopDao.selectPageVo(page, shopVo);
    }

    @Override
    public Page<ShopVo> selectPage(Page<ShopVo> page, ShopVo shopVo) {
        return shopDao.selectPage(page, shopVo);
    }


    @Override
    public int delete(String id) {
        return shopDao.deleteById(id);
    }

    @Override
    public int update(ShopVo shopVo) {
        return shopDao.updateById(shopVo);
    }

    @Override
    public int add(ShopVo shopVo) {
        return shopDao.insert(shopVo);
    }
}

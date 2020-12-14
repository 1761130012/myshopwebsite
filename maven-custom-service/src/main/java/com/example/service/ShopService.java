package com.example.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.vo.ShopVo;

/**
 * <p>
 * 店铺表 服务类
 * </p>
 *
 * @author LLY
 * @since 2020-12-08
 */
public interface ShopService extends IService<ShopVo> {

    Page<ShopVo> selectPageVo(Page<ShopVo> page, ShopVo shopVo);
}

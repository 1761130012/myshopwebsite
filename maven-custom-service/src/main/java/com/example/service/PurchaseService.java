package com.example.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.vo.PurchaseVo;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 采购记录表 服务类
 * </p>
 *
 * @author LLY
 * @since 2020-12-08
 */
public interface PurchaseService extends IService<PurchaseVo> {
    Page<PurchaseVo> selectPageVo(@Param("purchaseVo") Page<PurchaseVo> purchaseVoPage, @Param("purchaseVo") PurchaseVo purchaseVo);

}

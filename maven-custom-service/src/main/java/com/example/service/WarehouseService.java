package com.example.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.vo.WarehouseShopVo;
import com.example.vo.WarehouseVo;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 仓库表 服务类
 * </p>
 *
 * @author LLY
 * @since 2020-12-08
 */
public interface WarehouseService extends IService<WarehouseVo> {
    Page<WarehouseVo> selectPageVo(@Param("warehouseVoPage") Page<WarehouseVo> warehouseVoPage, @Param("userVo") WarehouseVo warehouseVo);

    Page<WarehouseShopVo> selectPageVo1(@Param("warehouseShopVo") Page<WarehouseShopVo> warehouseShopVoPage, @Param("warehouseShopVo") WarehouseShopVo warehouseShopVo);

}

package com.example.dao;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.vo.WarehouseShopVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.vo.WarehouseVo;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 仓库详情表 Mapper 接口
 * </p>
 *
 * @author LLY
 * @since 2020-12-10
 */
public interface WarehouseShopDao extends BaseMapper<WarehouseShopVo> {
    Page<WarehouseShopVo> selectPageVo(@Param("warehouseShopVo") Page<WarehouseShopVo> warehouseShopVoPage, @Param("warehouseShopVo") WarehouseShopVo warehouseShopVo);

}

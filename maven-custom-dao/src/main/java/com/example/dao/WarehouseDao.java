package com.example.dao;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.vo.UserVo;
import com.example.vo.WarehouseVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 仓库表 Mapper 接口
 * </p>
 *
 * @author LLY
 * @since 2020-12-10
 */
public interface WarehouseDao extends BaseMapper<WarehouseVo> {

    Page<WarehouseVo> selectPageVo(@Param("warehouseVoPage") Page<WarehouseVo> warehouseVoPage, @Param("warehouseVo") WarehouseVo warehouseVo);

}

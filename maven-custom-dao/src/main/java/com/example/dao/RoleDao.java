package com.example.dao;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.vo.RoleVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.vo.StaffVo;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 角色表 Mapper 接口
 * </p>
 *
 * @author LLY
 * @since 2020-12-10
 */
public interface RoleDao extends BaseMapper<RoleVo> {
    Page<RoleVo> selectPageVo(@Param("roleVoPage") Page<RoleVo> roleVoPage,
                              @Param("roleVo") RoleVo roleVo);
}

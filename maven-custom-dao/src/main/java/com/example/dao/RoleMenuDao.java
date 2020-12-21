package com.example.dao;

import com.example.vo.RoleMenuVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 角色菜单表 Mapper 接口
 * </p>
 *
 * @author LLY
 * @since 2020-12-10
 */
public interface RoleMenuDao extends BaseMapper<RoleMenuVo> {

    void deleteRoleId(@Param("roleId") Integer roleId);

    int insertRoleIdMenusBath(@Param("roleId") Integer roleId, @Param("menus") List<Integer> menus);
    /**
     * 根据 角色id 查询 菜单 id
     *
     * @param roleIds
     * @return
     */
    List<Integer> selectMenuIdByRoleId(@Param("roleIds") List<Integer> roleIds);
}

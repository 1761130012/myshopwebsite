package com.example.dao;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.vo.MenuVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 菜单表 Mapper 接口
 * </p>
 *
 * @author LLY
 * @since 2020-12-10
 */
public interface MenuDao extends BaseMapper<MenuVo> {
    //查询 id  和 名称 部分
    List<MenuVo> selectPartIdNameAll();

    List<Integer> selectMenuIdsByRoleId(@Param("roleId") Integer roleId);

    public List<MenuVo> selectMenuList(@Param("menuVo") MenuVo menuVo);

    /**
     * 根据 菜单 id 查询
     *
     * @param menuIds
     * @return
     */
    List<String> selectMenuPermsByIds(@Param("menuIds") List<Integer> menuIds);

    /**
     * 进行 查询 所有
     *
     * @return
     */
    List<MenuVo> selectAllNotButton(@Param("menuIds") List<Integer> menuIds);

}
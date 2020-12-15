package com.example.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.vo.MenuVo;

import java.util.List;

/**
 * <p>
 * 菜单表 服务类
 * </p>
 *
 * @author LLY
 * @since 2020-12-08
 */
public interface MenuService extends IService<MenuVo> {

    List<MenuVo> queryAll();

    List<Integer> selectMenuIdsByRoleId(Integer roleId);

    public List<MenuVo> selectMenuList(MenuVo menuVo);
}

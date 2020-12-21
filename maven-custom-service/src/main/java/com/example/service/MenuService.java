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

    /**
     * 根据 登录名 进行 查询 有的 菜单
     *
     * @param loginName
     * @return
     */
    List<String> selectMenuPermsByIds(String loginName);

    /**
     * 查询 所有的菜单但是 不是 有 按钮
     *
     * @return
     */
    List<MenuVo> queryAllNotButton(String loginName);

    public List<MenuVo> selectMenuList(MenuVo menuVo);
}


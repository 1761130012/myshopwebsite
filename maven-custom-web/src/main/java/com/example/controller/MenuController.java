package com.example.controller;


import com.example.service.MenuService;
import com.example.vo.MenuVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.*;
import java.util.List;

/**
 * <p>
 * 菜单表 前端控制器
 * </p>
 *
 * @author LLY
 * @since 2020-12-08
 */
@RestController
@RequestMapping("/menu")
@CrossOrigin
public class MenuController {
    @Autowired
    private MenuService menuService;

    @RequestMapping("/queryAll")
    public List<MenuVo> queryAll() {
        return menuService.queryAll();
    }

    @RequestMapping("/queryMenuIdsByRoleId")
    public List<Integer> queryMenuIdsByRoleId(Integer roleId) {
        return menuService.selectMenuIdsByRoleId(roleId);
    }



}

package com.example.controller;


import com.example.service.MenuService;
import com.example.vo.MenuVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
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

    @RequestMapping("/querymenu")
    public List<MenuVo> querymenu(MenuVo menuVo){
        return menuService.selectMenuList(menuVo);
    }

    @RequestMapping("/add")
    public boolean add(@RequestBody MenuVo menuVo){
        return menuService.save(menuVo);
    }

    @RequestMapping("/querybid")
    public MenuVo querybid(int id){
        return menuService.getById(id);
    }

    @RequestMapping("/updata")
    public boolean updata(@RequestBody MenuVo menuVo){
        return menuService.updateById(menuVo);
    }

    @RequestMapping("/delete")
    public boolean delete(String id){
        String[] ids=id.split(",");
        boolean bool=false;
        for (int i=0;i<ids.length;i++){
            bool=menuService.removeById(ids[i]);
        }
        return bool;
    }

}

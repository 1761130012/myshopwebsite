package com.example.controller;


import com.example.service.RoleService;
import com.example.vo.RoleVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 角色表 前端控制器
 * </p>
 *
 * @author LLY
 * @since 2020-12-08
 */
@RestController
@RequestMapping("/role")
@CrossOrigin
public class RoleController {

    @Autowired
    private RoleService roleService;

    @RequestMapping("/queryAll")
    public List<RoleVo> queryAll() {
        return roleService.list();
    }


    @RequestMapping("/updateRoleMenuId")
    public boolean updateRoleMenuId(@RequestBody Map<String, Object> map) {
        return roleService.updateRoleMenuId(map);
    }
}

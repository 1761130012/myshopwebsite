package com.example.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.service.RoleService;
import com.example.vo.RoleVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping("/queryPageVo")
    public Page<RoleVo> queryPageVo(@RequestParam("page") int page,
                                    @RequestParam("rows") int rows,
                                    RoleVo roleVo){
        return roleService.selectPageVo(new Page<RoleVo>(page,rows),roleVo);

    }

    @RequestMapping("/add")
    public boolean add(@RequestBody RoleVo roleVo){
        return roleService.save(roleVo);
    }

    @RequestMapping("/querybid")
    public RoleVo querybid(int id){
        return roleService.getById(id);
    }

    @RequestMapping("/updata")
    public boolean updata(@RequestBody RoleVo roleVo){
        return roleService.updateById(roleVo);
    }

    @RequestMapping("/delete")
    public boolean delete(@RequestBody Integer[] ids) {
        boolean bool = false;
        for (int i = 0; i < ids.length; i++) {
            bool = roleService.removeById(ids[i]);
        }
        return bool;
    }

    @RequestMapping("/queryRoleVoByStaffId")
    public List<Integer> queryRoleVoByStaffId(Integer staffId) {
        return roleService.selectRoleVoByStaffId(staffId);
    }
}

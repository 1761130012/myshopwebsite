package com.example.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.dao.RoleDao;
import com.example.dao.RoleMenuDao;
import com.example.dao.StaffRoleDao;
import com.example.service.RoleService;
import com.example.vo.RoleMenuVo;
import com.example.vo.RoleVo;
import com.example.vo.StaffVo;
import com.google.common.primitives.Ints;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 角色表 服务实现类
 * </p>
 *
 * @author LLY
 * @since 2020-12-08
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleDao, RoleVo> implements RoleService {

    @Autowired
    private RoleMenuDao roleMenuDao;
    @Autowired
    private RoleDao roleDao;
    @Autowired
    private StaffRoleDao staffRoleDao;

    @Override
    public boolean updateRoleMenuId(Map<String, Object> map) {
        //根据 id 删除
        roleMenuDao.deleteRoleId((Integer) map.get("roleId"));
        //进行 批量添加
        return roleMenuDao.insertRoleIdMenusBath((Integer) map.get("roleId"), (List<Integer>) map.get("menus")) > 0;
    }

    @Override
    public Page<RoleVo> selectPageVo(Page<RoleVo> roleVoPage, RoleVo roleVo) {
        return roleDao.selectPageVo(roleVoPage,roleVo);
    }

    @Override
    public List<Integer> selectRoleVoByStaffId(Integer staffId) {
        return staffRoleDao.selectRoleIdByStaffId(staffId);
    }
}

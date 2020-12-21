package com.example.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.dao.MenuDao;
import com.example.dao.RoleMenuDao;
import com.example.dao.StaffDao;
import com.example.dao.StaffRoleDao;
import com.example.service.MenuService;
import com.example.utils.ServiceImplUtil;
import com.example.vo.MenuVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 菜单表 服务实现类
 * </p>
 *
 * @author LLY
 * @since 2020-12-08
 */
@Service
public class MenuServiceImpl extends ServiceImpl<MenuDao, MenuVo> implements MenuService {

    @Autowired
    private ServiceImplUtil serviceImplUtil;

    @Autowired
    private MenuDao menuDao;

    @Autowired
    private StaffDao staffDao;
    @Autowired
    private StaffRoleDao staffRoleDao;
    @Autowired
    private RoleMenuDao roleMenuDao;


    @Override
    public List<MenuVo> queryAll() {
        List<MenuVo> menuVos = menuDao.selectPartIdNameAll();
        return serviceImplUtil.menuIterationAll(menuVos, 0);
    }

    @Override
    public List<Integer> selectMenuIdsByRoleId(Integer roleId) {
        return menuDao.selectMenuIdsByRoleId(roleId);
    }

    @Override
    public List<MenuVo> selectMenuList(MenuVo menuVo) {
        List<MenuVo> menuList=menuDao.selectMenuList(menuVo);
        return menuList;
    }


    @Override
    public List<MenuVo> queryAllNotButton(String loginName) {
        //查询 员工id
        Integer staffId = staffDao.selectIdByLoginName(loginName);
        //根据 员工id 进行 查询 角色id
        List<Integer> roleIds = staffRoleDao.selectRoleIdByStaffId(staffId);
        //根据 角色id 查询 菜单 id
        List<Integer> menuIds = roleMenuDao.selectMenuIdByRoleId(roleIds);
        //根据 菜单id 进行 限制查询
        List<MenuVo> menuVos = menuDao.selectAllNotButton(menuIds);
        return serviceImplUtil.menuIterationAll(menuVos, 0);
    }

    @Override
    public List<String> selectMenuPermsByIds(String loginName) {
        //查询 员工id
        Integer staffId = staffDao.selectIdByLoginName(loginName);
        //根据 员工id 进行 查询 角色id
        List<Integer> roleIds = staffRoleDao.selectRoleIdByStaffId(staffId);
        //根据 角色id 查询 菜单 id
        List<Integer> menuIds = roleMenuDao.selectMenuIdByRoleId(roleIds);
        //进行 查询
        return menuDao.selectMenuPermsByIds(menuIds);
    }
}

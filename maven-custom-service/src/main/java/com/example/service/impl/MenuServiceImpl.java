package com.example.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.dao.MenuDao;
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


}

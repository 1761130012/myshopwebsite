package com.example.utils;

import com.example.vo.MenuVo;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ServiceImplUtil {

    /**
     * 所有菜单迭代 进行 组成树
     */
    public List<MenuVo> menuIterationAll(List<MenuVo> list, Integer parentId) {
        if (list == null || list.size() == 0) {
            return null;
        }
        List<MenuVo> menuVos = new ArrayList<>();
        for (MenuVo menuVo : list) {
            if (menuVo.getParentId().equals(parentId)) {
                menuVos.add(menuVo);
                menuVo.setChildren(menuIterationAll(list, menuVo.getMenuId()));
            }
        }
        return menuVos;
    }

}

package com.example.utils;

import com.example.vo.MenuVo;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
            if (parentId.equals(menuVo.getParentId())) {
                menuVos.add(menuVo);
                menuVo.setChildren(menuIterationAll(list, menuVo.getMenuId()));
            }
        }
        return menuVos;
    }


    public Map<Object, Object> getMapIdAndNum(List<Map<String, Object>> mapList, String keyName, String valueName) {
        Map<Object, Object> goodsVoMap = new HashMap<>();
        for (Map<String, Object> map : mapList) {
            //goodsId  countNum 依照数据库 查询 语句 定
            goodsVoMap.put(map.get(keyName), map.get(valueName));
        }
        return goodsVoMap;
    }
}

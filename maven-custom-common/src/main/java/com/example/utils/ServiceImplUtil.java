package com.example.utils;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.example.vo.MenuVo;
import com.example.vo.StaffVo;
import org.springframework.stereotype.Component;

import java.util.*;

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


    public <T> List<T> readFile(Class<T> tClass, String path) {
        Map<Integer, String> head = new HashMap<>();
        List<T> data = new LinkedList<>();
        EasyExcel.read(path).head(tClass)
                .registerReadListener(new AnalysisEventListener<T>() {
                    @Override
                    public void invokeHeadMap(Map<Integer, String> headMap, AnalysisContext context) {
                        head.putAll(headMap);
                    }

                    @Override
                    public void invoke(T row, AnalysisContext analysisContext) {
                        data.add(row);
                    }

                    @Override
                    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
                        // 这里可以打印日志告知所有行读取完毕
                    }
                }).doReadAll();

        return data;
    }


    public String createLoginName(List<String> loginNames, String name) {
        StringBuilder loginNamesBuff = new StringBuilder();
        for (String loginName : loginNames) {
            loginNamesBuff.append(loginName).append(",");
        }

        String ans = "";
        String loginNamesBuffString = loginNamesBuff.toString();
        int i = 1;
        while (true) {
            if (!loginNamesBuffString.contains(name + i)) {
                ans = name + i;
                break;
            }
            i++;
        }
        return ans;
    }
}

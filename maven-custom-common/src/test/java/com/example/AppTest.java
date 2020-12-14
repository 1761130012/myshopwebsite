package com.example;

import com.example.utils.DelSpaceEmpty;
import com.example.utils.ServiceImplUtil;
import com.example.vo.MenuVo;
import com.example.vo.UserVo;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Bounds
 * Unit test for simple App.
 */
public class AppTest {
    @Test
    public void test1() {

        ArrayList<MenuVo> list = new ArrayList<>();
        list.add(new MenuVo(1, "张三", 0));
        list.add(new MenuVo(2, "张三1", 1));
        list.add(new MenuVo(3, "张三2", 3));

        List<MenuVo> menuVos = new ServiceImplUtil().menuIterationAll(list, 0);
         menuVos.forEach(System.out::println);
    }
}

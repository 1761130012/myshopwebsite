package com.example;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.dao.GoodsDao;
import com.example.dao.OrderShopDao;
import com.example.dao.StaffDao;
import com.example.vo.GoodsVo;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * Unit test for simple App.
 */
public class AppTest {
    @Test
    public void test1() {

        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext-dao.xml");
        int zhaoliulu4 = context.getBean(StaffDao.class).selectCountByLoginName("zhaoliulu4");
        System.out.println(zhaoliulu4);
    }
}

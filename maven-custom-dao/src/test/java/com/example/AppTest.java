package com.example;

import com.example.dao.GoodsDao;
import com.example.dao.GpsProvinceDao;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Unit test for simple App.
 */
public class AppTest {
    @Test
    public void test1() {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext-dao.xml");

        GpsProvinceDao goodsDao = context.getBean(GpsProvinceDao.class);

        System.out.println(goodsDao.selectById(1));
    }
}

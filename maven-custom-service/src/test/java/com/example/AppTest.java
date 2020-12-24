package com.example;

import static org.junit.Assert.assertTrue;

import com.example.dao.OrderShopDao;
import com.example.service.OrderService;
import com.example.vo.GoodsTypeVo;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Unit test for simple App.
 */
public class AppTest {
    /**
     * Rigorous Test :-)
     */
    @Test
    public void test1() {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext-dao.xml");


    }
}

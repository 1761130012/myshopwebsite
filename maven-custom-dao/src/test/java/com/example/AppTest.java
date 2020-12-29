package com.example;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.dao.GoodsDao;
import com.example.dao.OrderDao;
import com.example.dao.OrderShopDao;
import com.example.vo.GoodsVo;
import com.example.vo.OrderVo;
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
        ApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext-dao.xml");

        OrderDao orderDao = context.getBean("orderDao",OrderDao.class);
        OrderVo orderVo=new OrderVo();
        orderVo.setState(-1);
        orderVo.setPayState(-1);
        orderVo.setUserId(1);
//        Page<OrderVo> page=orderDao.all(new Page<OrderVo>(1,5),orderVo);
//        System.out.println(page);

    }
}

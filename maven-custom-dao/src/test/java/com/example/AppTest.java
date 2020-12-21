package com.example;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.dao.GoodsDao;
import com.example.dao.OrderShopDao;
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
        ApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext-dao.xml");

        OrderShopDao orderShopDao = context.getBean(OrderShopDao.class);

        List<Map<String, Integer>> list = orderShopDao.selectGoodsIdCountByOrderId(new ArrayList<String>(Arrays.asList("2020121011051")));

        for (Map<String, Integer> map : list) {
            System.out.println(map);
        }
    }
}

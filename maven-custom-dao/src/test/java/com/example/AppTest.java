package com.example;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.dao.GoodsDao;
import com.example.vo.GoodsVo;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Unit test for simple App.
 */
public class AppTest {
    @Test
    public void test1() {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext-dao.xml");

        GoodsDao goodsDao = context.getBean(GoodsDao.class);


        Page<GoodsVo> goodsVos = goodsDao.selectPageVo(new Page<GoodsVo>(1,2),null);
        System.out.println(goodsVos.getRecords().size());
    }
}

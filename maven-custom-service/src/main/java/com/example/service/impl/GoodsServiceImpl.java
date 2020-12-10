package com.example.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.dao.GoodsDao;
import com.example.service.GoodsService;
import com.example.vo.GoodsVo;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 商品表 服务实现类
 * </p>
 *
 * @author LLY
 * @since 2020-12-08
 */
@Service
public class GoodsServiceImpl extends ServiceImpl<GoodsDao, GoodsVo> implements GoodsService {

}

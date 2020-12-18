package com.example.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.dao.GpsCityDao;
import com.example.service.GpsCityService;
import com.example.vo.GpsCityVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 市 服务实现类
 * </p>
 *
 * @author LLY
 * @since 2020-12-13
 */
@Service
public class GpsCityServiceImpl extends ServiceImpl<GpsCityDao, GpsCityVo> implements GpsCityService {

    @Autowired
    GpsCityDao gpsCityDao;

    @Override
    public List<GpsCityVo> select(GpsCityVo gpsCityVo) {
        return gpsCityDao.select(gpsCityVo);
    }
}

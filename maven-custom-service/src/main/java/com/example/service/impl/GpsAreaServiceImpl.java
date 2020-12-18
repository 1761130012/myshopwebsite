package com.example.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.dao.GpsAreaDao;
import com.example.service.GpsAreaService;
import com.example.vo.GpsAreaVo;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 区/县 服务实现类
 * </p>
 *
 * @author LLY
 * @since 2020-12-13
 */
@Service
public class GpsAreaServiceImpl extends ServiceImpl<GpsAreaDao, GpsAreaVo> implements GpsAreaService {

    @Autowired
    GpsAreaDao gpsAreaDao;

    @Override
    public List<GpsAreaVo> select(GpsAreaVo gpsAreaVo) {
        return gpsAreaDao.select(gpsAreaVo);
    }
}

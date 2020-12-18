package com.example.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.dao.GpsProvinceDao;
import com.example.service.GpsProvinceService;
import com.example.vo.GpsProvinceVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 省 服务实现类
 * </p>
 *
 * @author LLY
 * @since 2020-12-13
 */
@Service
public class GpsProvinceServiceImpl extends ServiceImpl<GpsProvinceDao, GpsProvinceVo> implements GpsProvinceService {

    @Autowired
    GpsProvinceDao gpsProvinceDao;

    @Override
    public List<GpsProvinceVo> select(GpsProvinceVo gpsProvinceVo) {
        return gpsProvinceDao.select(gpsProvinceVo);
    }
}

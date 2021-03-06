package com.example.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.vo.GpsProvinceVo;

import java.util.List;

/**
 * <p>
 * 省 服务类
 * </p>
 *
 * @author LLY
 * @since 2020-12-13
 */
public interface GpsProvinceService extends IService<GpsProvinceVo> {

    List<GpsProvinceVo> select(GpsProvinceVo gpsProvinceVo);
}

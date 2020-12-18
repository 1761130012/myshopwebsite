package com.example.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.example.vo.GpsAreaVo;

import java.util.List;

/**
 * <p>
 * 区/县 服务类
 * </p>
 *
 * @author LLY
 * @since 2020-12-13
 */
public interface GpsAreaService extends IService<GpsAreaVo> {

    List<GpsAreaVo> select(GpsAreaVo gpsAreaVo);
}

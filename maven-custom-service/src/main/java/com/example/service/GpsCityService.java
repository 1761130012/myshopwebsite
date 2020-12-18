package com.example.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.vo.GpsCityVo;

import java.util.List;

/**
 * <p>
 * 市 服务类
 * </p>
 *
 * @author LLY
 * @since 2020-12-13
 */
public interface GpsCityService extends IService<GpsCityVo> {

    List<GpsCityVo> select(GpsCityVo gpsCityVo);
}

package com.example.controller;


import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.example.service.GpsCityService;
import com.example.vo.GpsCityVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 市 前端控制器
 * </p>
 *
 * @author LLY
 * @since 2020-12-13
 */
@RestController
@RequestMapping("/gpsCity")
@CrossOrigin
public class GpsCityController {
    @Autowired
    GpsCityService gpsCityService;

    @RequestMapping("/gpsCityVo")
    public List<GpsCityVo> select(GpsCityVo gpsCityVo) {
        return gpsCityService.select(gpsCityVo);
    }

}

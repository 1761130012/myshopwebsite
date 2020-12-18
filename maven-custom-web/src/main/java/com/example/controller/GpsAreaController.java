package com.example.controller;


import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.example.service.GpsAreaService;
import com.example.vo.GpsAreaVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 区/县 前端控制器
 * </p>
 *
 * @author LLY
 * @since 2020-12-13
 */
@RestController
@RequestMapping("/gpsArea")
@CrossOrigin
public class GpsAreaController {

    @Autowired
    GpsAreaService gpsAreaService;

    @RequestMapping("/gpsAreaVo")
    public List<GpsAreaVo> select(GpsAreaVo gpsAreaVo) {
        return gpsAreaService.select(gpsAreaVo);
    }

}

package com.example.controller;


import com.example.service.GpsProvinceService;
import com.example.vo.GpsProvinceVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 省 前端控制器
 * </p>
 *
 * @author LLY
 * @since 2020-12-13
 */
@RestController
@RequestMapping("/gpsProvince")
@CrossOrigin
public class GpsProvinceController {

    @Autowired
    GpsProvinceService gpsProvinceService;

    @RequestMapping("/gpsProvinceVo")
    public List<GpsProvinceVo> select(GpsProvinceVo gpsProvinceVo) {
        return gpsProvinceService.select(gpsProvinceVo);
    }


}

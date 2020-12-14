package com.example.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.service.StaffService;
import com.example.vo.StaffVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sun.plugin2.util.SystemUtil;

/**
 * <p>
 * 员工表 前端控制器
 * </p>
 *
 * @author LLY
 * @since 2020-12-08
 */
@RestController
@RequestMapping("/staff")
@CrossOrigin
public class StaffController {

    @Autowired
    private StaffService staffService;

    @RequestMapping("/queryPageVo")
    public Page<StaffVo> queryPageVo(@RequestParam(value = "page", defaultValue = "1") int page,
                                     @RequestParam(value = "rows", defaultValue = "5") int rows,
                                     StaffVo staffVo) {
        return staffService.selectPageVo(new Page<StaffVo>(page, rows), staffVo);
    }

    @RequestMapping("/add")
    public boolean add(@RequestBody StaffVo staffVo) {
        return staffService.save(staffVo);
    }

    @RequestMapping("/querybid")
    public StaffVo querybyid(Integer id) {
        return staffService.getById(id);
    }

    @RequestMapping("/updata")
    public boolean updata(@RequestBody StaffVo staffVo) {

        System.out.println(staffVo);

        return staffService.updateById(staffVo);
    }

    @RequestMapping("/delete")
    public boolean delete(@RequestBody Integer[] ids) {
        boolean bool = false;
        for (int i = 0; i < ids.length; i++) {
            bool = staffService.removeById(ids[i]);
        }
        return bool;
    }

}

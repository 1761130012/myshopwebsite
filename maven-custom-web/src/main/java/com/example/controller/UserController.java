package com.example.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.service.UserService;
import com.example.vo.StaffVo;
import com.example.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author LLY
 * @since 2020-12-08
 */
@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("/queryPageVo")
    public Page<UserVo> queryPageVo(@RequestParam(value = "page", defaultValue = "1") int page,
                                    @RequestParam(value = "rows", defaultValue = "5") int rows,
                                    UserVo userVo) {
        return userService.selectPageVo(new Page<UserVo>(page, rows), userVo);
    }

    @RequestMapping("/add")
    public boolean add(@RequestBody UserVo userVo) {
        return userService.save(userVo);
    }

    @RequestMapping("/querybid")
    public UserVo querybyid(Integer id) {
        return userService.getById(id);
    }

    @RequestMapping("/updata")
    public boolean updata(@RequestBody UserVo userVo) {
        return userService.updateById(userVo);
    }

    @RequestMapping("/delete")
    public boolean delete(String ids) {
        String[] nums = ids.split(",");
        boolean bool=false;
        for (int i = 0; i < nums.length; i++) {
            bool= userService.removeById(Integer.parseInt(nums[i]));
        }
        return bool;
    }

}

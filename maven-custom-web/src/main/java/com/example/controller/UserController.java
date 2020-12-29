package com.example.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.service.UserService;
import com.example.vo.ShopCartVo;
import com.example.vo.StaffVo;
import com.example.vo.UserShopVo;
import com.example.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;


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

    @RequestMapping("/queryList")
    public List<UserVo> queryList(UserVo userVo) {
        return userService.selectList(userVo);
    }

    @RequestMapping("/add")
    public boolean add(@RequestBody UserVo userVo) {
        userVo.setCreateTime(new Date());
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
        boolean bool = false;
        for (int i = 0; i < nums.length; i++) {
            bool = userService.removeById(Integer.parseInt(nums[i]));
        }
        return bool;
    }

    @RequestMapping("/edit")
    public Map addGoods(UserVo userVo, @RequestParam("img") MultipartFile img) throws IOException {
        Map<String, String> map = new HashMap<String, String>();
        userVo.setPicture("./src/assets/" + img.getOriginalFilename());  //保存到数据库的【相对路径】
        System.out.println(userVo);
        System.out.println(img.getBytes().length);
        //将上传的文件保存到服务器上的前端项目的【绝对路径】
        img.transferTo(new File("E:\\新建文件夹\\myshopwebsitepage\\src\\assets\\" + img.getOriginalFilename()));
        boolean bool = userService.updateById(userVo);
        if (bool) {
            map.put("msg", "添加成功");
        }
        return map;
    }

    @RequestMapping("/userLogin")
    public boolean userLogin(UserVo userVo) {
        return userService.userLogin(userVo);
    }

    @RequestMapping("/register")
    public boolean register(UserVo userVo) {
        return userService.updateRegisterByUserId(userVo);
    }

    @RequestMapping("/queryUserIdError")
    public boolean queryUserIdError(String loginName) {
        return userService.queryUserIdError(loginName);
    }

    @RequestMapping("/insertUserGoodsByInfo")
    public boolean insertUserGoodsByInfo(ShopCartVo shopCartVo, String loginName) {
        return userService.insertUserGoodsByInfo(shopCartVo, loginName);
    }

    @RequestMapping("/queryIsLoginName")
    public boolean queryIsLoginName(String loginName) {
        return userService.queryIsLoginName(loginName);
    }

    @RequestMapping("/queryUserShop")
    public List<UserShopVo> queryUserShop(UserShopVo userShopVo) {
        return userService.userShop(userShopVo);
    }

    @RequestMapping("/updateUserShopState")
    public int updateUserShopState(UserShopVo userShopVo,UserVo userVo) {
        userShopVo.setUserId(userService.getUserId(userVo));
        userService.updateUserShopState(userShopVo);
        return userService.updateUserShopState2(userShopVo);
    }

}

package com.example.controller;

import org.junit.jupiter.api.Test;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/test")
@CrossOrigin
public class ZTestController {
    /**
     * 登录测试
     *
     * @return
     */
    @RequestMapping("/loginTest")
    public int loginTest() {
        System.out.println("登录测试成功！");
        return 0;
    }

    /**
     * 接收数组
     * 前端：
     * this.$axios({
     * url:'test/setList',
     * method:'post',
             * data: JSON.stringify([1,2,3,4]) ,
     * headers:{
     * "Content-Type":"application/json;charset=utf-8"
     * },
     * }).then((option) => {
     * console.log(option.data)
     * }).catch((option)=>{
     * console.log(option);
     * })
     * 后端：
     * 需要 '@RequestBody'
     * <p>
     * <p>
     * 特殊：
     * data: JSON.stringify({
     * array:[[1,2,3,4]],
     * name:"张三",
     * } ),
     * <p>
     * 用 Map<String,Object> 接收
     */
    @RequestMapping("/setList")
    public int setList(@RequestBody List<Integer> integers) {
        System.out.println("--------监测---------");
        System.out.println("值：" + integers);
        return 0;
    }


    public void testGitHub() {
        System.out.println("测试 git hub");
    }

    public void testGitHub11() {
        System.out.println("测试 git hub");
    }


    public void testGitHubsdfv() {

        System.out.println("测试 sdfsdfsfgit hub");
    }

    @Test
    public void test1() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        System.out.println(df.format(new Date()));// new Date()为获取当前系统时间
    }


    @RequestMapping("/test")
    public void test(MultipartFile file) {
        System.out.println("--------------------");
        System.out.println(file.getOriginalFilename());
    }
}

package com.example.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/test")
public class ZTestController {

    /**
     * 登录测试
     * @return
     */
    @RequestMapping("/loginTest")
    @CrossOrigin
    public int loginTest(){
        System.out.println("登录测试成功！");
        return 0;
    }

    /**
     * 接收数组
     * 前端：
     *  this.$axios({
     *             url:'test/setList',
     *             method:'post',
     *             data: JSON.stringify([1,2,3,4]) ,
     *             headers:{
     *               "Content-Type":"application/json;charset=utf-8"
     *             },
     *           }).then((option) => {
     *             console.log(option.data)
     *           }).catch((option)=>{
     *             console.log(option);
     *           })
     * 后端：
     * 需要 '@RequestBody'
     *
     *
     * 特殊：
     *  data: JSON.stringify({
     *               array:[[1,2,3,4]],
     *               name:"张三",
     *             } ),
     *
     * 用 Map<String,Object> 接收
     */
    @RequestMapping("/setList")
    @CrossOrigin
    public int setList(@RequestBody List<Integer> integers){
        System.out.println("--------监测---------");
        System.out.println("值："+integers);
        return 0;
    }

    public void test(){
        System.out.println("  测试github");
    }
}

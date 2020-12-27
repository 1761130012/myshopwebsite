package com.example.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.service.GoodsService;
import com.example.utils.ServiceImplUtil;
import com.example.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 商品表 前端控制器
 * </p>
 *
 * @author LLY
 * @since 2020-12-08
 */
@RestController
@RequestMapping("/goods")
@CrossOrigin
public class GoodsController {

    @Autowired
    private GoodsService goodsService;


    //帮你修改了个名字
    @RequestMapping("/queryGoodsVo")
    public Page<GoodsVo> queryGoodsVo(@RequestParam(value = "page", defaultValue = "1") int page,
                                      @RequestParam(value = "rows", defaultValue = "6") int rows,
                                      GoodsVo goodsVo) {
        return goodsService.query(new Page<GoodsVo>(page, rows), goodsVo);
    }

    //分页查询商品信息
    @RequestMapping("/queryPageVo")
    public Page<GoodsVo> queryPageVo(@RequestParam(value = "page", defaultValue = "1") int page,
                                     @RequestParam(value = "rows", defaultValue = "5") int rows,
                                     GoodsVo goodsVo) {
        return goodsService.query(new Page<GoodsVo>(page, rows), goodsVo);
    }

    //查询全部商品类型
    @RequestMapping("/queryGoodsTypeVo")
    public List<GoodsTypeVo> queryTypeVo() {
        return goodsService.queryType();
    }

    //添加商品
    @RequestMapping("addGoods")
    public boolean addGoods(GoodsVo goodsVo) {
        System.out.println("------------------------------------" + goodsVo);
        return goodsService.save(goodsVo);
    }

    //根据id查询商品信息
    @RequestMapping("queryGoodsById")
    public GoodsVo queryGoodsById(Integer goodsId) {
        return goodsService.getById(goodsId);
    }

    //根据id修改商品信息
    @RequestMapping("updGoodsById")
    public boolean updGoodsById(GoodsVo goodsVo) {
        return goodsService.updateById(goodsVo);
    }

    //删除
    @RequestMapping("delGoogsGyId")
    public boolean delGoogsGyId(String ids) {
        String[] id = ids.split(",");
        return goodsService.removeByIds(Arrays.asList(id));
    }

    @RequestMapping("/addCar")
    public void addCar(ShopCartVo shopCartVo, UserVo userVo) {

        UserVo userVos = goodsService.queryUser(userVo);

        shopCartVo.setUserId(userVos.getUserId());

        int num = goodsService.select(shopCartVo).size();
        if (num != 0) {
            goodsService.updateCar(shopCartVo);
        } else {
            goodsService.addCar(shopCartVo);
        }
    }

    @RequestMapping("/queryCar")
    public List<ShopCartVo> queryCar(ShopCartVo shopCartVo, UserVo userVo) {
        UserVo userVos = goodsService.queryUser(userVo);
        shopCartVo.setUserId(userVos.getUserId());
        return goodsService.queryCar(shopCartVo);
    }

    @RequestMapping("/updateCarNum")
    public int updateCarNum(ShopCartVo shopCartVo, UserVo userVo) {
        UserVo userVos = goodsService.queryUser(userVo);
        shopCartVo.setUserId(userVos.getUserId());
        return goodsService.updateCarNum(shopCartVo);
    }

    @RequestMapping("/deleteCar")
    public int deleteCar(ShopCartVo shopCartVo) {
        return goodsService.deleteCar(shopCartVo);
    }

    //商品上传图片
    @RequestMapping("addGoodsImg")
    public Map addGoodsImg(MultipartFile img, String goodsId) throws IOException {
        Map<String,String> map =new HashMap<String,String>();
        //判断是否是图片
        String type=img.getContentType();
        if (type.equals("image/png") || type.equals("image/jpg") || type.equals("image/jpeg") || type.equals("image/bmp") || type.equals("image/gif") || type.equals("image/webp")){
            GoodsImageVo goodsImageVo = new GoodsImageVo();
            goodsImageVo.setAdders("./src/resource/image/" + img.getOriginalFilename());  //保存到数据库的【相对路径】
            goodsImageVo.setGoodsId(Integer.parseInt(goodsId));
            System.out.println(img.getBytes().length);
            //将上传的文件保存到服务器上的前端项目的【绝对路径】
            img.transferTo(new File(ServiceImplUtil.filePath + img.getOriginalFilename()));
            map.put("code",String.valueOf( goodsService.addGoodsImage(goodsImageVo)));
            map.put("msg","上传成功");
            return map;
        }
        map.put("code","0");
        map.put("msg","上传失败失败,请选择图片上传");
        return map;

    }
    //查询图片列表
    @RequestMapping("goodsImgList")
    public List<GoodsImageVo> goodsImageVoList(int goodsId){
        return  goodsService.goodsImgList(goodsId);
    }
    //删除商品图片
    @RequestMapping("delGoodsImgById")
    public int del(int id){
        return goodsService.deleteGoodsImage(id);
    }
    //根据商品图片id查询信息
    @RequestMapping("queryGoodsImgById")
    public GoodsImageVo queryGoodsImgById(int id){
        return goodsService.queryGoodsImgById(id);
    }
    //修改商品图片
    @RequestMapping("updateGoodsImg")
    public Map updateGoodsImg(MultipartFile img, String id) throws IOException {
        System.out.println("----------------------"+img);
        System.out.println("----------------------"+id);
        Map<String,String> map =new HashMap<String,String>();
        //判断是否是图片
        String type=img.getContentType();
        if (type.equals("image/png") || type.equals("image/jpg") || type.equals("image/jpeg") || type.equals("image/bmp") || type.equals("image/gif") || type.equals("image/webp")){
            GoodsImageVo goodsImageVo = new GoodsImageVo();
            goodsImageVo.setAdders("./src/resource/image/" + img.getOriginalFilename());  //保存到数据库的【相对路径】
            goodsImageVo.setId(Integer.parseInt(id));
            System.out.println(img.getBytes().length);
//            //将上传的文件保存到服务器上的前端项目的【绝对路径】
            img.transferTo(new File(ServiceImplUtil.filePath + img.getOriginalFilename()));
            map.put("code",String.valueOf( goodsService.updateGoodsImage(goodsImageVo)));
            map.put("msg","上传成功");
            return map;
        }
        map.put("code","0");
        map.put("msg","上传失败失败,请选择图片上传");
        return map;

    }
}

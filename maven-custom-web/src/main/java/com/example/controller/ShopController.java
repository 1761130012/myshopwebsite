package com.example.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.dao.UserShopDao;
import com.example.service.GoodsService;
import com.example.service.ShopService;
import com.example.service.UserService;
import com.example.utils.DelSpaceEmpty;
import com.example.vo.ShopVo;
import com.example.vo.SupplierGoodsVo;
import com.example.vo.UserShopVo;
import com.example.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 店铺表 前端控制器
 * </p>
 *
 * @author LLY
 * @since 2020-12-08
 */
@RestController
@RequestMapping("/shop")
@CrossOrigin
public class ShopController {

    @Autowired
    private ShopService shopService;

    @Autowired
    GoodsService goodsService;

    @Autowired
    UserService userService;

    @RequestMapping("/selectShopVo")
    public Page<ShopVo> select(@RequestParam(value = "page", defaultValue = "1") int page,
                               @RequestParam(value = "rows", defaultValue = "5") int rows
            , ShopVo shopVo) {

        return shopService.selectPage(new Page<ShopVo>(page, rows), shopVo);
    }

    @RequestMapping("/selectShopVoId")
    public List<ShopVo> selectById (ShopVo shopVo) {

        return shopService.selectById(shopVo);
    }

    @RequestMapping("/deleteShopVo")
    public int delete(String id) {
        return shopService.delete(id);
    }

    @RequestMapping("/updateShopVo")
    public int delete(ShopVo shopVo) {
        return shopService.update(shopVo);
    }

    @RequestMapping("/addShopVo")
    public int add(ShopVo shopVo) {
        return shopService.add(shopVo);
    }

    @RequestMapping("/queryPageVo")
    public Page<ShopVo> queryPageVo(Page<ShopVo> page, ShopVo shopVo) {
        return shopService.selectPageVo(page, DelSpaceEmpty.disposeVoString(shopVo));
    }


    @RequestMapping("/addUserShop")
    public int addUserShop(UserShopVo userShopVo,UserVo userVo) {
        //根据 登录名 查询 id
        userShopVo.setUserId(userService.getUserId(userVo));
        userShopVo.setState(0);
        return shopService.addUserShop(userShopVo);
    }


    /**
     * 传输 根据 用户id 查询 的 商铺 id
     *
     * @return
     */
    @RequestMapping("/queryAllShopVoByLoginName")
    public Map<String, Object> queryAllShopVoByLoginName(String loginName, String orderId) {
        return shopService.selectAllShopVoByLoginName(loginName, orderId);
    }

    /**
     * 传输 根据 用户id 查询 商铺信息
     *
     * @param userVo
     * @return
     */
    @RequestMapping("/queryShopVo")
    public ShopVo queryShopVo(UserVo userVo) {
        UserVo userVos = goodsService.queryUser(userVo);

        return shopService.queryShopVo(userVos);
    }


    //默认 查询 状态 为 默认 选择 的
    @RequestMapping("/queryShopVoByLoginName")
    public Map<String, Object> queryShopVoByLoginName(String loginName, String orderId) {
        return shopService.selectShopVoByLoginName(loginName, orderId);
    }

    @RequestMapping("/updatePassState")
    public boolean updatePassState(Integer shopId) {
        ShopVo shopVo = new ShopVo();
        shopVo.setShopId(shopId);
        shopVo.setState(1);
        return shopService.updateById(shopVo);
    }

    @RequestMapping("/updateErrorState")
    public boolean updateErrorState(Integer shopId) {
        ShopVo shopVo = new ShopVo();
        shopVo.setShopId(shopId);
        shopVo.setState(2);
        return shopService.updateById(shopVo);
    }

    @RequestMapping("/queryUserVoByShopId")
    public UserVo queryUserVoByShopId(Integer shopId) {
        return shopService.queryUserVoByShopId(shopId);
    }

    @RequestMapping("/queryShopId")
    public ShopVo queryShopId(UserShopVo userShopVo, UserVo userVo){
        userShopVo.setUserId(shopService.getUserId(userVo).getUserId());
        int id = shopService.getShopId(userShopVo);
        System.out.println("--------------"+id+"-------------");

        return shopService.queryId(id);
    }


    @RequestMapping("/updateErrorStateByLoginName")
    public List<ShopVo> updateErrorStateByLoginName(UserVo userVo) {
        //根据 登录名 查询 id
        userVo.setUserId(userService.getUserId(userVo));

        //根据  用户 id 查询 user_shop shopId 商户 id 集合
        List<UserShopVo> list = shopService.selectShopById(userVo);

        System.out.println(list.size()+"------------");
        //就 根据 商户 id  查询 所有的 商户 id shop
        // where shop_Id not in  (商户 id 集合)
        Integer[] shopIds = new Integer[list.size()];
        for(int i=0;i<list.size();i++){
            System.out.println("------------------------------");
            System.out.println(list.get(i));
            System.out.println("------------------------------");
            shopIds[i] = list.get(i).getShopVo().getShopId();
        }
        System.out.println("------------------------------");
        for(int i=0;i<list.size();i++){
            System.out.println(shopIds[i]);
        }
        System.out.println("------------------------------");
        return shopService.updateErrorState(shopIds);
    }
}

package com.example.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.vo.OrderVo;
import com.example.vo.ShopVo;
import com.example.vo.UserShopVo;
import com.example.vo.UserVo;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 店铺表 服务类
 * </p>
 *
 * @author LLY
 * @since 2020-12-08
 */
public interface ShopService extends IService<ShopVo> {

    Page<ShopVo> selectPageVo(Page<ShopVo> page, ShopVo shopVo);

    Page<ShopVo> selectPage(Page<ShopVo> page, ShopVo shopVo);

    int delete(String id);

    int update(ShopVo shopVo);

    int add(ShopVo shopVo);

    Map<String, Object> selectAllShopVoByLoginName(String loginName, String orderId);

    Map<String, Object> selectShopVoByLoginName(String loginName, String orderId);

    ShopVo queryShopVo(UserVo userVos);

    /**
     * 根据 商户 id 查询 用户vo
     *
     * @param shopId
     * @return
     */
    UserVo queryUserVoByShopId(Integer shopId);

}

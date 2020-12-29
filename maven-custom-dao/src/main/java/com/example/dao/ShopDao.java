package com.example.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.vo.ShopVo;
import com.example.vo.UserShopVo;
import com.example.vo.UserVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 店铺表 Mapper 接口
 * </p>
 *
 * @author LLY
 * @since 2020-12-10
 */
public interface ShopDao extends BaseMapper<ShopVo> {

    Page<ShopVo> selectPageVo(@Param("page") Page<ShopVo> page, @Param("shopVo") ShopVo shopVo);

    Page<ShopVo> selectPage(@Param("page") Page<ShopVo> page, @Param("shopVo") ShopVo shopVo);

    ShopVo selectShopInfoById(@Param("id") Integer id);

    /**
     * 根据 用户 id 查询 商户 id
     * @param userId 用户 id
     * @return
     */
    Integer selectIdByUserId(@Param("userId") Integer userId);


    ShopVo queryShopVo(UserVo userVos);

    /**
     * 根据 商户 id 查询 用户id
     * @param shopId
     * @return
     */
    Integer selectUserIdByShopId(@Param("shopId") Integer shopId);

    List<ShopVo> selectId(ShopVo shopVo);

    ShopVo selectByShopId(Integer shopId);

    List<ShopVo> updateErrorState(@Param("shopIds")Integer[] shopIds);
}

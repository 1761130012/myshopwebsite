package com.example.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.vo.ShopVo;
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


}

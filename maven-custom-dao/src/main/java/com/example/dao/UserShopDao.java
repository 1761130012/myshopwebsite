package com.example.dao;

import com.example.vo.UserShopVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 用户商户表 Mapper 接口
 * </p>
 *
 * @author LLY
 * @since 2020-12-10
 */
public interface UserShopDao extends BaseMapper<UserShopVo> {

    List<UserShopVo> selectAllByUserId(@Param("userId") Integer userId);

    Integer selectShopVoByState(@Param("userId") Integer userId, @Param("state") int state);
}


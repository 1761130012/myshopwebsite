package com.example.dao;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.vo.UserVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author LLY
 * @since 2020-12-10
 */
public interface UserDao extends BaseMapper<UserVo> {
    /**
     * 根据 登录名  获取  id
     *
     * @param loginName
     * @return
     */
    Integer selectIdByLoginName(@Param("loginName") String loginName);

    Page<UserVo> selectPageVo(@Param("userVoPage") Page<UserVo> userVoPage, @Param("userVo") UserVo userVo);


}

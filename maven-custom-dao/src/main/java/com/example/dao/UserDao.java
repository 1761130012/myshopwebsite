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

    UserVo query(UserVo userVo);

    /**
     * 根据 用户 id 查询 用户
     *
     * @param userId
     * @return
     */
    UserVo selectUserVoById(@Param("userId") Integer userId);

    /**
     * 根据 用户 id 查询 数据
     *
     * @param loginName
     * @return
     */
    Integer selectCountById(@Param("loginName") String loginName);

    /**
     * 进行 根据 登录 名 和 密码 进行  查询 数量
     *
     * @param userVo
     * @return
     */
    Integer selectCountByLoginNamePwd(@Param("userVo") UserVo userVo);
}

package com.example.dao;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.vo.StaffVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 员工表 Mapper 接口
 * </p>
 *
 * @author LLY
 * @since 2020-12-10
 */
public interface StaffDao extends BaseMapper<StaffVo> {

    Page<StaffVo> selectPageVo(@Param("staffVoPage") Page<StaffVo> staffVoPage,
                               @Param("staffVo") StaffVo staffVo);

    /**
     * 根据登录名 进行 查询
     *
     * @param loginName
     * @return
     */
    Integer selectIdByLoginName(@Param("loginName") String loginName);


    /**
     * 查询 员工 分页
     *
     * @param page
     * @param value
     * @return
     */
    Page<StaffVo> selectAllPageVo(@Param("page") Page<StaffVo> page, @Param("value") String value);

    /**
     * 根据 登录 名 和 密码 查询
     * @param staffVo
     * @return
     */
    int selectCountByLoginNamePwd(@Param("staffVo") StaffVo staffVo);

    /**
     *查询 员工 名称
     * @param loginName
     * @return
     */
    String selectStaffNameByLoginName(@Param("loginName") String loginName);

    /**
     * 根据 loginName 模糊 查询 出 所有的 登录 名
     * @param loginName
     * @return
     */
    List<String> selectAllLoginNameByIdByLoginName(@Param("loginName") String loginName);

    /**
     * 查询 登录 名 个数
     * @param loginName
     * @return
     */
    int selectCountByLoginName(@Param("loginName") String loginName);
}
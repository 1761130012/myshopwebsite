package com.example.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.vo.StaffVo;

/**
 * <p>
 * 员工表 服务类
 * </p>
 *
 * @author LLY
 * @since 2020-12-08
 */
public interface StaffService extends IService<StaffVo> {

    Page<StaffVo> selectPageVo(Page<StaffVo> staffVoPage, StaffVo staffVo);


    /**
     * 查询 所有 员工 进行 分页
     *
     * @param page
     * @param value
     * @return
     */
    Page<StaffVo> selectAllPageVo(Page<StaffVo> page, String value);

    /**
     * 员工登录
     *
     * @param staffVo
     * @return
     */
    boolean staffLogin(StaffVo staffVo);

    /**
     * 查询 昵称
     * @param loginName
     * @return
     */
    String queryStaffNameByLoginName(String loginName);
}


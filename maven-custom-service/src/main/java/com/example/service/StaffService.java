package com.example.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.vo.StaffVo;

import java.util.List;
import java.util.Map;

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
     *
     * @param loginName
     * @return
     */
    String queryStaffNameByLoginName(String loginName);

    /**
     * 修改员工 角色 id
     *
     * @param map
     * @return
     */
    boolean updateStaffRoleIds(Map<String, Object> map);


    /**
     * 读取 地址 的 文件 进行 解析
     * @param absolutePath
     * @return
     */
    List<StaffVo> readFile(String absolutePath);

    /**
     * 查询 是否 存在 登录名
     * @param loginName
     * @return
     */
    boolean queryIsExistByLoginName(String loginName);
}


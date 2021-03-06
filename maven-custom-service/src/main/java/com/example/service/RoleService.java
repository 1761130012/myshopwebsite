package com.example.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.vo.RoleVo;
import com.example.vo.StaffVo;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 角色表 服务类
 * </p>
 *
 * @author LLY
 * @since 2020-12-08
 */
public interface RoleService extends IService<RoleVo> {

    boolean updateRoleMenuId(Map<String, Object> map);

    Page<RoleVo> selectPageVo(Page<RoleVo> roleVoPage, RoleVo roleVo);

    /**
     * 根据 员工id 查询 角色信息
     *
     * @param staffId
     * @return
     */
    List<Integer> selectRoleVoByStaffId(Integer staffId);
}
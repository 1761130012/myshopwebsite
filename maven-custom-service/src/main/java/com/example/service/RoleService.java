package com.example.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.vo.RoleVo;

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
}

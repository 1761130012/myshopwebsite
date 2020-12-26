package com.example.dao;

import com.example.vo.StaffRoleVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 员工角色表 Mapper 接口
 * </p>
 *
 * @author LLY
 * @since 2020-12-10
 */
public interface StaffRoleDao extends BaseMapper<StaffRoleVo> {
    /**
     * 根据员工 id 查询 角色 id
     *
     * @param staffId
     * @return
     */
    List<Integer> selectRoleIdByStaffId(@Param("staffId") Integer staffId);


    /**
     * 修改
     *
     * @param roleIds
     * @param staffId
     * @return
     */
    Integer insertStaffRoleIds(@Param("roleIds") List<Integer> roleIds, @Param("staffId") Integer staffId);

    /**
     * 根据 员工id 进行 删除
     * @param staffId
     */
    void deleteByStaffId(@Param("staffId") Integer staffId);
}

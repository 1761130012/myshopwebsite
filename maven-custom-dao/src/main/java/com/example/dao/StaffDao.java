package com.example.dao;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.vo.StaffVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

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
}

package com.example.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.vo.UserVo;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author LLY
 * @since 2020-12-08
 */
public interface UserService extends IService<UserVo> {
    Page<UserVo> selectPageVo(Page<UserVo> userVoPage,UserVo userVo);
}

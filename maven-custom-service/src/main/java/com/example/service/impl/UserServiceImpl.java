package com.example.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.dao.UserDao;
import com.example.service.UserService;
import com.example.vo.UserVo;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author LLY
 * @since 2020-12-08
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserDao, UserVo> implements UserService {

}

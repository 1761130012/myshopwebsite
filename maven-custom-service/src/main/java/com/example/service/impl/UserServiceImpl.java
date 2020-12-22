package com.example.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.dao.UserDao;
import com.example.dao.UserShopDao;
import com.example.service.UserService;
import com.example.vo.ShopVo;
import com.example.vo.UserShopVo;
import com.example.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Autowired
    UserDao userDao;

    @Override
    public Page<UserVo> selectPageVo(Page<UserVo> userVoPage, UserVo userVo) {
        return userDao.selectPageVo(userVoPage,userVo);
    }

}

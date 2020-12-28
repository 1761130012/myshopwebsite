package com.example.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.dao.ShopCartDao;
import com.example.dao.UserDao;
import com.example.dao.UserShopDao;
import com.example.service.UserService;
import com.example.vo.ShopCartVo;
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
    private UserDao userDao;

    @Autowired
    private ShopCartDao shopCartDao;

    @Override
    public Page<UserVo> selectPageVo(Page<UserVo> userVoPage, UserVo userVo) {
        return userDao.selectPageVo(userVoPage, userVo);
    }

    @Override
    public boolean updateRegisterByUserId(UserVo userVo) {
        Integer count = userDao.selectCountById(userVo.getLoginName());
        return count <= 0 && userDao.insert(userVo) > 0;
    }

    @Override
    public boolean queryUserIdError(String loginName) {
        return userDao.selectCountById(loginName) > 0;
    }

    @Override
    public boolean insertUserGoodsByInfo(ShopCartVo shopCartVo, String loginName) {
        //根据 用户名 进行 查询
        shopCartVo.setUserId(userDao.selectIdByLoginName(loginName));
        return shopCartDao.insert(shopCartVo) > 0;
    }

    @Override
    public boolean userLogin(UserVo userVo) {
        return userDao.selectCountByLoginNamePwd(userVo) > 0;
    }

    @Override
    public boolean queryIsLoginName(String loginName) {
        return userDao.selectCountByLoginName(loginName) > 0;
    }

    @Override
    public List<UserVo> selectList(UserVo userVo) {
        return userDao.selectUserVo(userVo);
    }

}

package com.example.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.vo.ShopCartVo;
import com.example.vo.ShopVo;
import com.example.vo.UserShopVo;
import com.example.vo.UserVo;

import java.util.List;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author LLY
 * @since 2020-12-08
 */
public interface UserService extends IService<UserVo> {
    Page<UserVo> selectPageVo(Page<UserVo> userVoPage, UserVo userVo);


    /**
     * 添加
     *
     * @param userVo
     * @return
     */
    boolean updateRegisterByUserId(UserVo userVo);

    /**
     * 查询 用户 id 是否 重名
     *
     * @param loginName
     * @return
     */
    boolean queryUserIdError(String loginName);

    /**
     * 进行 添加到购物车
     * @param shopCartVo
     * @param loginName
     * @return
     */
    boolean insertUserGoodsByInfo(ShopCartVo shopCartVo, String loginName);

    /**
     * 进行 登录
     * @param userVo
     * @return
     */
    boolean userLogin(UserVo userVo);

    List<UserVo> selectList(UserVo userVo);
}

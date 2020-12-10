package com.example.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.dao.MenuDao;
import com.example.service.MenuService;
import com.example.vo.MenuVo;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 菜单表 服务实现类
 * </p>
 *
 * @author LLY
 * @since 2020-12-08
 */
@Service
public class MenuServiceImpl extends ServiceImpl<MenuDao, MenuVo> implements MenuService {

}

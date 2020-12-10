package com.example.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.dao.StaffDao;
import com.example.service.StaffService;
import com.example.vo.StaffVo;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 员工表 服务实现类
 * </p>
 *
 * @author LLY
 * @since 2020-12-08
 */
@Service
public class StaffServiceImpl extends ServiceImpl<StaffDao, StaffVo> implements StaffService {

}

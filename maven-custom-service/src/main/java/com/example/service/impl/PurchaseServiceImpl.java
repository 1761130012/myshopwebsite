package com.example.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.dao.PurchaseDao;
import com.example.service.PurchaseService;
import com.example.vo.PurchaseVo;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 采购记录表 服务实现类
 * </p>
 *
 * @author LLY
 * @since 2020-12-08
 */
@Service
public class PurchaseServiceImpl extends ServiceImpl<PurchaseDao, PurchaseVo> implements PurchaseService {

}

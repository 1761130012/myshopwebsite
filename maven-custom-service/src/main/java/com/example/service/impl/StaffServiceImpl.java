package com.example.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.dao.StaffDao;
import com.example.dao.StaffRoleDao;
import com.example.service.StaffService;
import com.example.utils.PinyinUtil;
import com.example.utils.ServiceImplUtil;
import com.example.vo.StaffVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

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

    @Autowired
    private StaffDao staffDao;
    @Autowired
    private StaffRoleDao staffRoleDao;

    @Autowired
    private ServiceImplUtil serviceImplUtil;

    @Override
    public Page<StaffVo> selectPageVo(Page<StaffVo> staffVoPage, StaffVo staffVo) {
        return staffDao.selectPageVo(staffVoPage, staffVo);
    }

    @Override
    public Page<StaffVo> selectAllPageVo(Page<StaffVo> page, String value) {
        return staffDao.selectAllPageVo(page, value);
    }

    @Override
    public boolean staffLogin(StaffVo staffVo) {
        return staffDao.selectCountByLoginNamePwd(staffVo) > 0;
    }

    @Override
    public String queryStaffNameByLoginName(String loginName) {
        return staffDao.selectStaffNameByLoginName(loginName);
    }

    @Override
    public boolean updateStaffRoleIds(Map<String, Object> map) {
        //进行 删除
        staffRoleDao.deleteByStaffId((Integer) map.get("staffId"));
        return staffRoleDao.insertStaffRoleIds((List<Integer>) map.get("roleIds"), (Integer) map.get("staffId")) > 0;
    }

    @Override
    public List<StaffVo> readFile(String absolutePath) {
        List<StaffVo> staffVos = serviceImplUtil.readFile(StaffVo.class, absolutePath);

        //循环 生成  用户 名 和 默认 密码
        for (StaffVo staffVo : staffVos) {
            //性别
            String sexStr = staffVo.getSexStr();
            if ("男".equals(sexStr)) {
                staffVo.setSex(0);
            } else if ("女".equals(sexStr)) {
                staffVo.setSex(1);
            } else {
                //超出范围 不显示
                staffVo.setSex(-1);
            }

            String loginName = PinyinUtil.getPinyinByString(staffVo.getName());

            //根据 登录 名 进行 查询 所有前缀相同的  进行 createLoginName 生成
            List<String> list = staffDao.selectAllLoginNameByIdByLoginName(loginName);
            if (list.size() > 0) {
                loginName = serviceImplUtil.createLoginName(list, loginName);
            }
            staffVo.setLoginName(loginName);
            staffVo.setPassword("123456");
        }

        return staffVos;
    }

    @Override
    public boolean queryIsExistByLoginName(String loginName) {
        return staffDao.selectCountByLoginName(loginName) > 0;
    }
}

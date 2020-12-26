package com.example.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.dao.StaffDao;
import com.example.dao.StaffRoleDao;
import com.example.service.StaffService;
import com.example.vo.StaffVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}

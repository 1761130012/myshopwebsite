package com.example.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.service.StaffService;
import com.example.utils.ServiceImplUtil;
import com.example.vo.StaffVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import sun.plugin2.util.SystemUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 员工表 前端控制器
 * </p>
 *
 * @author LLY
 * @since 2020-12-08
 */
@RestController
@RequestMapping("/staff")
@CrossOrigin
public class StaffController {

    @Autowired
    private StaffService staffService;


    @RequestMapping("/queryPageVo")
    public Page<StaffVo> queryPageVo(@RequestParam(value = "page", defaultValue = "1") int page,
                                     @RequestParam(value = "rows", defaultValue = "5") int rows,
                                     StaffVo staffVo) {
        return staffService.selectPageVo(new Page<StaffVo>(page, rows), staffVo);
    }

    @RequestMapping("/add")
    public boolean add(@RequestBody StaffVo staffVo) {
        return staffService.save(staffVo);
    }

    @RequestMapping("/querybid")
    public StaffVo querybyid(Integer id) {
        return staffService.getById(id);
    }

    @RequestMapping("/updata")
    public boolean updata(@RequestBody StaffVo staffVo) {
        return staffService.updateById(staffVo);
    }

    @RequestMapping("/delete")
    public boolean delete(@RequestBody Integer[] ids) {
        boolean bool = false;
        for (int i = 0; i < ids.length; i++) {
            bool = staffService.removeById(ids[i]);
        }
        return bool;
    }

    @RequestMapping("/adds.action")
    public Map addGoods(StaffVo staffVo, @RequestParam("img") MultipartFile img) throws IOException {
        Map<String, String> map = new HashMap<String, String>();
        staffVo.setHeadImage("./src/assets/" + img.getOriginalFilename());  //保存到数据库的【相对路径】
        System.out.println(staffVo);
        System.out.println(img.getBytes().length);
        //将上传的文件保存到服务器上的前端项目的【绝对路径】
        img.transferTo(new File("E:\\guiguidea\\homework\\vueproject\\project-web\\src\\assets\\" + img.getOriginalFilename()));

        map.put("code", "0");
        map.put("msg", "添加成功");

        return map;
    }

    @RequestMapping("/queryAllPageVo")
    public Page<StaffVo> queryAllPageVo(Page<StaffVo> page, String value) {
        return staffService.selectAllPageVo(page, value);

    }

    @RequestMapping("/staffLogin")
    public boolean staffLogin(StaffVo staffVo) {
        return staffService.staffLogin(staffVo);
    }

    @RequestMapping("/queryStaffNameByLoginName")
    public String queryStaffNameByLoginName(String loginName) {
        return staffService.queryStaffNameByLoginName(loginName);
    }

    @RequestMapping("/updateStaffRoleIds")
    public boolean updateStaffRoleIds(@RequestBody Map<String, Object> map) {
        return staffService.updateStaffRoleIds(map);
    }

    @RequestMapping("/readFileStaff")
    public List<StaffVo> readFileStaff(@RequestParam MultipartFile file, HttpServletRequest request) throws IOException {
        //进行 写 到 文件 中 项目地址
        String path = request.getServletContext().getRealPath("/resource/file");
        String fileName = "staffVoInfoFile." + file.getOriginalFilename().split("\\.")[1];
        //判断 是否 有这个 文件
        File newFile = new File(path, fileName);
        if (!newFile.exists()) {
            newFile.mkdirs();
            newFile.createNewFile();
        }

        //进行 写入 在 读取
        file.transferTo(newFile);
        //读取
        return staffService.readFile(newFile.getAbsolutePath());
    }


    @RequestMapping("/insertBathStaffVo")
    public boolean insertBathStaffVo(@RequestBody List<StaffVo> list) {
        for (StaffVo staffVo : list) {
            staffVo.setCreateTime(new Date());
        }
        return staffService.saveBatch(list);
    }

    @RequestMapping("/queryIsExistByLoginName")
    public boolean queryIsExistByLoginName(String loginName) {
        return staffService.queryIsExistByLoginName(loginName);
    }
}

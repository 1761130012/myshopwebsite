package com.example.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

/**
 * 下载 文件的 类
 *
 * @author LLY
 */
@RestController
@RequestMapping("/downloadFile")
@CrossOrigin
public class DownloadFileController {

    @RequestMapping("/downloadFileTemplate")
    public void downloadFileTemplate(String fileName, HttpServletRequest request, HttpServletResponse response) throws IOException {
        String path = request.getServletContext().getRealPath("/resource/file") + "\\" + fileName;
        System.out.println(path);

        File file = new File(path);
        if (!file.exists()) {
            response.setContentType("text/html;charset=UTF-8");
            response.getWriter().println("<html><body><script type='text/javascript'>alert('您要下载的资源已被删除！');</script></body></html>");
            response.getWriter().close();
            System.out.println("您需下载 的资源已被删除！");
            return;
        }
        //进行 转码 免中文乱码
        fileName = URLEncoder.encode(fileName, "UTF-8");
        //设置 文件 下载 头
        response.addHeader("Content-Disposition", "attachment;filename=" + fileName);
        //设置文件ContentType类型  这样设置，会自动判断下载文件类型
        response.setContentType("multipart/form-data");
        //读取 下载的文件 保存 到 文件 输入流
        FileInputStream in = new FileInputStream(path);
        //创 键输出流
        ServletOutputStream out = response.getOutputStream();

        //缓存区
        byte[] bytes = new byte[1024];
        //记录了 读取了多少 数据 而不是全部写入
        int len = 0;
        while ((len = in.read(bytes)) > 0) {
            //写入
            out.write(bytes, 0, len);
        }
        //关闭文件输入流
        in.close();
        // 关闭输出流
        out.close();
    }
}

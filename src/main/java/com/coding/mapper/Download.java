package com.coding.mapper;

import org.apache.tomcat.util.http.fileupload.IOUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;

public class Download extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1. 获取要下载的文件名
        String downloadFilename = "c.jpg";
        // 2. 读取要下载的文件内容(通过ServletContext对象可以读取)
        ServletContext servletContext = getServletContext();
        /**
         * 斜杠被服务器解析表示地址为http://ip:port/工程路径/ 映射到代码的web目录
         */
        InputStream resourceAsStream = servletContext.getResourceAsStream("/file/" + downloadFilename);
        // 3. 把要下载的文件内容回传给客户端
        // 获取响应的输出流
        OutputStream outputStream = resp.getOutputStream();
        // 读取输入流中全部的数据,复制给输出流,输出给客户端
        IOUtils.copy(resourceAsStream, outputStream);
        // 4. 在回传前，通过响应头告诉客户端返回的数据类型
        // 获取要下载的文件类型
        String mimeType = servletContext.getMimeType("/file/" + downloadFilename);
        resp.setContentType(mimeType);
        // 5. 还要告诉客户端收到的数据是用于下载使用(还是使用响应头)
        // Content-Disposition响应头，表示收到的数据怎么处理
//        resp.setHeader("Content-Disposition","attachment; filename=" + downloadFilename);
        // URLEncoder.encode是把汉字转化成%xx%xx的格式
        resp.setHeader("Content-Disposition","attachment; filename=" + URLEncoder.encode("中国.jpg","UTF-8"));
    }

}

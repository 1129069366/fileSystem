package com.system.fileSystem.controller.Impl;

import com.system.fileSystem.controller.FileController;
import com.system.fileSystem.domain.TxtUrl;
import com.system.fileSystem.domain.VideoUrl;
import com.system.fileSystem.service.FileService;
import com.system.fileSystem.service.TxtUrlService;
import com.system.fileSystem.service.VideoUrlService;
import org.csource.common.MyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @program: fileSystem
 * @description
 * @author: Mr.Yang
 * @create: 2021-10-29 16:01
 **/
@Controller
@RequestMapping("/filesystem")

public class FileControllerImpl implements FileController{


    @Autowired
    private FileService fileService;

    @Autowired
    private VideoUrlService videoUrlService;

    @Autowired
    private TxtUrlService txtUrlService;

    @GetMapping("/video/{vkey}/{b_name}")
    @Override
    public void downloadVideo(@PathVariable("vkey") String vkey,@PathVariable("b_name") String b_name,HttpServletResponse response) {
//        System.out.println("进来了"+fileId);

        //todo
        //根据传进来的id信息去查找视频路径
        VideoUrl videoUrl = videoUrlService.getVideoUrlByV_key(vkey);
        String filename = b_name+".mp4";
        String file_path = videoUrl.getUrl();
        try {
            //获取页面输出流
            ServletOutputStream outputStream = response.getOutputStream();
            //读取文件
            byte[] bytes = fileService.download(file_path);
            //向输出流写文件
            //写之前设置响应流以附件的形式打开返回值,这样可以保证前边打开文件出错时异常可以返回给前台
            response.setHeader("Content-Disposition","attachment;filename="+filename);
            outputStream.write(bytes);
            outputStream.flush();
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (MyException e) {
            e.printStackTrace();
        }


    }

    @GetMapping("/txt/{vkey}")
    @Override
    public void downloadTxt(@PathVariable("vkey") String vkey,HttpServletResponse response) {
//        System.out.println("进来了"+fileId);

        //todo
        //根据传进来的id信息去查找文件路径
        TxtUrl txtUrl = txtUrlService.geTxtUrlByV_key(vkey);
        String filename = txtUrl.getVkey().split("\\.")[0]+".txt";
        String file_path = txtUrl.getUrl();
        try {
            //获取页面输出流
            ServletOutputStream outputStream = response.getOutputStream();
            //读取文件
            byte[] bytes = fileService.download(file_path);
            //向输出流写文件
            //写之前设置响应流以附件的形式打开返回值,这样可以保证前边打开文件出错时异常可以返回给前台
            response.setHeader("Content-Disposition","attachment;filename="+filename);
            outputStream.write(bytes);
            outputStream.flush();
            outputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (MyException e) {
            e.printStackTrace();
        }


    }


}

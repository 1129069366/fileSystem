package com.system.fileSystem.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.csource.common.MyException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @program: fileSystem
 * @description
 * @author: Mr.Yang
 * @create: 2021-10-29 17:31
 **/
@Api("文件系统接口")
public interface FileController {


    @ApiOperation("下载视频接口")
    public void downloadVideo(String fileId,String b_name,HttpServletResponse response);

    @ApiOperation("下载文本接口")
    public void downloadTxt(String fileId,HttpServletResponse response);


}

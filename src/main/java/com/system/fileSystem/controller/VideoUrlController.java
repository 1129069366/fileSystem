package com.system.fileSystem.controller;

import io.swagger.annotations.Api;

/**
 * @program: fileSystem
 * @description
 * @author: Mr.Yang
 * @create: 2021-10-31 15:33
 **/
@Api("视频地址查询接口")
public interface VideoUrlController {
    public String getVideoUrlByVkey(String vkey);
}

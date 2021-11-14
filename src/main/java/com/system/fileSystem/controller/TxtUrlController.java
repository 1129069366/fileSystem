package com.system.fileSystem.controller;

import io.swagger.annotations.Api;

/**
 * @program: fileSystem
 * @description
 * @author: Mr.Yang
 * @create: 2021-10-31 16:48
 **/
@Api("文本管理接口")
public interface TxtUrlController {
    public String getTxtUrlByVkey(String vkey);

    public String getLogByVkey(String vkey);
}

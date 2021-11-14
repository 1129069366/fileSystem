package com.system.fileSystem.controller.Impl;

import com.system.fileSystem.controller.TxtUrlController;
import com.system.fileSystem.domain.TxtUrl;
import com.system.fileSystem.domain.VideoUrl;
import com.system.fileSystem.service.TxtUrlService;
import com.system.fileSystem.service.VideoUrlService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: fileSystem
 * @description
 * @author: Mr.Yang
 * @create: 2021-10-31 16:56
 **/
@RestController
@RequestMapping("/txt")
public class  TxtUrlControllerImpl implements TxtUrlController{
    @Autowired
    private TxtUrlService txtUrlService;

    @Override
    @GetMapping("/get/{vkey}")
    @ApiOperation("根据键查找文件路径")
    public String getTxtUrlByVkey(@PathVariable("vkey") String vkey) {

        TxtUrl tl = txtUrlService.geTxtUrlByV_key(vkey);
        if (tl!=null){
            return tl.getUrl();
        }
        return "nosuch!!";
    }


    @Override
    @GetMapping("/getLog/{vkey}")
    @ApiOperation("根据键查找文件路径")
    public String getLogByVkey(@PathVariable("vkey")String vkey) {
        TxtUrl tl = txtUrlService.geTxtUrlByV_key(vkey);
        if (tl!=null){
            return tl.getLog();
        }
        return "nosuch!!";
    }
}

package com.system.fileSystem.controller.Impl;

import com.system.fileSystem.controller.VideoUrlController;
import com.system.fileSystem.domain.VideoUrl;
import com.system.fileSystem.service.VideoUrlService;
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
 * @create: 2021-10-31 15:34
 **/
@RestController
@RequestMapping("/video")
public class VideoUrlControllerImpl implements VideoUrlController {

    @Autowired
    private VideoUrlService videoUrlService;

    @Override
    @GetMapping("/get/{vkey}")
    @ApiOperation("根据键查找视频路径")
    public String getVideoUrlByVkey(@PathVariable("vkey") String vkey) {

        VideoUrl vl = videoUrlService.getVideoUrlByV_key(vkey);
        if (vl!=null){
            return vl.getUrl();
        }
        return "nosuch!!";
    }
}

package com.system.fileSystem.service;

import com.system.fileSystem.dao.VideoUrlDao;
import com.system.fileSystem.domain.VideoUrl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: fileSystem
 * @description
 * @author: Mr.Yang
 * @create: 2021-10-31 15:34
 **/
@Service
public class VideoUrlService {

    @Autowired
    private VideoUrlDao videoUrlDao;

    public VideoUrl getVideoUrlByV_key(String v_key) {
        return videoUrlDao.findByVkey(v_key);
    }
}

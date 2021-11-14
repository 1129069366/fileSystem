package com.system.fileSystem.service;

import com.system.fileSystem.dao.TxtUrlDao;
import com.system.fileSystem.domain.TxtUrl;
import com.system.fileSystem.domain.VideoUrl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: fileSystem
 * @description
 * @author: Mr.Yang
 * @create: 2021-10-31 16:57
 **/
@Service
public class TxtUrlService {

    @Autowired
    private TxtUrlDao txtUrlDao;

    public TxtUrl geTxtUrlByV_key(String v_key) {
        return txtUrlDao.findByVkey(v_key);
    }

}

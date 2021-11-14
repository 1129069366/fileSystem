package com.system.fileSystem.dao;

import com.system.fileSystem.domain.VideoUrl;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @program: fileSystem
 * @description
 * @author: Mr.Yang
 * @create: 2021-10-31 15:35
 **/
public interface VideoUrlDao extends JpaRepository<VideoUrl,Integer> {
    public VideoUrl findByVkey(String vkey);
}

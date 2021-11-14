package com.system.fileSystem.domain;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

/**
 * @program: fileSystem
 * @description
 * @author: Mr.Yang
 * @create: 2021-10-31 15:28
 **/
@Table(name = "videourl")
@Data
@ToString
@Entity
public class VideoUrl {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY) //配置主键的生成策略
    Integer id;

    @Column(name = "vkey")
    private String vkey;

    @Column(name = "url")
    private String url;

}

package com.system.fileSystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @program: fileSystem
 * @description
 * @author: Mr.Yang
 * @create: 2021-10-29 15:49
 **/
@SpringBootApplication
@ComponentScan(basePackages = {"com.system.fileSystem"})
public class FileSystemApplication {
    public static void main(String[] args) {
        SpringApplication.run(FileSystemApplication.class);
    }
}

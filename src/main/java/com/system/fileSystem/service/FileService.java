package com.system.fileSystem.service;

import org.csource.common.MyException;
import org.csource.fastdfs.*;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.*;

/**
 * @program: fileSystem
 * @description
 * @author: Mr.Yang
 * @create: 2021-10-29 16:44
 **/
@Service
public class FileService {


    public byte[] download(String fileId) throws IOException, MyException {

        ClientGlobal.initByProperties("fastdfs-client.properties");
        TrackerClient tracker = new TrackerClient();
        TrackerServer trackerServer = tracker.getConnection();
        StorageServer storageServer = null;
        StorageClient1 storageClient1 = new StorageClient1(trackerServer,storageServer);

        byte[] result = storageClient1.download_file1(fileId);

        return result;
    }




}

package com.sys.fileSystem;

import com.system.fileSystem.FileSystemApplication;
import org.csource.common.MyException;
import org.csource.fastdfs.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @program: xc-online
 * @description
 * @author: Mr.Yang
 * @create: 2021-07-29 18:24
 **/
@SpringBootTest(classes = {FileSystemApplication.class})
@RunWith(SpringRunner.class)
public class TestFastDFS {

    //上传文件
    @Test
    public void testUpLoad(){

        try {
            //加载配置文件
            ClientGlobal.initByProperties("fastdfs-client.properties");
            //定义tracker客户端
            TrackerClient trackerClient = new TrackerClient();
            //连接tracker
            TrackerServer trackerServer = trackerClient.getConnection();
            //获取storage
            StorageServer storeStorage = trackerClient.getStoreStorage(trackerServer);

            //获取storage客户端
            StorageClient storageClient = new StorageClient(trackerServer,storeStorage);
            //向storage上传文件
            String fileName = "C:\\Users\\YBH\\Desktop\\研究生项目\\log\\2_20_2_20.txt";
            String[] fileId = storageClient.upload_file(fileName, ".txt", null);
            System.out.println(fileId[0]);
            System.out.println(fileId[1]);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (MyException e) {
            e.printStackTrace();
        }

    }

    //下载文件

    @Test
    public void testDownloadFile() throws IOException, MyException {
        ClientGlobal.initByProperties("fastdfs-client.properties");
        TrackerClient tracker = new TrackerClient();
        TrackerServer trackerServer = tracker.getConnection();
        StorageServer storageServer = null;
        StorageClient1 storageClient1 = new StorageClient1(trackerServer,storageServer);

        byte[] result = storageClient1.download_file1("group1/M00/00/00/wKgeg2F9LdaAGHVmAAqObuHfQZk17..mp4");

        File file = new File("d:/5.mp4");
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        fileOutputStream.write(result);
        fileOutputStream.close();

    }




}

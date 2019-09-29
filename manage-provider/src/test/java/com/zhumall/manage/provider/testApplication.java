package com.zhumall.manage.provider;


import org.csource.common.MyException;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class testApplication {

@Test
    public void contextLoad() throws IOException, MyException {

    String tracker = testApplication.class.getResource("/tracker.conf").getPath();
    ClientGlobal.init(tracker);

    TrackerClient trackerClient = new TrackerClient();

    TrackerServer trackerServer = trackerClient.getConnection();

    StorageClient storageClient = new StorageClient(trackerServer,null);

    String[] jpgs = storageClient.upload_file("/home/zhuzhu/文档/bbb.jps","jpg",null);
        for(String s : jpgs){
            System.out.println(s);
        }
}
}

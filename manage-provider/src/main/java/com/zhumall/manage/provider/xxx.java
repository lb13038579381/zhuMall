package com.zhumall.manage.provider;

import org.csource.common.MyException;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;

import java.io.IOException;

public class xxx {
    public static void main(String[] args) throws IOException, MyException {
        String tracker = xxx.class.getResource("/tracker.conf").getPath();
        ClientGlobal.init(tracker);

        TrackerClient trackerClient = new TrackerClient();

        TrackerServer trackerServer = trackerClient.getConnection();

        StorageClient storageClient = new StorageClient(trackerServer,null);

        String[] jpgs = storageClient.upload_file("/home/zhuzhu/文档/bbb.jpg","jpg",null);
        for(String s : jpgs){
            System.out.println(s);
        }
    }
}

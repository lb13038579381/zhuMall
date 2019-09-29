package com.zhumall.manage.provider.util;

import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.springframework.web.multipart.MultipartFile;


public class PmsUploadUtil {

    public String uploadImage(MultipartFile multipartFile) {
        String url = "http://192.168.122.1";
        String tracker = PmsUploadUtil.class.getResource("/tracker.conf").getPath();
        try {
            ClientGlobal.init(tracker);
            TrackerClient trackerClient = new TrackerClient();
            TrackerServer trackerServer = trackerClient.getConnection();
            StorageClient storageClient = new StorageClient(trackerServer, null);
            byte[] bytes = multipartFile.getBytes();

            String originFileName = multipartFile.getOriginalFilename();
            String extName = originFileName.substring(originFileName.lastIndexOf(".") + 1);
            String[] jpgs = storageClient.upload_file(bytes, extName, null);

            for (
                    String s : jpgs) {
                url += "/" + s;
            }
        } catch (Exception e) {
            e.toString();
        }
        return url;
    }
}

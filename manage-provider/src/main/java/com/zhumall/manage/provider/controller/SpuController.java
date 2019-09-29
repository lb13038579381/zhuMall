package com.zhumall.manage.provider.controller;


import com.zhumall.api.beans.PmsBaseSaleAttr;
import com.zhumall.api.beans.PmsProductImage;
import com.zhumall.api.beans.PmsProductInfo;
import com.zhumall.api.beans.PmsProductSaleAttr;
import com.zhumall.manage.provider.service.SpuService;
import com.zhumall.manage.provider.util.PmsUploadUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@ResponseBody
@Controller
@CrossOrigin
public class SpuController {
    private PmsUploadUtil pmsUploadUtil = new PmsUploadUtil();
    @Autowired
    private SpuService spuService;

    @RequestMapping("/spuList")
    public List<PmsProductInfo> getSpuList(String catalog3Id) {
        return spuService.getSpuList(catalog3Id);
    }

    @RequestMapping("/baseSaleAttrList")
    public List<PmsBaseSaleAttr> getBaseSaleAttrList() {
        return spuService.getBaseSaleAttrList();
    }

    @RequestMapping("/saveSpuInfo")
    public void save(@RequestBody PmsProductInfo pmsProductInfo) {
        System.out.println(pmsProductInfo);
    }

    @RequestMapping("/fileUpload")
    public String fileUpload(@RequestParam("file") MultipartFile multipartFile) {
            String s = pmsUploadUtil.uploadImage(multipartFile);
        System.out.println(s);
        return s;
    }


    @RequestMapping("/spuSaleAttrList")
    public List<PmsProductSaleAttr> getSpuSaleAttrList(String spuId) {
        return spuService.getSpuSaleAttrList(spuId);
    }

    @RequestMapping("/spuImageList")
    public  List<PmsProductImage> spuImageList(String spuId) {
        return spuService.spuImageList(spuId);
    }
}


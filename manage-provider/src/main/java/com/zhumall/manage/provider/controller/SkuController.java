package com.zhumall.manage.provider.controller;


import com.zhumall.api.beans.PmsSkuInfo;
import com.zhumall.manage.provider.service.SkuService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@ResponseBody
@Controller
@CrossOrigin
public class SkuController {

    @Autowired
    private SkuService skuService;

    @RequestMapping("/saveSkuInfo")
    public String saveSkuInfo(@RequestBody PmsSkuInfo pmsSkuInfo) {
        pmsSkuInfo.setProductId(pmsSkuInfo.getSpuId());
            String skuDefaultImg = pmsSkuInfo.getSkuDefaultImg();
            if(StringUtils.isBlank(skuDefaultImg)){
                    pmsSkuInfo.setSkuDefaultImg((pmsSkuInfo.getSkuImageList().get(0).getImgUrl()));
            }
        skuService.saveSkuInfo(pmsSkuInfo);
        return "success";
    }
}

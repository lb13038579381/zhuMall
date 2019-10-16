package com.zhumall.itemprovider.controller;

import com.alibaba.fastjson.JSON;
import com.zhumall.api.beans.PmsProductSaleAttr;
import com.zhumall.api.beans.PmsSkuInfo;
import com.zhumall.api.beans.PmsSkuSaleAttrValue;
import com.zhumall.manage.provider.service.SkuService;
import com.zhumall.manage.provider.service.SpuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.xml.bind.SchemaOutputResolver;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@CrossOrigin
public class ItemController {

    @Autowired
    private SkuService skuService;

    @Autowired
    private SpuService spuService;

    @RequestMapping("{skuId}.html")
    public String item(@PathVariable String skuId, ModelMap modelMap) {
        PmsSkuInfo pmsSkuInfo = skuService.getSkuById(skuId);
        modelMap.put("skuInfo", pmsSkuInfo);
        System.out.println(pmsSkuInfo);
        List<PmsProductSaleAttr> pmsProductSaleAttrs = spuService.spuSaleAttrListCheckBySku(pmsSkuInfo.getProductId(), pmsSkuInfo.getId());
        System.out.println(pmsProductSaleAttrs);
        modelMap.put("spuSaleAttrListCheckBySku", pmsProductSaleAttrs);

        //查询当前sku的spu的其他sku组成的hash表
        Map<String, String> skuSaleAttrHash = new HashMap<>();
        List<PmsSkuInfo> pmsProductInfos = skuService.getSkuSaleAttrValueListBySpu(pmsSkuInfo.getProductId());
        for (PmsSkuInfo pmsSkuInfo1 : pmsProductInfos) {
            String k = "";
            String v = pmsSkuInfo1.getId();
            for (PmsSkuSaleAttrValue pmsSkuSaleAttrValue : pmsSkuInfo1.getSkuSaleAttrValueList()) {
                k += pmsSkuSaleAttrValue.getSaleAttrValueId() + "|";
            }
            skuSaleAttrHash.put(k, v);
        }

        String skuSaleAttrHashJsonStr = JSON.toJSONString(skuSaleAttrHash);
        modelMap.put("skuSaleAttrHashJsonStr",skuSaleAttrHashJsonStr);
        return "item";
    }
}

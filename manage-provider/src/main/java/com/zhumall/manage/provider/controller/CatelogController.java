package com.zhumall.manage.provider.controller;


import com.zhumall.api.beans.*;
import com.zhumall.manage.provider.service.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@ResponseBody
@Controller
@CrossOrigin
public class CatelogController {

    @Autowired
    CatalogService catalogService;

    @RequestMapping("/getCatalog1")
    public List<PmsBaseCatalog1> getCatalog1() {
        List<PmsBaseCatalog1> pmsBaseCatalog1List = catalogService.getCatalog1();
        return pmsBaseCatalog1List;
    }

    @RequestMapping("/getCatalog2")
    public List<PmsBaseCatalog2> getCatalog2(String catalog1Id) {
        return catalogService.getCatalog2(catalog1Id);
    }

    @RequestMapping("/getCatalog3")
    public List<PmsBaseCatalog3> getCatalog3(String catalog2Id) {
        return catalogService.getCatalog3(catalog2Id);
    }

    @RequestMapping("/attrInfoList")
    public List<PmsBaseAttrInfo> getAttrInfo(String catalog3Id){
        return catalogService.getAttrInfo(catalog3Id);
    }

    //getAttrValueList?attrId=12
    @RequestMapping("/getAttrValueList")
    public List<PmsBaseAttrValue> getAttrValueList(String attrId) {
        return catalogService.getAttrValueList(attrId);
    }

    @RequestMapping("saveAttrInfo")
    public void saveAttrInfo(@RequestBody PmsBaseAttrInfo pmsBaseAttrInfo) {
        System.out.println(pmsBaseAttrInfo);
        catalogService.saveAttrInfo(pmsBaseAttrInfo);
    }
}

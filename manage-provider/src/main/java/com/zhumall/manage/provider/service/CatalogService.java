package com.zhumall.manage.provider.service;

import com.zhumall.api.beans.*;

import java.util.List;

public interface CatalogService {
    List<PmsBaseCatalog1> getCatalog1();
    List<PmsBaseCatalog2> getCatalog2(String catalog1Id);

    List<PmsBaseCatalog3> getCatalog3(String catalog2Id);
    List<PmsBaseAttrInfo> getAttrInfo(String catalog3Id);

    List<PmsBaseAttrValue> getAttrValueList(String attrId);

    void saveAttrInfo(PmsBaseAttrInfo pmsBaseAttrInfo);
}

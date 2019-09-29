package com.zhumall.manage.provider.service;

import com.zhumall.api.beans.PmsBaseSaleAttr;
import com.zhumall.api.beans.PmsProductImage;
import com.zhumall.api.beans.PmsProductInfo;
import com.zhumall.api.beans.PmsProductSaleAttr;

import java.util.List;

public interface SpuService {
    List<PmsProductInfo> getSpuList(String catalog3Id);

    List<PmsBaseSaleAttr> getBaseSaleAttrList();

    List<PmsProductSaleAttr> getSpuSaleAttrList(String spuId);

    List<PmsProductImage> spuImageList(String spuId);
}

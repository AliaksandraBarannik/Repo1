package org.example.service;

import org.example.object.GamingMouseProduct;
import org.example.object.HeadsetProduct;
import org.example.object.PhoneProduct;

import java.util.List;

public class ProductService {

    ShoppingCartPageService shoppingCartPageService = new ShoppingCartPageService();

    public PhoneProduct getPhoneProduct(List<String> list){
       return new PhoneProduct(list.get(0), list.get(4), list.get(1),list.get(2),list.get(3));
    }

    public PhoneProduct getActualPhoneObject() {
        PhoneProduct phoneProduct = new PhoneProduct();
        String productName = shoppingCartPageService.getItemNameText();
        phoneProduct.setName(productName);
        phoneProduct.setSize(shoppingCartPageService.getProductFieldValueByFieldNameText("Size"));
        phoneProduct.setColor(shoppingCartPageService.getProductFieldValueByFieldNameText("Color"));
        phoneProduct.setServiceProvider(shoppingCartPageService.getProductFieldValueByFieldNameText("Service Provider"));
        phoneProduct.setPrice(shoppingCartPageService.getItemPriceText());
        return phoneProduct;
    }

    public GamingMouseProduct getGamingMouseProduct(List<String> list){
        return new GamingMouseProduct(list.get(0).substring(0,40), list.get(4), list.get(2));
    }

    public GamingMouseProduct getActualMouseObject() {
        GamingMouseProduct gamingMouseProduct = new GamingMouseProduct();
        String productName = shoppingCartPageService.getItemNameText().substring(0,40);
        gamingMouseProduct.setName(productName);
        gamingMouseProduct.setColor(shoppingCartPageService.getProductFieldValueByFieldNameText("Color"));
        gamingMouseProduct.setPrice(shoppingCartPageService.getItemPriceText());
        return gamingMouseProduct;
    }

    public HeadsetProduct getHeadsetProduct(List<String> list){
        return new HeadsetProduct(list.get(0).substring(0,40), list.get(4), list.get(5));
    }

    public HeadsetProduct getActualHeadsetObject() {
        HeadsetProduct headsetProduct = new HeadsetProduct();
        String productName = shoppingCartPageService.getItemNameText().substring(0,40);
        headsetProduct.setName(productName);
        headsetProduct.setPrice(shoppingCartPageService.getItemPriceText());
        headsetProduct.setStyle(shoppingCartPageService.getProductFieldValueByFieldNameText("Style"));
        return headsetProduct;
    }
}

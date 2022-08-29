package org.example.service;

import org.example.object.GamingMouseProduct;
import org.example.object.HeadsetProduct;
import org.example.object.PhoneProduct;

import java.util.List;

public class ProductService {

    ShoppingCartPageService shoppingCartPageService = new ShoppingCartPageService();

    public PhoneProduct getActualPhoneObject() {
        return new PhoneProduct.PhoneBuilder()
                .withProduct(List.of(shoppingCartPageService.getItemNameText()), shoppingCartPageService.getItemPriceText())
                .withSize(shoppingCartPageService.getProductFieldValueByFieldNameText("Size"))
                .withColor(shoppingCartPageService.getProductFieldValueByFieldNameText("Color"))
                .withServiceProvider(shoppingCartPageService.getProductFieldValueByFieldNameText("Service Provider"))
                .build();
    }

    public HeadsetProduct getHeadsetActualObject() {
        return new HeadsetProduct.HeadSetBuilder()
                .withProduct(List.of(shoppingCartPageService.getItemNameText().substring(0, 60)), shoppingCartPageService.getItemPriceText())
                .withStyle(shoppingCartPageService.getProductFieldValueByFieldNameText("Style"))
                .build();
    }

    public GamingMouseProduct getActualMouseObject() {
        return new GamingMouseProduct.GamingMouseBuilder()
                .withProduct(List.of(shoppingCartPageService.getItemNameText().substring(0, 49)), shoppingCartPageService.getItemPriceText())
                .withColor(shoppingCartPageService.getProductFieldValueByFieldNameText("Color"))
                .build();
    }

//    public HeadsetProduct getHeadSetProduct() {
//        return HeadsetProduct.getHeadSet();
//    }
//
//    public PhoneProduct getPhoneProduct() {
//        return PhoneProduct.getPhone();
//    }
//
//    public GamingMouseProduct getGamingMouseProduct() {
//        return GamingMouseProduct.getGamingMouse();
//    }
}

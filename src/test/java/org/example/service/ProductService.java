package org.example.service;

import org.example.object.Product;
import org.example.util.GetProperties;

public class ProductService {

    ShoppingCartPageService shoppingCartPageService = new ShoppingCartPageService();

    private static final String PHONE_NAME = GetProperties.getProperties("product", "phone_name");
    private static final String PHONE_SIZE = GetProperties.getProperties("product", "phone_size");
    private static final String PHONE_COLOR = GetProperties.getProperties("product", "phone_color");
    private static final String PHONE_SERVICE_PROVIDER = GetProperties.getProperties("product", "phone_serviceProvider");
    private static final String PHONE_PRICE = GetProperties.getProperties("product", "phone_price");
    private static final String GAMING_MOUSE_NAME = GetProperties.getProperties("product", "gaming_mouse_name").substring(0, 49);
    private static final String GAMING_MOUSE_COLOR = GetProperties.getProperties("product", "gaming_mouse_color");
    private static final String GAMING_MOUSE_PRICE = GetProperties.getProperties("product", "gaming_mouse_price");
    private static final String HEADSET_NAME = GetProperties.getProperties("product", "headset_name").substring(0, 60);
    private static final String HEADSET_STYLE = GetProperties.getProperties("product", "headset_style");
    private static final String HEADSET_PRICE = GetProperties.getProperties("product", "headset_price");

    public Product getPhoneObjectFromProperties() {
        return new Product.ProductBuilder()
                .withName(PHONE_NAME)
                .withSize(PHONE_SIZE)
                .withColor(PHONE_COLOR)
                .withServiceProvider(PHONE_SERVICE_PROVIDER)
                .withPrice(PHONE_PRICE)
                .build();
    }

    public Product getActualPhoneObject() {
        return new Product.ProductBuilder()
                .withName(shoppingCartPageService.getItemNameText())
                .withSize(shoppingCartPageService.getListOfFieldsText("Size"))
                .withColor(shoppingCartPageService.getListOfFieldsText("Color"))
                .withServiceProvider(shoppingCartPageService.getListOfFieldsText("Service Provider"))
                .withPrice(shoppingCartPageService.getItemPriceText())
                .build();
    }

    public Product getHeadsetObjectFromProperties() {
        return new Product.ProductBuilder()
                .withName(HEADSET_NAME)
                .withStyle(HEADSET_STYLE)
                .withPrice(HEADSET_PRICE)
                .build();
    }

    public Product getHeadsetActualObject() {
        return new Product.ProductBuilder()
                .withName(shoppingCartPageService.getItemNameText().substring(0, 60))
                .withStyle(shoppingCartPageService.getListOfFieldsText("Style"))
                .withPrice(shoppingCartPageService.getItemPriceText())
                .build();
    }

    public Product getMouseObjectFromProperties() {
        return new Product.ProductBuilder()
                .withName(GAMING_MOUSE_NAME)
                .withColor(GAMING_MOUSE_COLOR)
                .withPrice(GAMING_MOUSE_PRICE)
                .build();
    }

    public Product getActualMouseObject() {
        return new Product.ProductBuilder()
                .withName(shoppingCartPageService.getItemNameText().substring(0, 49))
                .withColor(shoppingCartPageService.getListOfFieldsText("Color"))
                .withPrice(shoppingCartPageService.getItemPriceText())
                .build();
    }
}

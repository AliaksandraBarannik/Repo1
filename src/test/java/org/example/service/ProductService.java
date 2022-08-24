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
    private static final String KINDLE_NAME = GetProperties.getProperties("product", "kindle_name");
    private static final String KINDLE_OPTION = GetProperties.getProperties("product", "kindle_option");
    private static final String KINDLE_COLOR = GetProperties.getProperties("product", "kindle_color");

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

    public Product getKindleObjectFromProperties() {
        return new Product.ProductBuilder()
                .withName(KINDLE_NAME)
                .withOption(KINDLE_OPTION)
                .withColor(KINDLE_COLOR)
                .build();
    }

    public Product getActualKindleObject() {
        return new Product.ProductBuilder()
                .withName(shoppingCartPageService.getItemNameText())
                .withOption(shoppingCartPageService.getListOfFieldsText("Option"))
                .withColor(shoppingCartPageService.getListOfFieldsText("Color"))
                .build();
    }
}

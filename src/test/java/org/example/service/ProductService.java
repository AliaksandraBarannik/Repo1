package org.example.service;

import org.example.object.Product;
import org.example.util.GetProperties;

public class ProductService {

    ShoppingCartPageService shoppingCartPageService = new ShoppingCartPageService();

    private static final String NAME = GetProperties.getProperties("product", "name");
    private static final String SIZE = GetProperties.getProperties("product", "size");
    private static final String COLOR = GetProperties.getProperties("product", "color");
    private static final String SERVICE_PROVIDER = GetProperties.getProperties("product", "serviceProvider");
    private static final String PRICE = GetProperties.getProperties("product", "price");

    public Product getObjectFromProperties() {
        return new Product(NAME, SIZE, COLOR, SERVICE_PROVIDER, PRICE);
    }

    public Product getActualObject() {
        return new Product(shoppingCartPageService.getItemNameText(), shoppingCartPageService.getItemFieldsText("Size:"),
                shoppingCartPageService.getItemFieldsText("Color:"), shoppingCartPageService.getItemFieldsText("Service Provider:"),
                shoppingCartPageService.getItemPriceText());
    }
}

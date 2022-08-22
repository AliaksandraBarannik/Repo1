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

    public static final String ACTUAL_NAME = GetProperties.getProperties("product", "actual_name");
    private static final String ACTUAL_SIZE = GetProperties.getProperties("product", "actual_size");
    private static final String ACTUAL_COLOR = GetProperties.getProperties("product", "actual_color");
    private static final String ACTUAL_SERVICE_PROVIDER = GetProperties.getProperties("product", "actual_serviceProvider");
    private static final String ACTUAL_PRICE = GetProperties.getProperties("product", "actual_price");

    public Product getObjectFromProperties() {
        return new Product(NAME, SIZE, COLOR, SERVICE_PROVIDER, PRICE);
    }

    public Product getActualObject() {
        return new Product(shoppingCartPageService.getText(ACTUAL_NAME), shoppingCartPageService.getText(ACTUAL_SIZE),
                shoppingCartPageService.getText(ACTUAL_COLOR), shoppingCartPageService.getText(ACTUAL_SERVICE_PROVIDER),
                shoppingCartPageService.getText(ACTUAL_PRICE));
    }
}

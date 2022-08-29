package org.example.service;

import org.example.pages.ShoppingCartPage;

import java.util.logging.Logger;

public class ShoppingCartPageService extends BasePageService {

    public static final Logger log = Logger.getLogger(ShoppingCartPageService.class.getName());
    ShoppingCartPage shoppingCartPage = new ShoppingCartPage();

    public ShoppingCartPageService goToSoppingCartPage() {
        shoppingCartPage.goToSoppingCartPage();
        return this;
    }

    public boolean isShoppingCartDisplayed(String title) {
        boolean result = shoppingCartPage.getShoppingCartNameText().equals(title);
        log.info("Shopping cart is displayed - " + result);
        return result;
    }

    public boolean isListOfElementsInTheShoppingCartEmpty() {
        boolean result = shoppingCartPage.isListOfElementsInTheShoppingCartEmpty();
        log.info("List of elements in the shopping cart is empty - " + result);
        return result;
    }

    public String getItemNameText() {
        String name = shoppingCartPage.getItemsNameText();
        log.info("Get item name - " + name);
        return name;
    }

    public String getItemPriceText() {
        String price = shoppingCartPage.getItemsPriceText();
        log.info("Get item price - " + price);
        return price;
    }

    public String getProductFieldValueByFieldNameText(String key) {
        String fieldValue = shoppingCartPage.getProductFieldValueByFieldNameText(key);
        log.info("Get field value - " + fieldValue);
        return fieldValue;
    }

    public ShoppingCartPageService clickOnDeleteButton() {
        log.info("Click on 'Delete' button");
        shoppingCartPage.clickOnDeleteButton();
        return new ShoppingCartPageService();
    }
}

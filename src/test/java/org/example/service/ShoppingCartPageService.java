package org.example.service;

import org.example.pages.ShoppingCartPage;

import java.util.logging.Logger;

public class ShoppingCartPageService extends BasePageService {

    public static final Logger log = Logger.getLogger(ShoppingCartPageService.class.getName());
    ShoppingCartPage shoppingCartPage = new ShoppingCartPage();

    public boolean isShoppingCartDisplayed(String title) {
        boolean result = shoppingCartPage.getShoppingCartNameText().equals(title);
        log.info("Shopping cart is displayed " + result);
        return result;
    }

    public boolean isListOfElementsInTheShoppingCartEmpty() {
        boolean result = shoppingCartPage.isListOfElementsInTheShoppingCartEmpty();
        log.info("List of elements in the shopping cart is empty " + result);
        return result;
    }

    public String getItemNameText() {
        return shoppingCartPage.getItemsNameText();
    }

    public String getItemPriceText() {
        return shoppingCartPage.getItemsPriceText();
    }

    public String getListOfFieldsText(String key) {
        return shoppingCartPage.getListOfFieldsText(key);
    }
}

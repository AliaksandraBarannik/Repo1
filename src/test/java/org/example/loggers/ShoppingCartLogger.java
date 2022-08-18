package org.example.loggers;

import org.example.pages.InitDriver;
import org.example.pages.ShoppingCartPage;
import org.openqa.selenium.WebDriver;

import java.util.logging.Logger;

public class ShoppingCartLogger extends InitDriver {

    public static final Logger log = Logger.getLogger(ShoppingCartLogger.class.getName());
    ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);

    public ShoppingCartLogger(WebDriver driver) {
        super(driver);
    }

    public boolean isShoppingCartDisplayed() {
        boolean result = shoppingCartPage.isShoppingCartDisplayed();
        log.info("Shopping cart is displayed " + result);
        return result;
    }

    public boolean isListOfElementsInTheShoppingCartEmpty() {
        boolean result = shoppingCartPage.isListOfElementsInTheShoppingCartEmpty();
        log.info("List of elements in the shopping cart is empty " + result);
        return result;
    }
}

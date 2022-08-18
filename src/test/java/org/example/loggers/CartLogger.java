package org.example.loggers;

import org.example.pages.InitDriver;
import org.example.pages.CartPage;
import org.openqa.selenium.WebDriver;

import java.util.logging.Logger;

public class CartLogger extends InitDriver {

    public static final Logger log = Logger.getLogger(CartLogger.class.getName());
    CartPage cartPage = new CartPage(driver);

    public CartLogger(WebDriver driver) {
        super(driver);
    }

    public boolean isProductImageDisplayed() {
        boolean result = cartPage.isProductImageDisplayed();
        log.info("Product image displayed " + result);
        return result;
    }

    public String getMsgText() {
        log.info("Get msg text");
        return cartPage.getMsgText();
    }

    public String getColor() {
        log.info("Get icon color");
        return cartPage.getColor();
    }

    public void clickOnDeleteButton() {
        log.info("Click on 'Delete' button");
        cartPage.clickOnDeleteButton();
    }

    public void clickOnGoToCartButton() {
        log.info("Click on 'Go to cart' button");
        cartPage.clickOnGoToCartButton();
    }
}

package org.example.loggers;

import org.example.pages.InitDriver;
import org.example.pages.ProductPage;
import org.openqa.selenium.WebDriver;

import java.util.logging.Logger;

public class ProductLogger extends InitDriver {

    public static final java.util.logging.Logger log = Logger.getLogger(ProductLogger.class.getName());
    ProductPage productPage = new ProductPage(driver);

    public ProductLogger(WebDriver driver) {
        super(driver);
    }

    public int getQuantityOfItemsInTheCart() {
        return productPage.getQuantityOfItemsInTheCart();
    }

    public boolean isAddToCartButtonDisplayed() {
        boolean result = productPage.isAddToCartButtonDisplayed();
        log.info("'Add to Cart' button displayed " + result);
        return result;
    }

    public void clickAddCartButton() {
        log.info("Click on 'Add to Cart' button");
        productPage.clickAddCartButton();
    }
}

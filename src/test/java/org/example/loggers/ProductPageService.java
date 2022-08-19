package org.example.loggers;

import org.example.pages.ProductPage;

import java.util.logging.Logger;

public class ProductPageService extends BasePageService {

    public static final java.util.logging.Logger log = Logger.getLogger(ProductPageService.class.getName());
    ProductPage productPage = new ProductPage();

    public int getQuantityOfItemsInTheCart() {
        return productPage.getQuantityOfItemsInTheCart();
    }

    public boolean isAddToCartButtonDisplayed() {
        boolean result = productPage.isAddToCartButtonDisplayed();
        log.info("'Add to Cart' button displayed " + result);
        return result;
    }

    public CartPageService clickAddCartButton() {
        log.info("Click on 'Add to Cart' button");
        productPage.clickAddCartButton();
        return new CartPageService();
    }
}

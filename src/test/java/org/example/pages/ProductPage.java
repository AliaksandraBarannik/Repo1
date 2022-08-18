package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends InitDriver {

    @FindBy(xpath = "//header//a[contains(@href,'nav_cart')]//span")
    private WebElement itemsInTheCart;

    @FindBy(xpath = "//div//input[@name='submit.add-to-cart']")
    private WebElement addToCartButton;

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public int getQuantityOfItemsInTheCart() {
        String str = itemsInTheCart.getText();
        return Integer.parseInt(str.trim());
    }

    public boolean isAddToCartButtonDisplayed() {
        return addToCartButton.isDisplayed();
    }

    public void clickAddCartButton() {
        addToCartButton.click();
    }
}

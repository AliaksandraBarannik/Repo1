package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ProductPage extends BasePage {

    public WebElement getAddToCartButton() {
        return driver.findElement(By.xpath("//input[@name='submit.add-to-cart']"));
    }

    public WebElement getItemsInTheCart() {
        return driver.findElement(By.xpath("//span[@id='nav-cart-count']"));
    }

    public int getQuantityOfItemsInTheCart() {
        String getQuantityOfItemsInTheCartText = getItemsInTheCart().getText();
        return Integer.parseInt(getQuantityOfItemsInTheCartText.trim());
    }

    public boolean isAddToCartButtonDisplayed() {
        return getAddToCartButton().isDisplayed();
    }

    public void clickAddCartButton() {
        waiters.fluentWaitElementToBeClickable(getAddToCartButton()).click();
    }
}

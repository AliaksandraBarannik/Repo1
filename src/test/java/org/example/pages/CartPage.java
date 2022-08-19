package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CartPage extends BasePage {

    public WebElement getConfirmedIconAddedToCart() {
        return driver.findElement(By.xpath("//div//i[@class='a-icon a-icon-alert']"));
    }

    public WebElement getDeleteProductButton() {
        return driver.findElement(By.xpath("//div[@data-encoded-offering]//input[@value='Delete']"));
    }

    public WebElement getGoToCartButton() {
        return driver.findElement(By.xpath("//div//span[@id='sw-gtc']//a[contains(@href,'cart')]"));
    }

    public WebElement getMsgAboutAddedItemToCart() {
        return driver.findElement(By.xpath("//div[@id='sw-atc-details-single-container']//span"));
    }

    public WebElement getProductImage() {
        return driver.findElement(By.xpath("//div[@id='sw-atc-details-single-container']//img"));
    }

    public boolean isProductImageDisplayed() {
        return getProductImage().isDisplayed();
    }

    public String getMsgText() {
        return getMsgAboutAddedItemToCart().getText();
    }

    public String getColor() {
        return getConfirmedIconAddedToCart().getCssValue("color");
    }

    public void clickOnDeleteButton() {
        getDeleteProductButton().click();
    }

    public void clickOnGoToCartButton() {
        getGoToCartButton().click();
    }
}

package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends InitDriver {

    @FindBy(xpath = "//div[@id='sw-atc-details-single-container']//img")
    private WebElement productImage;

    @FindBy(xpath = "//div[@id='sw-atc-details-single-container']//span")
    private WebElement msg;

    @FindBy(xpath = "//div[@id='sw-atc-details-single-container']//div//i[@class='a-icon a-icon-alert']")
    private WebElement icon;

    @FindBy(xpath = "//div[@data-encoded-offering]//input[@value='Delete']")
    private WebElement deleteProductFromCart;

    @FindBy(xpath = "//div//span[@id='sw-gtc']//a[contains(@href,'cart')]")
    private WebElement goToCartButton;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public boolean isProductImageDisplayed() {
        return productImage.isDisplayed();
    }

    public String getMsgText() {
        return msg.getText();
    }

    public String getColor() {
        return icon.getCssValue("color");
    }

    public void clickOnDeleteButton() {
        deleteProductFromCart.click();
    }

    public void clickOnGoToCartButton() {
        goToCartButton.click();
    }
}

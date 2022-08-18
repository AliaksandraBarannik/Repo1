package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ShoppingCartPage extends InitDriver {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

    @FindBy(xpath = "//div[@data-name='Active Cart']//div[@class='a-row']//*[contains(text(),'Shopping Cart')]")
    private WebElement shoppingCart;

    @FindBy(xpath = "//div[@class='a-fixed-left-grid']//img[contains(@src,'images') and @class='sc-product-image']")
    private List<WebElement> listOfElementsInTheShoppingCart;

    public ShoppingCartPage(WebDriver driver) {
        super(driver);
    }

    public boolean isShoppingCartDisplayed() {
        return shoppingCart.isDisplayed();
    }

    public boolean isListOfElementsInTheShoppingCartEmpty() {
        wait.until(ExpectedConditions.visibilityOfAllElements(listOfElementsInTheShoppingCart));
        return listOfElementsInTheShoppingCart.isEmpty();
    }
}

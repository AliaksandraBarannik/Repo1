package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ShoppingCartPage extends BasePage {

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

    public WebElement getShoppingCartText() {
        return driver.findElement(By.xpath("//div[@data-name='Active Cart']//div[@class='a-row']"));
    }

    public List<WebElement> getListOfElementsInTheShoppingCart() {
        return driver.findElements(By.xpath("//div//img[@class='sc-product-image']"));
    }

    public String getShoppingCartNameText() {
        return getShoppingCartText().getText();
    }

    public boolean isListOfElementsInTheShoppingCartEmpty() {
        wait.until(ExpectedConditions.visibilityOfAllElements(getListOfElementsInTheShoppingCart()));
        return getListOfElementsInTheShoppingCart().isEmpty();
    }
}

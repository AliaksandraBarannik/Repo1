package org.example.pages;

import org.example.util.Waiters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ShoppingCartPage extends BasePage {

    Waiters waiters = new Waiters();

    public WebElement getShoppingCartText() {
        return driver.findElement(By.xpath("//div[contains(@class,'sc-compact-bottom')]/div[1]"));
    }

    public List<WebElement> getListOfElementsInTheShoppingCart() {
        return driver.findElements(By.xpath("//img[@class='sc-product-image']"));
    }

    public String getShoppingCartNameText() {
        return getShoppingCartText().getText();
    }

    public boolean isListOfElementsInTheShoppingCartEmpty() {
        waiters.elementsToBeVisible(getListOfElementsInTheShoppingCart());
        return getListOfElementsInTheShoppingCart().isEmpty();
    }
}

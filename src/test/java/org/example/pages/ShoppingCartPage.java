package org.example.pages;

import org.example.util.GetProperties;
import org.example.util.Waiters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ShoppingCartPage extends BasePage {

    Waiters waiters = new Waiters();

    public ShoppingCartPage goToSoppingCartPage() {
        driver.navigate().to(GetProperties.getProperties("config", "shoppingCartUrl"));
        return this;
    }

    public WebElement getShoppingCartText() {
        return driver.findElement(By.xpath("//div[contains(@class,'sc-compact-bottom')]/div[1]"));
    }

    public List<WebElement> getListOfElementsInTheShoppingCart() {
        return driver.findElements(By.xpath("//img[@class='sc-product-image']"));
    }

    public WebElement getItemsName() {
        return waiters.fluentWaitVisibilityOfElement(driver.findElement(By.xpath("//div//span[@class='a-truncate-cut']")));
    }

    public WebElement getItemsPrice() {
        return driver.findElement(By.xpath("//span[@id='sc-subtotal-amount-activecart']//span[@class='a-size-medium a-color-base sc-price sc-white-space-nowrap']"));
    }

    public WebElement getDeleteProductButton() {
        return driver.findElement(By.xpath("//input[@value='Delete']"));
    }

    public String getShoppingCartNameText() {
        return getShoppingCartText().getText();
    }

    public boolean isListOfElementsInTheShoppingCartEmpty() {
        waiters.elementsToBeVisible(getListOfElementsInTheShoppingCart());
        return getListOfElementsInTheShoppingCart().isEmpty();
    }

    public String getItemsNameText() {
        return getItemsName().getText();
    }

    public String getItemsPriceText() {
        return getItemsPrice().getText();
    }

    public String getListOfFieldsText(String key) {
        String itemFields = "//span[@class='a-size-small a-text-bold' and contains(text(),'%s')]/following-sibling::span";
        return driver.findElement(By.xpath(String.format(itemFields, key))).getText();
    }

    public void clickOnDeleteButton() {
        getDeleteProductButton().click();
    }
}

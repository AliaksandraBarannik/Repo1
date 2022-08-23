package org.example.pages;

import org.example.util.Config;
import org.example.util.Waiters;
import org.example.util.GetProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class StartedPage extends BasePage {

    Waiters waiters = new Waiters();

    public WebElement getAccountName() {
        return driver.findElement(By.xpath("//span[@id='nav-link-accountList-nav-line-1']"));
    }

    public WebElement getCartButton() {
        return driver.findElement(By.xpath("//a[@id='nav-cart']"));
    }

    public WebElement getSearchField() {
        return driver.findElement(By.xpath("//input[@name='field-keywords']"));
    }

    public WebElement getSignInMenu() {
        return driver.findElement(By.xpath("//a[@data-nav-ref='nav_ya_signin']"));
    }

    public StartedPage navigate() {
        driver.navigate().to(GetProperties.getProperties("config", "logoUrl"));
        return this;
    }

    public void clickOnSignInMenu() {
        waiters.elementToBeClickable(getSignInMenu()).click();
    }

    public String getAccountGreetingText() {
        return getAccountName().getText();
    }

    public StartedPage fillSearchField(String text) {
        getSearchField().clear();
        getSearchField().sendKeys(text);
        return this;
    }

    public void clickOnCartButton() {
        getCartButton().click();
    }
}

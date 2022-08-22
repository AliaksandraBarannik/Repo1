package org.example.pages;

import org.example.util.GetProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class StartedPage extends BasePage {

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

    public WebElement getAccountName() {
        return driver.findElement(By.xpath("//a[@data-nav-ref='nav_youraccount_btn']//span[@id='nav-link-accountList-nav-line-1']"));
    }

    public WebElement getCartButton() {
        return driver.findElement(By.xpath("//div//a[@id='nav-cart']"));
    }

    public WebElement getSearchField() {
        return driver.findElement(By.xpath("//header//input[@name='field-keywords']"));
    }

    public WebElement getSignInMenu() {
        return driver.findElement(By.xpath("//header//div//a[@data-nav-ref='nav_ya_signin']"));
    }

    public StartedPage navigate() {
        driver.navigate().to(GetProperties.getProperties("config", "logoUrl"));
        return this;
    }

    public void clickOnSignInMenu() {
        wait.until(ExpectedConditions.elementToBeClickable(getSignInMenu()));
        getSignInMenu().click();
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

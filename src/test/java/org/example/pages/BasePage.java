package org.example.pages;

import org.example.driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasePage {

    protected WebDriver driver;

    public BasePage() {
        this.driver = Driver.getDriver();
    }

    public WebElement getSubmitButton() {
        return driver.findElement(By.xpath("//input[@type='submit']"));
    }

    public void clickOnSubmitButton() {
        getSubmitButton().click();
    }

    public String getText(String locator) {
        return driver.findElement(By.xpath(locator)).getText();
    }
}

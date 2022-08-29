package org.example.pages;

import org.example.driver.Driver;
import org.example.util.Waiters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasePage {

    Waiters waiters = new Waiters();
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
}

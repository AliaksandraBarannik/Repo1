package org.example.pages;

import org.example.driver.Driver;
import org.example.util.Waiters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasePage {

    protected WebDriver driver;

    Waiters waiters = new Waiters();

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

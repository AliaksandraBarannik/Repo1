package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends InitDriver {

    @FindBy(xpath = "//div[@class='a-section']//input[@name='email']")
    private WebElement fillEmail;

    @FindBy(xpath = "//input[@type='submit']")
    private WebElement submit;

    @FindBy(xpath = "//div[@class='a-section']//input[@name='password']")
    private WebElement fillPassword;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void addEmail(String email) {
        log.info("Add email");
        fillEmail.sendKeys(email);
    }

    public void clickOnSubmitButton() {
        log.info("click on submit");
        submit.click();
    }

    public void addPassword(String password) {
        log.info("add password");
        fillPassword.sendKeys(password);
    }
}

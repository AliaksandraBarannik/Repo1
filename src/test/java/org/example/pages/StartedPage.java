package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class StartedPage extends InitDriver {

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

    private final String URL = "https://www.amazon.com/ref=nav_logo";

    @FindBy(xpath = "//header//div//a[@data-nav-ref='nav_ya_signin']")
    private WebElement clickOnSignInMenu;

    @FindBy(xpath = "//div[@id='nav-tools']//a[@data-nav-ref='nav_youraccount_btn']//span")
    private WebElement accountName;

    @FindBy(xpath = "//header//input[@name='field-keywords']")
    private WebElement searchField;

    @FindBy(xpath = "//header//input[@type='submit']")
    private WebElement submitButton;

    @FindBy(xpath = "//div//a[@id='nav-cart']")
    private WebElement cartButton;

    public StartedPage(WebDriver driver) {
        super(driver);
    }

    public StartedPage navigate() {
        driver.navigate().to(URL);
        return this;
    }

    public void clickOnSignInMenu() {
        wait.until(ExpectedConditions.elementToBeClickable(clickOnSignInMenu));
        clickOnSignInMenu.click();
    }

    public String getAccountGreetingText() {
        return accountName.getText();
    }

    public StartedPage fillSearchField(String text) {
        searchField.sendKeys(text);
        return this;
    }

    public void clickOnSubmitButton() {
        submitButton.click();
    }

    public void clickOnCartButton() {
        cartButton.click();
    }
}

package org.example.tests;

import org.example.driver.Driver;
import org.example.loggers.LoginLogger;
import org.example.loggers.ProductLogger;
import org.example.loggers.ResultLogger;
import org.example.loggers.StartedLogger;
import org.example.model.User;
import org.example.service.UserService;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;

public class CheckProductQuantityInTheCartTest extends Driver {

    private ProductLogger productLogger;
    private StartedLogger startedLogger;
    private ResultLogger resultLogger;

    @BeforeClass(alwaysRun = true)
    public void registration() {
        startedLogger = new StartedLogger(driver);
        LoginLogger loginLogger = new LoginLogger(driver);
        resultLogger = new ResultLogger(driver);
        productLogger = new ProductLogger(driver);

        User user = UserService.credentials();
        startedLogger.clickOnSignInMenu();
        loginLogger.logIn(user);
    }

    @BeforeMethod
    public void searchElement() {
        startedLogger.navigate();
        startedLogger.fillSearchField("iPhone")
                .clickOnSubmitButton();
        resultLogger.clickOnFirstElementInListOfItems();
    }

    @Test(description = "1.3")
    public void cartIsEmpty() {
        int quantity = productLogger.getQuantityOfItemsInTheCart();
        assertThat("Cart is not empty by default", quantity, Matchers.equalTo(0));
    }

    @Test(description = "1.3")
    public void isCartButtonDisplayed() {
        assertThat("'Add to cart button is not displayed'", productLogger.isAddToCartButtonDisplayed());
    }
}

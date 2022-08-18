package org.example.tests;

import org.example.driver.Driver;
import org.example.loggers.CartLogger;
import org.example.loggers.LoginLogger;
import org.example.loggers.ProductLogger;
import org.example.loggers.ResultLogger;
import org.example.loggers.ShoppingCartLogger;
import org.example.loggers.StartedLogger;
import org.example.model.User;
import org.example.service.UserService;
import org.hamcrest.Matchers;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;

public class AddItemToCartTest extends Driver {

    private ProductLogger productLogger;
    private StartedLogger startedLogger;
    private ResultLogger resultLogger;
    private CartLogger cartLogger;
    private ShoppingCartLogger shoppingCartLogger;

    @BeforeClass(alwaysRun = true)
    public void registration() {
        startedLogger = new StartedLogger(driver);
        LoginLogger loginLogger = new LoginLogger(driver);
        resultLogger = new ResultLogger(driver);
        productLogger = new ProductLogger(driver);
        cartLogger = new CartLogger(driver);
        shoppingCartLogger = new ShoppingCartLogger(driver);

        User user = UserService.credentials();
        startedLogger.clickOnSignInMenu();
        loginLogger.logIn(user);
    }

    @BeforeMethod(alwaysRun = true)
    public void searchElement() {
        startedLogger.navigate();
        startedLogger.fillSearchField("iPhone")
                .clickOnSubmitButton();
        resultLogger.clickOnFirstElementInListOfItems();
        productLogger.clickAddCartButton();
    }

    @Test(description = "1.3")
    public void isProductImageDisplayed() {
        assertThat("The image of added item is displayed", cartLogger.isProductImageDisplayed());
    }

    @Test(description = "1.3")
    public void isTextDisplayed() {
        assertThat("Check added msg", cartLogger.getMsgText(), Matchers.equalTo("Added to Cart"));
    }

    @Test(description = "1.3")
    public void isIconColorGreen() {
        assertThat("Color is not green", cartLogger.getColor(), Matchers.equalTo("rgba(6, 125, 98, 1)"));
    }

    @Test(description = "1.3")
    public void isQuantityChangeInTheCart() {
        int quantity = productLogger.getQuantityOfItemsInTheCart();
        assertThat("Cart is empty or has more than 1 item", quantity, Matchers.equalTo(1));
    }

    @Test(description = "1.4")
    public void isShoppingCartOpened() {
        cartLogger.clickOnGoToCartButton();
        assertThat("Shopping car isn`t displayed", shoppingCartLogger.isShoppingCartDisplayed());
    }

    @Test(description = "1.4")
    public void isAddedItemsDisplayedInTheShoppingCart() {
        cartLogger.clickOnGoToCartButton();
        assertThat("Added items aren`t displayed in the shopping cart", !shoppingCartLogger.isListOfElementsInTheShoppingCartEmpty());
    }

    @AfterMethod(alwaysRun = true)
    public void deleteElementFromCart() {
        startedLogger.clickOnCartButton();
        cartLogger.clickOnDeleteButton();
    }
}

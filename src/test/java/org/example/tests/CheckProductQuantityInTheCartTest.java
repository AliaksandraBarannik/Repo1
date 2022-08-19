package org.example.tests;

import org.example.driver.BaseTest;
import org.example.service.LoginPageService;
import org.example.service.ProductPageService;
import org.example.service.ResultPageService;
import org.example.service.StartedPageService;
import org.example.object.User;
import org.example.service.UserService;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;

public class CheckProductQuantityInTheCartTest extends BaseTest {

    private ProductPageService productPageService;
    private StartedPageService startedPageService;
    private ResultPageService resultPageService;
    private LoginPageService loginPageService;

    @BeforeClass(alwaysRun = true)
    public void registration() {
        User user = UserService.credentials();

        startedPageService = new StartedPageService();
        resultPageService = new ResultPageService();
        loginPageService = startedPageService.clickOnSignInMenu();
        startedPageService = loginPageService.logIn(user);
    }

    @BeforeMethod
    public void searchElement() {
        startedPageService.navigate();
        startedPageService.fillSearchField("iPhone")
                .clickOnSubmitButton();
        productPageService = resultPageService.clickOnFirstElementInListOfItems();
    }

    @Test(description = "1.3")
    public void cartIsEmpty() {
        int quantity = productPageService.getQuantityOfItemsInTheCart();
        assertThat("Cart is not empty by default", quantity, Matchers.equalTo(0));
    }

    @Test(description = "1.3")
    public void isCartButtonDisplayed() {
        assertThat("'Add to cart button is not displayed'", productPageService.isAddToCartButtonDisplayed());
    }
}

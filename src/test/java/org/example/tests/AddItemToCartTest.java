package org.example.tests;

import org.example.driver.BaseTest;
import org.example.service.CartPageService;
import org.example.service.LoginPageService;
import org.example.service.ProductPageService;
import org.example.service.ResultPageService;
import org.example.service.ShoppingCartPageService;
import org.example.service.StartedPageService;
import org.example.object.User;
import org.example.service.UserService;
import org.hamcrest.Matchers;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;

public class AddItemToCartTest extends BaseTest {

    private ProductPageService productPageService;
    private StartedPageService startedPageService;
    private ResultPageService resultPageService;
    private CartPageService cartPageService;
    private ShoppingCartPageService shoppingCartPageService;
    private LoginPageService loginPageService;


    @BeforeClass(alwaysRun = true)
    public void registration() {
        User user = UserService.credentials();

        startedPageService = new StartedPageService();
        resultPageService = new ResultPageService();
        shoppingCartPageService = new ShoppingCartPageService();
        loginPageService = startedPageService.clickOnSignInMenu();
        startedPageService = loginPageService.logIn(user);
    }

    @BeforeMethod(alwaysRun = true)
    public void searchElement() {
        startedPageService.navigate();
        startedPageService.fillSearchField("iPhone")
                .clickOnSubmitButton();
        productPageService = resultPageService.clickOnFirstElementInListOfItems();
        cartPageService = productPageService.clickAddCartButton();
    }

    @Test(description = "1.3")
    public void isProductImageDisplayed() {
        assertThat("The image of added item is displayed", cartPageService.isProductImageDisplayed());
    }

    @Test(description = "1.3")
    public void isTextDisplayed() {
        assertThat("Check added msg", cartPageService.getMsgText(), Matchers.equalTo("Added to Cart"));
    }

    @Test(description = "1.3")
    public void isIconColorGreen() {
        assertThat("Color is not green", cartPageService.getColor(), Matchers.equalTo("rgba(6, 125, 98, 1)"));
    }

    @Test(description = "1.3")
    public void isQuantityChangeInTheCart() {
        int quantity = productPageService.getQuantityOfItemsInTheCart();
        assertThat("Cart is empty or has more than 1 item", quantity, Matchers.equalTo(1));
    }

    @Test(description = "1.4")
    public void isShoppingCartOpened() {
        cartPageService.clickOnGoToCartButton();
        assertThat("Shopping cart isn`t displayed", shoppingCartPageService.isShoppingCartDisplayed("Shopping Cart"));
    }

    @Test(description = "1.4")
    public void isAddedItemsDisplayedInTheShoppingCart() {
        cartPageService.clickOnGoToCartButton();
        assertThat("Added items aren`t displayed in the shopping cart", !shoppingCartPageService.isListOfElementsInTheShoppingCartEmpty());
    }

    @AfterMethod(alwaysRun = true)
    public void deleteElementFromCart() {
        startedPageService.clickOnCartButton();
        cartPageService.clickOnDeleteButton();
    }
}

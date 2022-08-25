package org.example.tests;

import org.example.driver.BaseTest;
import org.example.object.User;
import org.example.service.CartPageService;
import org.example.service.LoginPageService;
import org.example.service.ProductPageService;
import org.example.service.ProductService;
import org.example.service.ResultPageService;
import org.example.service.ShoppingCartPageService;
import org.example.service.StartedPageService;
import org.example.service.UserService;
import org.example.util.GetProperties;
import org.hamcrest.Matchers;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;

public class CompareObjectsInTheCartTest extends BaseTest {

    private ProductPageService productPageService;
    private StartedPageService startedPageService;
    private ResultPageService resultPageService;
    private CartPageService cartPageService;
    private ShoppingCartPageService shoppingCartPageService = new ShoppingCartPageService();
    private LoginPageService loginPageService;
    private ProductService productService = new ProductService();

    @BeforeClass(alwaysRun = true)
    public void registration() {
        User user = UserService.credentials();

        startedPageService = new StartedPageService();
        resultPageService = new ResultPageService();
        loginPageService = startedPageService.clickOnSignInMenu();
        startedPageService = loginPageService.logIn(user);
    }

    @BeforeMethod(alwaysRun = true)
    public void searchElementAndGoToTheCart() {
        startedPageService.goToMainPage();
    }

    @Test(description = "Task3")
    public void checkPhoneDescription() {
        resultPageService = startedPageService.fillSearchField(GetProperties.getProperties("product", "phone_name"));
        resultPageService.clickOnSubmitButton();
        productPageService = resultPageService.clickOnElementInTheList(GetProperties.getProperties("product", "phone_name"));
        cartPageService = productPageService.clickAddCartButton();
        shoppingCartPageService.goToSoppingCartPage();

        assertThat("These objects are not equal", productService.getActualPhoneObject(),
                Matchers.equalTo(productService.getPhoneObjectFromProperties()));
    }

    @Test(description = "Task3")
    public void checkGamingMouseDescription() {
        resultPageService = startedPageService.fillSearchField(GetProperties.getProperties("product", "gaming_mouse_name"));
        resultPageService.clickOnSubmitButton();
        productPageService = resultPageService.clickOnElementInTheList(GetProperties.getProperties("product", "gaming_mouse_name"));
        cartPageService = productPageService.clickAddCartButton();
        shoppingCartPageService.goToSoppingCartPage();

        assertThat("These objects are not equal", productService.getActualMouseObject(),
                Matchers.equalTo(productService.getMouseObjectFromProperties()));
    }

    @Test(description = "Task3")
    public void checkHeadsetDescription() {
        resultPageService = startedPageService.fillSearchField(GetProperties.getProperties("product", "headset_name"));
        resultPageService.clickOnSubmitButton();
        productPageService = resultPageService.clickOnElementInTheList(GetProperties.getProperties("product", "headset_name"));
        cartPageService = productPageService.clickAddCartButton();
        shoppingCartPageService.goToSoppingCartPage();

        assertThat("These objects are not equal", productService.getHeadsetActualObject(),
                Matchers.equalTo(productService.getHeadsetObjectFromProperties()));
    }

    @AfterMethod(alwaysRun = true)
    public void deleteElementFromCart() {
        shoppingCartPageService.clickOnDeleteButton();
    }
}

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
import org.example.util.ReadDataFromFile;
import org.hamcrest.Matchers;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;

public class CompareObjectsInTheCartTest extends BaseTest {

    private ProductPageService productPageService;
    private StartedPageService startedPageService;
    private ResultPageService resultPageService;
    private CartPageService cartPageService;
    private ShoppingCartPageService shoppingCartPageService = new ShoppingCartPageService();
    private LoginPageService loginPageService;
    private ProductService productService = new ProductService();
    private List<String> list;

    @BeforeClass(alwaysRun = true)
    public void registration() {
        User user = UserService.credentials();

        startedPageService = new StartedPageService();
        loginPageService = startedPageService.clickOnSignInMenu();
        startedPageService = loginPageService.logIn(user);
    }

    @BeforeMethod(alwaysRun = true)
    public void searchElementAndGoToTheCart() {
        startedPageService.goToMainPage();
    }

    @Test(description = "Task3")
    public void checkPhoneDescription() {
        list = ReadDataFromFile.getDataFromProperties("3");
        resultPageService = startedPageService.fillSearchField(list.get(0));
        resultPageService.clickOnSubmitButton();
        productPageService = resultPageService.clickOnElementInTheList(list.get(0));
        cartPageService = productPageService.clickAddCartButton();
        shoppingCartPageService = cartPageService.clickOnGoToCartButton();

        assertThat("These objects are not equal", productService.getActualPhoneObject(),
                Matchers.equalTo(productService.getPhoneProduct(list)));
    }

    @Test(description = "Task3")
    public void checkGamingMouseDescription() {
        list = ReadDataFromFile.getDataFromProperties("3.1");
        resultPageService = startedPageService.fillSearchField(list.get(0));
        resultPageService.clickOnSubmitButton();
        productPageService = resultPageService.clickOnElementInTheList(list.get(0));
        cartPageService = productPageService.clickAddCartButton();
        shoppingCartPageService = cartPageService.clickOnGoToCartButton();

        assertThat("These objects are not equal", productService.getActualGamingMouseObject(),
                Matchers.equalTo(productService.getGamingMouseProduct(list)));
    }

    @Test(description = "Task3")
    public void checkHeadsetDescription() {
        list = ReadDataFromFile.getDataFromProperties("3.2");
        resultPageService = startedPageService.fillSearchField(list.get(0));
        resultPageService.clickOnSubmitButton();
        productPageService = resultPageService.clickOnElementInTheList(list.get(0));
        cartPageService = productPageService.clickAddCartButton();
        shoppingCartPageService = cartPageService.clickOnGoToCartButton();

        assertThat("These objects are not equal", productService.getActualHeadsetObject(),
                Matchers.equalTo(productService.getHeadsetProduct(list)));
    }

    @AfterMethod(alwaysRun = true)
    public void deleteElementFromCart() {
        shoppingCartPageService.goToSoppingCartPage();
        shoppingCartPageService.clickOnDeleteButton();
    }
}

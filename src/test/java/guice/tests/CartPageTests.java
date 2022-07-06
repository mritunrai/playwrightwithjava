package guice.tests;

import com.playwright.web.testbases.WebTest;
import guice.pages.LoginPage;
import guice.pages.ProductPage;
import org.testng.annotations.Test;

import java.util.List;

public class CartPageTests extends WebTest {

    @Test
    public void addItemIntoCart() {
        List<String> items = webPageInstance(LoginPage.class)
                .login("standard_user", "secret_sauce", ProductPage.class)
                .validateOnProductsPage()
                .getProduct("Sauce Labs Backpack");

        webPageInstance(ProductPage.class)
                .addItemIntoCart(items);
    }
}
package guice.tests;

import com.playwright.web.testbases.WebTest;
import guice.pages.LoginPage;
import guice.pages.ProductPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SwagLabsLoginTests extends WebTest {

    @Test
    public void loginWithValidCredential() {
        webPageInstance(LoginPage.class)
                .login("standard_user", "secret_sauce", ProductPage.class)
                .validateOnProductsPage();
    }

    @Test
    public void loginWithInvalidCredential() {
        var errorMessage = webPageInstance(LoginPage.class)
                .login("secret_sauce", "secret_sauce", LoginPage.class)
                .getErrorMessage();

        Assert.assertEquals(
                errorMessage, "Epic sadface: Username and password do not match any user in this service");
    }
}
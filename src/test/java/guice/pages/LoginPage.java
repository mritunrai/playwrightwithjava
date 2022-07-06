package guice.pages;

import com.microsoft.playwright.Page;
import com.playwright.web.testbases.WebPage;

public class LoginPage extends WebPage {
    private final String userNameSelector = "#user-name";
    private final String passwordSelector = "#password";
    private final String loginButtonSelector = "#login-button";

    public LoginPage(Page page) {
        super(page);
    }

    public <T extends WebPage> T login(String userName, String password, Class<T> nextPage) {
        page.fill(userNameSelector, userName);
        page.fill(passwordSelector, password);
        page.click(loginButtonSelector);

        return createWebPageInstance(nextPage);
    }

    public String getErrorMessage() {
        return page.textContent("[data-test='error']");
    }
}

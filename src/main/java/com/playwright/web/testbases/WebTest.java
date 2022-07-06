package com.playwright.web.testbases;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.playwright.web.module.PlaywrightModule;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class WebTest {

    private final ThreadLocal<Injector> injector = new ThreadLocal<>();

    @BeforeMethod(alwaysRun = true)
    public void launchApplication() {
        injector.set(Guice.createInjector(new PlaywrightModule()));
        injector.get().getInstance(Page.class).navigate("https://www.saucedemo.com/");
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(ITestResult result) {
        injector.get().getInstance(BrowserContext.class).close();
        injector.get().getInstance(Playwright.class).close();
    }

    protected <T extends WebPage> T webPageInstance(Class<T> tClass) {
        try {
            var page = injector.get().getInstance(Page.class);
            return tClass.getDeclaredConstructor(Page.class).newInstance(page);
        } catch (Exception ex) {
            throw new RuntimeException("Unable to create WebPage instance");
        }
    }
}
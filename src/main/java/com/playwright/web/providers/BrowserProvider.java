package com.playwright.web.providers;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Playwright;

public class BrowserProvider implements Provider<Browser> {
    private final String browser;

    @Inject
    private Playwright playwright;

    public BrowserProvider() {
        browser = System.getProperty("browser", "chrome").toLowerCase();
    }

    @Override
    public Browser get() {

        switch (browser) {
            case "firefox":
                return playwright.firefox().launch(buildLaunchOptions());
            case "webkit":
                return playwright.webkit().launch(buildLaunchOptions());
            case "chrome":
            default:
                return playwright.chromium().launch(buildLaunchOptions());
        }
    }


    private BrowserType.LaunchOptions buildLaunchOptions() {
        return new BrowserType.LaunchOptions()
                .setHeadless(Boolean.parseBoolean(System.getProperty("headless", "false")));
    }

}

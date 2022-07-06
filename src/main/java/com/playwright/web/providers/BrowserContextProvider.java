package com.playwright.web.providers;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.options.ViewportSize;

public class BrowserContextProvider implements Provider<BrowserContext> {
    @Inject
    private Browser browser;

    @Override
    public BrowserContext get() {
        var headlessExecution = Boolean.parseBoolean(System.getProperty("headless", "false"));

        var options =
                new Browser.NewContextOptions()
                        .setViewportSize(headlessExecution ? new ViewportSize(1920, 1080) : null);

        return browser.newContext(options);
    }
}

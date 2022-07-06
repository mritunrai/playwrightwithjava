package com.playwright.web.providers;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;

public class PlaywrightPageProvider implements Provider<Page> {

    @Inject
    private BrowserContext context;

    @Override
    public Page get() {
        return context.newPage();
    }
}

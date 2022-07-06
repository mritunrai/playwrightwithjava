package com.playwright.web.providers;

import com.google.inject.Provider;
import com.microsoft.playwright.Playwright;

public class PlaywrightProvider implements Provider<Playwright> {
    @Override
    public Playwright get() {
        return Playwright.create();
    }
}

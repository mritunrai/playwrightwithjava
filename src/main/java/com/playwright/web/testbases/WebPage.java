package com.playwright.web.testbases;

import com.google.inject.Inject;
import com.microsoft.playwright.Page;

public class WebPage {
    protected Page page;

    @Inject
    public WebPage(Page page) {
        this.page = page;
    }

    protected <T extends WebPage> T createWebPageInstance(Class<T> tClass) {
        try {
            return tClass.getDeclaredConstructor(Page.class).newInstance(page);
        } catch (Exception ex) {
            throw new RuntimeException("Error creating Webpage Instance.");
        }
    }
}

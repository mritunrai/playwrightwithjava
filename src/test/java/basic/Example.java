package basic;

import com.microsoft.playwright.*;
import org.testng.annotations.Test;

import java.nio.file.Paths;

public class Example {

    public static void main(String[] args) {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
            Page page = browser.newPage();
            page.navigate("http://playwright.dev");
            System.out.println(page.title());
            page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("example.png")));

        }
    }

    @Test
    public void browserContext() {

        /*
        Playwright provides method to launch browser instance.
         */
        try (Playwright playwright = Playwright.create()) {

            /*
            Create instance of Browser and Browser Type where launch method
            will launch the browser.
             */
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

            /*
             A BrowserContext is an isolated incognito-alike session within a browser instance.
            //Browser contexts can also be used to emulate multi-page scenarios involving mobile devices, permissions, locale and color scheme.
            //browser state is isolated between the tests.
             */
            BrowserContext context = browser.newContext();

            /*
            //Page provides methods to interact with a single tab in a browser.
             One browser instance can have multiple Page instances.
             */
            Page page = context.newPage();
            page.navigate("http://playwright.dev");
            System.out.println(page.title());
            page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("example.png")));

        }

    }
}

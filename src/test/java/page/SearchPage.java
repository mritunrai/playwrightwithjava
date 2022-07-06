package page;

import com.microsoft.playwright.Page;

import java.util.List;
import java.util.stream.Collectors;

import static com.microsoft.playwright.options.WaitForSelectorState.ATTACHED;
import static com.microsoft.playwright.options.WaitForSelectorState.DETACHED;

public class SearchPage extends BasePage {
    private String locator_searchBar = "#searchBar";
    private String locator_hiddenBooks = "li.ui-screen-hidden";
    private String locator_visibleBooks = "li:not(.ui-screen-hidden)";
    private String locator_visibleBookTitles = "li:not(.ui-screen-hidden) h2";

    public SearchPage(Page page) {
        super(page);
    }

    public void search(String query) {
        clearSearchBar();
        page.fill(locator_searchBar, query);
  page.pause();
        var expectedState = new Page.WaitForSelectorOptions().setState(ATTACHED);
        page.waitForSelector(locator_hiddenBooks, expectedState);
    }

    public void clearSearchBar() {
        page.fill(locator_searchBar, "java");

        var expectedState = new Page.WaitForSelectorOptions().setState(DETACHED);
        page.waitForSelector(locator_hiddenBooks, expectedState);
    }

    /*
    Playwright provides the querySelector() method which returns a single element as an
     ElementHandle object. This is equivalent to Selenium’s WebElement object obtained by
     findElement(). To get multiple elements that match the locator,
     Playwright provides querySelectorAll() and this will return a list of elements: List<ElementHandle>.
     */

    public int getNumberOfVisibleBooks() {
        return page.querySelectorAll(locator_visibleBooks).size();
    }

    public List<String> getVisibleBooks() {
        return page.querySelectorAll(locator_visibleBookTitles)
                .stream()
                .map(e -> e.innerText())
                .collect(Collectors.toList());
    }
}

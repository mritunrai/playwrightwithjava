import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class SearchTests extends BaseTests {

    @Test(groups = "search")
    public void searchForExactTitle() {
        String title = "Agile Testing";
        searchPage.search(title);

        assertEquals(searchPage.getNumberOfVisibleBooks(), 1, "Number of visible books");
        assertTrue(searchPage.getVisibleBooks().contains(title), "Title of visible book");
    }

    @Test(groups = "search")
    public void searchForPartialTitle() {
        searchPage.search("Test");

        List<String> expectedBooks = List.of(
                "Test Automation in the Real World",
                "Experiences of Test Automation",
                "Agile Testing",
                "How Google Tests Software",
                "Java For Testers"
        );

        assertEquals(searchPage.getNumberOfVisibleBooks(), expectedBooks.size(), "Number of visible books");
        assertEquals(searchPage.getVisibleBooks(), expectedBooks, "Titles of visible books");
    }
}

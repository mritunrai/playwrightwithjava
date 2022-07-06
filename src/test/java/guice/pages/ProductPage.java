package guice.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.playwright.web.testbases.WebPage;
import org.testng.Assert;

import java.util.List;

public class ProductPage extends WebPage {
    public ProductPage(Page page) {
        super(page);
    }

    public ProductPage validateOnProductsPage() {
        Assert.assertTrue(page.locator("[class='title']:has-text('Products')").count() == 1);
        return this;
    }
    public List<String> getProduct(String productName)
    {
       Locator lo = page.locator("[class='inventory_list'] [class='inventory_item_name']");



        return page.locator("[class='inventory_list'] [class='inventory_item_name']").allTextContents();
    }

    public void addItemIntoCart(List<String> item)
    {

    }
}
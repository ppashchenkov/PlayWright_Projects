package luma;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import luma.runner.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class NavigationTest extends BaseTest {

    String baseURL = "https://magento.softwaretestingboard.com/";

    public void baseUrlTest() {

        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch();
        Page page = browser.newPage();
        page.navigate(baseURL);
        assertThat(page).hasURL(baseURL);
    }
}

package luma;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.AriaRole;
import luma.runner.BaseTest;
import org.testng.annotations.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class NavigationTest extends BaseTest {
//    final String baseURL = "https://magento.softwaretestingboard.com/";
    final String baseURL = "https://naveenautomationlabs.com/opencart/";
    Playwright playwright = Playwright.create();
    Browser browser = playwright.chromium().launch(new BrowserType
            .LaunchOptions().setHeadless(true).setSlowMo(100));
    Page page = browser.newPage();

    @Test
    public void testBaseUrlLanding() {
        page.navigate(baseURL);
        assertThat(page).hasURL(baseURL);
    }

    @Test
    public void testTabletsMenu () {
        page.navigate(baseURL);
        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions()
                .setName("Tablets").setExact(true)).click();

        assertThat(page)
                .hasURL("https://naveenautomationlabs.com/opencart/index.php?route=product/category&path=57");
    }
}

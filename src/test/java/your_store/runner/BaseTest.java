package your_store.runner;

import com.microsoft.playwright.*;
import org.testng.annotations.*;

import static your_store.utils.TestData.BASE_URL;
import static your_store.utils.TestData.HOME_END_POINT;

public abstract class BaseTest {

    private final Playwright playwright = Playwright.create();
    private final Browser browser = playwright.chromium().launch(new BrowserType
            .LaunchOptions().setHeadless(true).setSlowMo(100));
    private BrowserContext context;
    private Page page;

    @BeforeSuite
    protected void checkIfPlaywrightCreatedAndBrowserLaunched() {
        if (playwright != null) {
            System.out.println("Playwright created");
        } else {
            System.out.println("FATAL. Playwright is NOT created.");
            System.exit(1);
        }

        if (browser.isConnected()) {
            System.out.println("Browser " + browser.browserType().name() + " is connected.");
        } else {
            System.out.println("FATAL. Browser is NOT connected.");
            System.exit(1);
        }
    }

    @BeforeMethod
    protected void createContextAndPage() {
        context = browser.newContext();
        System.out.println("Context created.");

        page = context.newPage();
        System.out.println("Page created.");

        System.out.println("Start test");
        getPage().navigate(BASE_URL);
        if (isOnHomePage()) {
            System.out.println("Base url opened");
        } else {
            System.out.println("ERROR: Base url was NOT opened.");
        }
    }

    @AfterMethod
    protected void closeContext() {
        if (page != null) {
            page.close();
            System.out.println("Page closed.");
        }
        if (context != null) {
            context.close();
            System.out.println("Context closed.");
        }
    }

    @AfterSuite
    protected void closeBrowserAndPlaywright() {
        if (browser != null){
            browser.close();
            System.out.println("Browser " + browser.browserType().name() + " is closed.");
        }
        if (playwright != null) {
            playwright.close();
            System.out.println("Playwright closed.");
        }
    }

    private boolean isOnHomePage() {
        getPage().waitForLoadState();
        return getPage().url().equals(BASE_URL + HOME_END_POINT)
                && !page.content().isEmpty();
    }

    protected Page getPage() {
        return page;
    }

    protected boolean getIsOnHomePage() {
        return isOnHomePage();
    }
}

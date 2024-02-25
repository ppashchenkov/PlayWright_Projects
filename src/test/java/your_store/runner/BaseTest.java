package your_store.runner;

import com.microsoft.playwright.*;
import org.testng.Reporter;
import org.testng.annotations.*;
import your_store.utils.BrowserManager;
import your_store.utils.LoggerUtils;

import static your_store.utils.TestData.BASE_URL;
import static your_store.utils.TestData.HOME_END_POINT;

public abstract class BaseTest {

    private final Playwright playwright = Playwright.create();
    private final Browser browser = BrowserManager.createBrowser(playwright, "chromium", true, 1500);
    private BrowserContext context;
    private Page page;

    @BeforeSuite
    protected void checkIfPlaywrightCreatedAndBrowserLaunched() {
        if (playwright != null) {
            LoggerUtils.logInfo("Playwright created");
//            Reporter.log("-------Playwright created", true);
            LoggerUtils.logInfo("Playwright created");
        } else {
//            System.out.println("FATAL. Playwright is NOT created.");
            LoggerUtils.logFatal("FATAL. Playwright is NOT created.");
            System.exit(1);
        }

        if (browser.isConnected()) {
            LoggerUtils.logInfo("Browser " + browser.browserType().name() + " is connected.");
        } else {
            LoggerUtils.logFatal("FATAL. Browser is NOT connected.");
            System.exit(1);
        }
    }

    @BeforeMethod
    protected void createContextAndPage() {
        context = browser.newContext();
        LoggerUtils.logInfo("Context created.");

        page = context.newPage();
        LoggerUtils.logInfo("Page created.");

        LoggerUtils.logSuccess("Start test");
        getPage().navigate(BASE_URL);
        if (isOnHomePage()) {
            LoggerUtils.logInfo("Base url opened");
        } else {
            LoggerUtils.logError("ERROR: Base url was NOT opened.");
        }
    }

    @AfterMethod
    protected void closeContext() {
        if (page != null) {
            page.close();
            LoggerUtils.logInfo("Page closed.");
        }
        if (context != null) {
            context.close();
            LoggerUtils.logInfo("Context closed.");
        }
    }

    @AfterSuite
    protected void closeBrowserAndPlaywright() {
        if (browser != null){
            browser.close();
            LoggerUtils.logSuccess("Browser " + browser.browserType().name() + " is closed.");
        }
        if (playwright != null) {
            playwright.close();
            LoggerUtils.logInfo("Playwright closed.");
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

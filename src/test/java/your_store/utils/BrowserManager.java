package your_store.utils;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Playwright;

public final class BrowserManager {

    public static Browser createBrowser(Playwright playwright, String browserName, boolean isHeadLess, int slowMo) {
        switch (browserName) {
            case "chromium" -> {
                return playwright.chromium()
                        .launch(new BrowserType.LaunchOptions()
                                .setHeadless(isHeadLess)
                                .setSlowMo(slowMo));
            }
            case "firefox" -> {
                return playwright.firefox()
                        .launch(new BrowserType.LaunchOptions()
                                .setHeadless(isHeadLess)
                                .setSlowMo(slowMo));
            }
            case "webkit" -> {
                return playwright.webkit()
                        .launch(new BrowserType.LaunchOptions()
                                .setHeadless(isHeadLess)
                                .setSlowMo(slowMo));
            }
            default -> {
                LoggerUtils.logError("Error: " + browserName + " is NOT match any options. Cromium() launched.");
                return playwright.chromium()
                        .launch(new BrowserType.LaunchOptions()
                                .setHeadless(true)
                                .setSlowMo(0));
            }
        }
    }
}

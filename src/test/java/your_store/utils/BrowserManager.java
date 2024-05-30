package your_store.utils;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Playwright;

import java.util.Map;

public final class BrowserManager {

    public static Browser createBrowser(Playwright playwright, Map<String,String> enviroment) {
        String browserName = enviroment.get("browser");
        boolean isHeadLess = Boolean.parseBoolean(enviroment.get("isHeadLess"));
        int slowMo = Integer.parseInt(enviroment.get("slowMo"));

        switch (browserName) {
            case "chromium" -> {
                LoggerUtils.logInfo("INFO: " + browserName + " launched.");
                return playwright.chromium()
                        .launch(new BrowserType.LaunchOptions()
                                .setHeadless(isHeadLess)
                                .setSlowMo(slowMo));
            }
            case "firefox" -> {
                LoggerUtils.logInfo("INFO: " + browserName + " launched.");
                return playwright.firefox()
                        .launch(new BrowserType.LaunchOptions()
                                .setHeadless(isHeadLess)
                                .setSlowMo(slowMo));
            }
            case "webkit" -> {
                LoggerUtils.logInfo("INFO: " + browserName + " launched.");
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

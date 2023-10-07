import com.microsoft.playwright.*;
import java.nio.file.Paths;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
public class App {
    public static void main(String[] args) {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch();
            Page page = browser.newPage();
            page.navigate("http://playwright.dev");
            System.out.println(page.title());
        }
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.webkit().launch();
            Page page = browser.newPage();
            page.navigate("https://playwright.dev/");
            page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("example.png")));
        }
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.firefox().launch(
                    new BrowserType.LaunchOptions().setHeadless(true)
            );
            Page page = browser.newPage();
            page.navigate("https://openweathermap.org");
//            String title = page.title();
//            System.out.println(title);
//            assertThat(page).hasTitle("Сurrent weather and forecast - OpenWeatherMap");
            Locator currTemp = page.locator("css=.current-temp .heading");
            String currentTemp = currTemp.innerText();

            System.out.println(currentTemp);

            assertThat(currTemp).isVisible();
            assertThat(currTemp).containsText("C");

        }
    }
}

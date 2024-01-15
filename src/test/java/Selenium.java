import com.google.common.annotations.VisibleForTesting;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Selenium {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        //TC01
//        driver.get("https://openweathermap.org/");
//        String title = driver.getTitle();
//
//        System.out.println(title);
//
//        assert(title.equals("Сurrent weather and forecast - OpenWeatherMap1"));

        //TC02

        driver.get("https://openweathermap.org/");
        WebElement currTemp = driver.findElement(By.cssSelector(".current-temp .heading"));

        System.out.println(currTemp.getText());

        assert(currTemp).isDisplayed();
        assert(currTemp.getText()).contains("C");

        driver.close();

    }
}

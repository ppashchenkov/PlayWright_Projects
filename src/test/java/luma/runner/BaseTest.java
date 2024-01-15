package luma.runner;

import com.microsoft.playwright.*;
import org.testng.annotations.*;

//import static utils.ProjectConstant.BASE_URL;

public abstract class BaseTest {

    private Playwright playwright;
    private Browser browser;
    private BrowserContext context;
    private Page page;


}

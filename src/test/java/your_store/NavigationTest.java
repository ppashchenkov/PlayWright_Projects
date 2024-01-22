package your_store;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import your_store.runner.BaseTest;
import org.testng.annotations.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static your_store.utils.TestData.*;

public class NavigationTest extends BaseTest {

    @Test
    public void testBaseUrlLanding() {
        getPage().navigate(BASE_URL);
        assertThat(getPage()).hasURL(BASE_URL + HOME_END_POINT);
    }

    @Test
    public void testTabletsMenu () {
        getPage().navigate(BASE_URL);
        getPage().getByRole(AriaRole.LINK, new Page.GetByRoleOptions()
                .setName(TABLETS_MENU).setExact(true)).click();

        assertThat(getPage())
                .hasURL(BASE_URL + TABLETS_MENU_END_POINT);
    }
}

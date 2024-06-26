package your_store;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import org.testng.Assert;
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
    public void testTabletsMenu() {

        if (getIsOnHomePage()) {
            getPage().getByRole(AriaRole.LINK, new Page.GetByRoleOptions()
                    .setName(TABLETS_MENU).setExact(true)).click();

            assertThat(getPage())
                    .hasURL(BASE_URL + TABLETS_MENU_END_POINT);
        } else {
            Assert.fail();
        }
    }

    @Test
    public void testSoftwareMenu() {
        if (getIsOnHomePage()) {
            getPage().getByRole(AriaRole.LINK, new Page.GetByRoleOptions()
                    .setName(SOFTWARE_MENU).setExact(true)).click();

            assertThat(getPage())
                    .hasURL(BASE_URL + SOFTWARE_MENU_AND_POINT);
        }
    }

    @Test
    public void testPhonesAndPdaMenu() {
        if (getIsOnHomePage()) {
            getPage().getByRole(AriaRole.LINK, new Page.GetByRoleOptions()
                    .setName(PHONES_AND_PDA_MENU).setExact(true)).click();

            assertThat(getPage())
                    .hasURL(BASE_URL + PHONES_AND_PDA_END_POINT);
        }
    }

    @Test
    public void testCamerasMenu() {
        if (getIsOnHomePage()) {
            getPage().getByRole(AriaRole.LINK, new Page.GetByRoleOptions()
                    .setName(CAMERAS_MENU).setExact(true)).click();

            assertThat(getPage())
                    .hasURL(BASE_URL + CAMERAS_END_POINT);
        }
    }

    @Test
    public void testTrue() {

        Assert.assertTrue(true);
    }
}

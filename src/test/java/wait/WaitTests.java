package wait;

import base.BaseTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class WaitTests extends BaseTest {

    @Test
    public void testWaitUntilHidden() {
        var loadingPage = homePage.clickDynamicLoading()
                .clickExample1();

        loadingPage.clickStart();
        assertEquals(loadingPage.getLoadedText(),
                "Hello World!",
                "Loaded message is wrong!");
    }

    @Test
    public void testWaitUntilPresent() {
        var loadingPage = homePage.clickDynamicLoading()
                .clickExample2();

        loadingPage.clickStart();

        assertEquals(loadingPage.getLoadedText(),
                "Hello World!",
                "Loaded message is wrong!");
    }
}

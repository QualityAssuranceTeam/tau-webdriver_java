package alerts;

import base.BaseTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

// by me
public class ContextMenuTests extends BaseTest {

    @Test
    public void testContextMenu() {
        var contextMenuPage = homePage.clickContextMenu();
        contextMenuPage.rightClick();
        String alertText = contextMenuPage.getAlertText();
        contextMenuPage.acceptAlert();
        assertEquals(alertText,
                "You selected a context menu",
                "Alert message is wrong!");
    }
}

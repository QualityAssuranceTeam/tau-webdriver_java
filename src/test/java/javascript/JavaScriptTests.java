package javascript;

import base.BaseTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class JavaScriptTests extends BaseTest {

    @Test
    public void testScrollToTable() {
        homePage.clickLargeAndDeepDom().scrollToTable();
    }

    @Test
    public void scrollToFifthParagraph() {
        homePage.clickInfiniteScroll().scrollToParagraph(5);
    }

    @Test
    public void testMultipleChoiceDropdown() {
        var dropdownPage = homePage.clickDropdown();

        // Execute JS to change dropdown behavior
        dropdownPage.makeDropdownMultipleChoice();

        dropdownPage.selectFromDropdown("Option 1");
        dropdownPage.selectFromDropdown("Option 2");

        var selectedOptions = dropdownPage.getSelectedOptions();

        assertEquals(selectedOptions.size(),
                2,
                "Incorrect number of selected options!");

        assertTrue(selectedOptions.contains("Option 1"));
        assertTrue(selectedOptions.contains("Option 2"));
    }
}

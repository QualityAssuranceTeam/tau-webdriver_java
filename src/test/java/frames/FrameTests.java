package frames;

import base.BaseTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class FrameTests extends BaseTest {

    @Test
    public void testWysiwyg() {
        var editorPage = homePage.clickWysiwygEditor();

        editorPage.dismissWarning(); // temporary fix to avoid the WYSIWYG warning popup

        editorPage.clearTextArea();

        String text1 = "hello ";
        String text2 = "world";

        editorPage.setTextArea(text1);
        editorPage.decreaseIndention();
        editorPage.setTextArea(text2);

        assertEquals(editorPage.getTextFromEditor(),
                text1 + text2,
                "Text from editor is wrong!");
    }

    @Test
    public void testNestedFrames() {
        var framesPage = homePage.clickFrames();
        var nestedFramesPage = framesPage.clickNestedFrames();
        assertEquals(nestedFramesPage.getLeftFrameText(), "LEFT");
        assertEquals(nestedFramesPage.getMiddleFrameText(), "MIDDLE");
        assertEquals(nestedFramesPage.getRightFrameText(), "RIGHT");
        assertEquals(nestedFramesPage.getBottomFrameText(), "BOTTOM");
    }
}

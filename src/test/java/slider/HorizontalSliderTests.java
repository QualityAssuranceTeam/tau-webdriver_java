package slider;

import base.BaseTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class HorizontalSliderTests extends BaseTest {

    @Test
    public void testMoveRight() {
        String targetValue = "4";
        var horizontalSliderPage = homePage.clickHorizontalSlider();

        //horizontalSliderPage.moveSliderRight(8); // my method
        horizontalSliderPage.setSliderValue(targetValue); // Angie's method

        assertEquals(horizontalSliderPage.getRangeValue(),
                targetValue,
                "Range value is not correct!");
    }
}

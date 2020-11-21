package cookies;

import base.BaseTest;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class CookieTests extends BaseTest {

    @Test
    public void testSetCookie() {
        String cookieName = "tau";
        String cookieValue = "123";
        var cookieManager = getCookieManager();
        cookieManager.setCookie(cookieName, cookieValue);

        assertEquals(cookieManager.getCookie(cookieName).getName(),
                "tau",
                "Cookie name is wrong!");

        assertEquals(cookieManager.getCookie(cookieName).getValue(),
                "123",
                "Cookie value is wrong!");
    }

    @Test
    public void testDeleteCookie() {
        String cookieName = "optimizelyBuckets";
        var cookieManger = getCookieManager();
        cookieManger.deleteCookie(cookieName);

        assertFalse(cookieManger.isCookiePresent(cookieName),
                "Cookie is not deleted!");
    }
}

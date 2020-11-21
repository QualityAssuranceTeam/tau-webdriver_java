package utils;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;

public class CookieManager {

    private WebDriver driver;

    public CookieManager(WebDriver driver) {
        this.driver = driver;
    }

    public void setCookie(String name, String value) {
        String domain = driver.getCurrentUrl()
                .replaceAll("(https://|/)", ""); // remove prefix and suffix

        Cookie cookie = new Cookie.Builder(name, value)
                .domain(domain)
                .build();

        driver.manage().addCookie(cookie);
    }

    public Cookie getCookie(String name) {
        return driver.manage().getCookieNamed(name);
    }

    public void deleteCookie(String name) {
        driver.manage().deleteCookieNamed(name);
    }

    public boolean isCookiePresent(String name) {
        return driver.manage().getCookieNamed(name) != null;
    }
}

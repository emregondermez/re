package day14;

import org.testng.annotations.Test;
import utilities.TestBase;

public class C04_ScreenShot extends TestBase {

    @Test
    public void test01() {
        driver.get("https://www.google.com");
        driver.manage().deleteAllCookies();
    }
}

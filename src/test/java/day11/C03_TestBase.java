package day11;

import org.testng.annotations.Test;
import utilities.TestBase;

public class C03_TestBase extends TestBase {


    @Test
    public void test01() {
        driver.get("https://www.amazon.com");
    }
}

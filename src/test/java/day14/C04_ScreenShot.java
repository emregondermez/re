package day14;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C04_ScreenShot extends TestBase {

    @Test
    public void test01() {
        driver.get("https://www.google.com");

        driver.findElement(By.xpath("//div[text()='Ik ga akkoord']")).click();

    }
}

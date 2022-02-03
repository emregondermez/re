package day15;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C04_JsExecutor extends TestBase {
    // amazon sayfasina gidip
    // sell linkine JsExecuter ile tiklayalim
    // ilgili sayfaya gittigimizi test edelim


    @Test
    public void test01() throws InterruptedException {
        driver.get("https://www.amazon.com");

      WebElement sell = driver.findElement(By.xpath("//a[@data-csa-c-slot-id='nav_cs_4']"));
      JavascriptExecutor jse = (JavascriptExecutor) driver;
      jse.executeScript("arguments[0].click();", sell);

      Thread.sleep(3000);
        WebElement sellOnAmazon = driver.findElement(By.xpath("//h2[text()='Sell on Amazon']"));
        Assert.assertTrue(sellOnAmazon.isEnabled());


    }
}

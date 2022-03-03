package day15;

import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C05_JsExecutorScrollIntoView extends TestBase {

    //2- hotelmycamp anasayfasina gidin
    //3- 2 farkli test method’u olusturarak actions clasi ve
    // Js Executor kullanarak asagidaki oda turlerinden ust sira ortadaki odayi tiklayin
    //4- istediginiz oda inceleme sayfasi acildigini test edin

    @Test
    public void actionClass() {
    driver.get("https://www.hotelmycamp.com/");
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).perform();
        WebElement expectedElement = driver.findElement(By.xpath("(//a[@class='btn-custom'])[2]"));
        Assert.assertTrue(expectedElement.isEnabled());
    }
    @Test
    public void jSIntoView() {
        driver.get("https://www.hotelmycamp.com/");

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        WebElement expectedElement = driver.findElement(By.xpath("(//a[@class='btn-custom'])[2]"));
        jse.executeScript("arguments[0].scrollIntoView(true);", expectedElement);
        jse.executeScript("arguments[0].click();",expectedElement);

    }
}

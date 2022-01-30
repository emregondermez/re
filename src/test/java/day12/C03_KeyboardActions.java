package day12;

import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C03_KeyboardActions extends TestBase {

    // https://www.amazon.com a gidelim
    // arama kutusuna actions metodlarini kullanarak samsung A71 yazdirin
    // enter e basarak arama yaptirin
    // aramanin gerceklestigini kontrol edin

    @Test
    public void keyboardActions() throws InterruptedException {
        driver.get("https://www.amazon.com");
        WebElement searchBox = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        Actions actions = new Actions(driver);
//        actions.click(searchBox);
//        actions.sendKeys("samsung ").perform();
//       actions.keyDown(Keys.SHIFT).perform();
//        actions.sendKeys("a").perform();
//        actions.keyUp(Keys.SHIFT).perform();
//        actions.sendKeys("71").perform();
//        actions.sendKeys(Keys.ENTER).perform();

        actions.click(searchBox).
                sendKeys("samsung ").
                keyDown(Keys.SHIFT).
                sendKeys("a").
                keyUp(Keys.SHIFT).
                sendKeys("71").
                sendKeys(Keys.ENTER).perform();

        // aramanin gerceklestigini kontrol edin

        WebElement result = driver.findElement(By.xpath("//span[@class='a-color-state a-text-bold']"));
       String actualResult = result.getText();
        String expectedResult ="samsung A71";
        Assert.assertTrue(actualResult.contains(expectedResult));
    }
}

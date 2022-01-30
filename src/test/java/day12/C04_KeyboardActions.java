package day12;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C04_KeyboardActions extends TestBase {

    // https://html.com/tags/iframe sayfasina gidelim
    // videoyu gorecek kadar asagiya in
    // videoyu izlemek icin play tusuna basin
    //videoyu calistirdiginizi test edin


    @Test
    public void video() throws InterruptedException {
        // https://html.com/tags/iframe sayfasina gidelim
        driver.get("https://html.com/tags/iframe");

        // videoyu gorecek kadar asagiya in
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).perform();

        Thread.sleep(5000);
        // videoyu izlemek icin play tusuna basin
        WebElement iframe = driver.findElement(By.className("lazy-loaded"));
        driver.switchTo().frame(iframe);
        driver.findElement(By.xpath("//button[@class='ytp-large-play-button ytp-button']")).click();

        //videoyu calistirdiginizi test edin
        WebElement subtitleButton = driver.findElement(By.xpath("//button[@class='ytp-subtitles-button ytp-button']"));

        Assert.assertTrue(subtitleButton.isEnabled());


    }
}

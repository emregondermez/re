package day15;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;

public class C02_ScreenShot02 extends TestBase {

    @Test
    public void screenshot() throws IOException {
        // amazon sayfasina gidelim
        driver.get("https://www.amazon.com");
        //nutella icin arama yaplaim
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("nutella", Keys.ENTER);
        //sonuclarin nutella icerdigini test edelim
        WebElement result = driver.findElement(By.xpath("(//div[@class='sg-col-inner'])[1]"));
        String actualResult = result.getText();
        String expectedResult = "nutella";
        Assert.assertTrue(actualResult.contains(expectedResult));
        //testin calistiginin ispati icin sonuc yazisi web elementinin screenshot 'ini alalim

    // 1. adim --> Ss ini alacagimiz elementi locate edelim
// WebElement result = driver.findElement(By.xpath("(//div[@class='sg-col-inner'])[1]"));
    // 2. adim --> ss i kaydedecegimiz bir dosya olusturalim
        File webElementSS = new File("src/test/java/day15/webElement.png");

    // 3. adim --> bir dosya daha olusturup screenshot objesi ile ss alalim
        File geciciSS = result.getScreenshotAs(OutputType.FILE);

    // 4. adim --> gecici ss'i kayit edecegimiz dosyaya kopyalaim
        FileUtils.copyFile(geciciSS,webElementSS);

     //




    }
}

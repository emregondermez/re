package day15;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;

public class C01_ScreenShot extends TestBase {


    @Test
    public void screenshot() throws IOException {
        // amazon sayfasina gidelim
        driver.get("https://www.amazon.com");
        //nutella icin arama yaplaim
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("nutella", Keys.ENTER);
        //sonuclarin nutella icerdigini test edelim
        WebElement result = driver.findElement(By.xpath("//span[@class='a-color-state a-text-bold']"));
        String actualResult = result.getText();
        String expectedResult = "nutella";
        Assert.assertTrue(actualResult.contains(expectedResult));
        //testin calistiginin ispati icin tum sayfanin screenshot 'ini alalim


        // --> Tum sayfa Screenshot almak icin 4 adim uygulanir

        // 1.adim --> TakeScreenshot objesi olusturma

        TakesScreenshot tss=(TakesScreenshot) driver;

        // 2.adim --> Kaydedecegimiz dosyayi olusturalim

        File tumSayfaSS = new File("src/test/java/day15/tumSayfa.png");

        // 3.adim --> bir dosya daha olusturup screenshot objesi ile ss alalim

        File geciciResim = tss.getScreenshotAs(OutputType.FILE);

        // 4.adim --> gecici dosyayi asil kaydetmek istedigimiz asil dosyaya copy yapalim

        FileUtils.copyFile(geciciResim,tumSayfaSS);



       // 1 Take screenshot objesi olustur
        TakesScreenshot ss = (TakesScreenshot) driver;

        //  2  kaydedecegimiz dosyayolunu olusturuyoruz

        File tumSayfass2 = new File("src/test/java/day15/koplesayfaSs.jpeg");
        // 3 -> Gecici bir doosya olusturarak obje ile ss alalim

        File geciciss = ss.getScreenshotAs(OutputType.FILE);

        // 4-> gecici dosyayi asil ss e kopyalayalim

        FileUtils.copyFile(geciciResim,tumSayfass2);



        /*
        1--> takeScreenShot objesi olustur
        2--> dosyanin kaydedilecegi yeri belirlee  --> File objesi olustur
        3--> gecici bir dosya olustur TakeScreenshot objesi ile ss al
         */

        TakesScreenshot ss2 = (TakesScreenshot) driver;
        File allPageSs = new File("src/test/java/day15/allPageSS.jpeg");
        File temporarySS = ss2.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(temporarySS,allPageSs);


        File all2 = new File("src/test/java/day15/all2.png");
        File temporary2 = ss.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(temporary2,all2);








    }
}

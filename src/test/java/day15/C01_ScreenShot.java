package day15;

import org.openqa.selenium.By;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C01_ScreenShot extends TestBase {


    @Test
    public void screenshot() {
        // amazon sayfasina gidelim
        driver.get("https://www.amazon.com");
        //nutella icin arama yaplaim
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("nutella");
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



    }
}

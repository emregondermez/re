package day13;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C04_FileDownload extends TestBase {
    //1. Tests packagenin altina bir class oluşturalim : C04_FileDownload
    //2. Iki tane metod oluşturun : isExist() ve downloadTest()
    //3. downloadTest () metodunun icinde aşağıdaki testi yapalim
    //https://theinternet.herokuapp.com/download adresine gidelim
    //code.txt dosyasını indir elim
    // Ardından isExist() methodunda dosyanın başarıyla indirilip indirilmediğini test edelim


    @Test (priority = 1)
    public void fileExist() {
        String dosyaYolu = System.getProperty("user.home")+"\\Downloads\\profile picture.jpg";
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));
    }

    @Test
    void getPage() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/download");
        driver.findElement(By.xpath("//a[text()='profile picture.jpg']")).click();
        Thread.sleep(5000);
    }














}

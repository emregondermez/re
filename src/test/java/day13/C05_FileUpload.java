package day13;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C05_FileUpload extends TestBase {

//https://the-internet.herokuapp.com/upload adresine gidelim
//chooseFile butonuna basalim
//Yuklemek istediginiz dosyayi sec elim
//Upload butonuna bas alim
//“File Uploaded!” textinin goruntulendigini test edelim


    @Test
    public void fileUpload() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/upload");

        String filePath = System.getProperty("user.home")+"\\Downloads\\profile picture.jpg";
        WebElement chooseFileButton = driver.findElement(By.xpath("//input[@id='file-upload']"));
        chooseFileButton.sendKeys(filePath);
        driver.findElement(By.xpath("//input[@id='file-submit']")).click();
        Thread.sleep(3000);

        WebElement result = driver.findElement(By.tagName("h3"));

        Assert.assertTrue(result.isEnabled());


    }





}

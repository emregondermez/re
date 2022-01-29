package day12;

import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.util.Set;

public class C02_MouseActions extends TestBase {

    //Yeni bir class olusturalim: MouseActions1
    //https://the internet.herokuapp.com/context_menu sitesine gidelim
    //Cizili alan uzerinde sag click yapalim
    //Alert’te cikan yazinin “You selected a context menu” oldugunu
    //test edelim.
    //Tamam diyerek alert’i kapatalim
    //Elemental Selenium linkine tiklayalim
    //Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim

    @Test
    public void mouseActions() {
        //https://the internet.herokuapp.com/context_menu sitesine gidelim
        driver.get("https://the-internet.herokuapp.com/context_menu");
        String firstPAgeHandle = driver.getWindowHandle();
        Actions actions = new Actions(driver);
        //Cizili alan uzerinde sag click yapalim
        WebElement cizgiliAlan = driver.findElement(By.id("hot-spot"));
        actions.contextClick(cizgiliAlan).perform();
        //Alert’te cikan yazinin “You selected a context menu” oldugunu
        //test edelim.
        String actualAlertText = driver.switchTo().alert().getText();
        String expectedAlertText ="You selected a context menu";
        //Tamam diyerek alert’i kapatalim
        Assert.assertEquals(actualAlertText,expectedAlertText);
        driver.switchTo().alert().accept();


        //Elemental Selenium linkine tiklayalim
        driver.findElement(By.xpath("//a[@target='_blank']")).click();

        //Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim

        Set<String> handleList =driver.getWindowHandles();
        String secondPageHandle="";
        for (String each: handleList) {
            if (!each.equals(firstPAgeHandle)) {
            secondPageHandle=each;
            }
        }

        driver.switchTo().window(secondPageHandle);
        WebElement h1Tag = driver.findElement(By.tagName("h1"));
        String actualString = h1Tag.getText();
        String expectedString ="Elemental Selenium";

        Assert.assertEquals(actualString,expectedString);

        }

}

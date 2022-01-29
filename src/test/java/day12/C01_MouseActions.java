package day12;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C01_MouseActions extends TestBase {

    //amazon sayfasina gidin
    //sag ustte hello sign in elementinin uzerinde mouse'u bekletin
    // acilan menude new list linkine tiklayin
    //ve new list sayfasinin acildigini test edin

    @Test
    public void amazonList() throws InterruptedException {
        driver.get("https://www.amazon.com");
        Actions actions = new Actions(driver);
        WebElement helloSugnIn = driver.findElement(By.id("nav-link-accountList-nav-line-1"));
        actions.moveToElement(helloSugnIn).perform();



        WebElement createList = driver.findElement(By.xpath("//span[text()='Create a List']"));
       createList.click();

        WebElement listPageElement = driver.findElement(By.xpath("//div[@role='heading']"));
        Assert.assertTrue(listPageElement.isEnabled());

        Thread.sleep(3000);

    }



}

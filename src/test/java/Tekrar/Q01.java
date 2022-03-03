package Tekrar;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.awt.*;
import java.time.Duration;
import java.util.Set;

public class Q01 {

     /*
      go to url :http://demo.guru99.com/popup.php
      get the first window
      clicking on click here button
      get all the window in the set
      switch to window
      input email id (somepne@gmail.com) and type something in that input
      Clicking on the submit button
      verify title as expected
      switch to first window
     */

WebDriver driver;
    @Test
    public void test01() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();


        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("http://demo.guru99.com/popup.php");
        Thread.sleep(4000);
        driver.manage().deleteAllCookies();
      driver.findElement(By.xpath("(//div[@class='action-wrapper'])[3]")).click();
        String firstpageHandleValue = driver.getWindowHandle();

        driver.findElement(By.xpath("//a[@href='../articles_popup.php']")).click();


        Set<String> handleValue = driver.getWindowHandles();

        String secondPageHandleValue="";
        for (String each: handleValue) {
            if (!each.equals(firstpageHandleValue)) {
                secondPageHandleValue=each;
            }
        }
        driver.switchTo().window(secondPageHandleValue);
        WebElement emailBox = driver.findElement(By.xpath("//input[@name='emailid']"));
        emailBox.sendKeys("somepne@gmail.com");

        driver.findElement(By.xpath("//input[@name='btnLogin']")).click();

        WebElement access = driver.findElement(By.xpath("//h2[text()='Access details to demo site.']"));

        Assert.assertTrue(access.isEnabled());

        driver.switchTo().window(firstpageHandleValue);

        Thread.sleep(3000);
        driver.close();
    }
}

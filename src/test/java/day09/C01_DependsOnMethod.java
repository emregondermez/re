package day09;

import io.github.bonigarcia.wdm.WdmAgent;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class C01_DependsOnMethod {

    // https://www.amazon.com/ adresine gidin.
    //    1. Test : Amazon ana sayfaya gittiginizi test edin
    //    2. Test : 1.Test basarili ise search Box’i kullanarak “Nutella” icin  arama yapin
    //    ve aramanizin gerceklestigini Test edin
    //    3.Test : “Nutella” icin arama yapildiysa ilk urunu tiklayin ve fiyatinin    $14.99 oldugunu test edin

    WebDriver driver;
    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        // https://www.amazon.com/ adresine gidin.

    }

    @Test
    public void logo() {
        //    1. Test : Amazon ana sayfaya gittiginizi test edin
        driver.get("https://www.amazon.com/");
        WebElement logo = driver.findElement(By.id("nav-logo-sprites"));
        Assert.assertTrue(logo.isEnabled());


    }
    @Test (dependsOnMethods = "logo")
    public void amazonNutella() {
        //    2. Test : 1.Test basarili ise search Box’i kullanarak “Nutella” icin  arama yapin
        //    ve aramanizin gerceklestigini Test edin
        WebElement searcBox = driver.findElement(By.id("twotabsearchtextbox"));
        searcBox.sendKeys("Nutella", Keys.ENTER);
        WebElement result = driver.findElement(By.xpath("//span[@class='a-color-state a-text-bold']"));
       String actualResult = result.getText();
        String expectedResult ="Nutella";
        Assert.assertTrue(actualResult.contains(expectedResult));
    }
    @Test (dependsOnMethods = "amazonNutella")
    public void priceTest() {
//    3.Test : “Nutella” icin arama yapildiysa ilk urunu tiklayin ve fiyatinin    $14.99 oldugunu test edin
         driver.findElement(By.xpath("(//span[@class='a-size-base-plus a-color-base a-text-normal'])[1]")).click();
        WebElement price = driver.findElement(By.xpath("//span[@class='a-size-base a-color-price']"));
        String actualPrice = price.getText();
        String expectedPrice = "$14.99";

        Assert.assertTrue(actualPrice.contains(expectedPrice));

    }

    @AfterClass

    public void teardown() {
driver.close();
    }








}

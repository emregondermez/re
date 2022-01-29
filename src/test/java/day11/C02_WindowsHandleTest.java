package day11;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.Set;

public class C02_WindowsHandleTest {
    //● Tests package’inda yeni bir class olusturun: WindowHandle2
    //● https://the-internet.herokuapp.com/windows adresine gidin.
    //● Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
    //● Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
    //● Click Here butonuna basın.
    //● Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
    //● Sayfadaki textin “New Window” olduğunu doğrulayın.
    //● Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu doğrulayın.


    WebDriver driver;
    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }


    @Test
    public void windowHandle() throws InterruptedException {
   //● https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");
        String firstPageHandle = driver.getWindowHandle();
   //● Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
        WebElement text = driver.findElement(By.tagName("h3"));
        String actualText = text.getText();
        String expectedText = "Opening a new window";
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actualText,expectedText,"the actual text does not equal to expected text");
        //● Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
        String actualTitle = driver.getTitle();
        String expectedTitle = "The Internet";
        softAssert.assertEquals(actualTitle,expectedTitle,"Title is not The Internet");
        //● Click Here butonuna basın.
        driver.findElement(By.xpath("(//a[@target='_blank'])[1]")).click();
//● Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
        Set<String> windowHandles = driver.getWindowHandles();
        String newHandleValue= "";
        for (String each : windowHandles) {
            if (!each.equals(firstPageHandle)){
                newHandleValue=each;
            }
        }
        driver.switchTo().window(newHandleValue);

        String actualNewTitle = driver.getTitle();
        String expectedNewTitle = "New Window";
        softAssert.assertEquals(actualNewTitle,expectedNewTitle,"Title is not New Window");
        //● Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu doğrulayın.
        driver.switchTo().window(firstPageHandle);
        actualTitle = driver.getTitle();
        expectedTitle = "The Internet";
        softAssert.assertEquals(actualTitle,expectedTitle,"Title is not The Internet");

        softAssert.assertAll();
    }

    @AfterClass
    public void teardown() {
        driver.quit();
    }
}

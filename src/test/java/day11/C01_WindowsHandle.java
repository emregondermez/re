package day11;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class C01_WindowsHandle {

    WebDriver driver;
    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }

    @Test
    public void windowHandle() throws InterruptedException {
        driver.get("https://www.amazon.com");
        String amazonHandleValue = driver.getWindowHandle();
        System.out.println("Amazon Handle Degeri = "+ amazonHandleValue);


        driver.switchTo().newWindow(WindowType.WINDOW); // yeni pencere acar
        driver.get("https://www.bestbuy.com");
        String bestbuynHandleValue = driver.getWindowHandle();
        System.out.println("Amazon Handle Degeri = "+ bestbuynHandleValue);


        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.facebook.com");
        Thread.sleep(3000);

        driver.switchTo().window(amazonHandleValue);
        Thread.sleep(3000);
        driver.switchTo().window(bestbuynHandleValue);
        Thread.sleep(3000);


    }

    @AfterClass
    public void teardown() {
        driver.quit();
    }
}

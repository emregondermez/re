package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public class TestBase {

    protected WebDriver driver;

    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }
    @AfterClass
    public void teardown() {
     driver.quit();
    }

    public void allPageSs() throws IOException {
        String date = new SimpleDateFormat("yyMMddhhmmss").format(new Date());
        TakesScreenshot ss = (TakesScreenshot) driver;
        File allPageSs = new File("src/test/java/Screenshots/allPageSS"+date+".jpeg");
        File temporarySs = ss.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(temporarySs,allPageSs);

    }

    public void elementSS(WebElement element) throws IOException {

        String date = new SimpleDateFormat("yyMMddhhmmss").format(new Date());
        File elementSs = new File("src/test/java/Screenshots/element"+date+".jpeg");
        File temporaryElementSs = element.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(temporaryElementSs,elementSs);
    }
}

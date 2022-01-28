package day10;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

public class C02_BasicAuthentication {
//1- Bir class olusturun : BasicAuthentication
//2- https://the-internet.herokuapp.com/basic_auth sayfasina gidin
//3- asagidaki yontem ve test datalarini kullanarak authentication’i yapin
//    Html komutu : https://username:password@URL
//    Username     : admin
//    password      : admin
//4- Basarili sekilde sayfaya girildigini dogrulayin

    WebDriver driver;
    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();

    }

}

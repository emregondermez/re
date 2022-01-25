package test.day08;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class C02_HandleDropdown {

    WebDriver driver ;

    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void dropDownTest() throws InterruptedException {
        driver.get("https://www.amazon.com");
        // Dropdown da var olan bir secenegi secmek icin
        // 1. Adim : DropDown elementini locate edip bir degiskene atiyoruz

        WebElement dropDown = driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));

        // 2.adim: Select class'indan bir obje olusturalim
        // ve parametre olarak locate ettigimiz elementi yazalim

        Select select = new Select(dropDown);
        select.selectByIndex(3);

        Thread.sleep(3000);
        select.selectByVisibleText("Deals");

        // DropDown daki tum listeyi yazdiralim

        List<WebElement> optionList = select.getOptions();

        for (WebElement each: optionList ) {
            System.out.println(each.getText());
        }


    }

    @AfterMethod
    public void teardown() {
        driver.close();
    }
}

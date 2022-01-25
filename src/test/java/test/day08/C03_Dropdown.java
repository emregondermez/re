package test.day08;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class C03_Dropdown {

    //● https://the-internet.herokuapp.com/dropdown adresine gidin.
    //    1.Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
    //    2.Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın
    //    3.Tüm dropdown değerleri(value) yazdırın
    //    4. Dropdown’un boyutunu bulun, Dropdown’da 4 öğe varsa konsolda True , degilse False yazdırın.

    WebDriver driver;
    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @Test
    public void dropDownTest() {
        // https://the-internet.herokuapp.com/dropdown adresine gidin.

        driver.get("https://the-internet.herokuapp.com/dropdown");
        WebElement dropdown = driver.findElement(By.xpath("//select[@id='dropdown']"));
    //    1.Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        Select select = new Select(dropdown);

        select.selectByIndex(1);
        System.out.println(select.getFirstSelectedOption().getText());

        //    2.Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın
        select.selectByValue("2");
        System.out.println(select.getFirstSelectedOption().getText());

        System.out.println("\nList");
        //    3.Tüm dropdown değerleri(value) yazdırın

        List<WebElement> optionList = select.getOptions();

        for (WebElement each: optionList) {
            System.out.println(each.getText());
        }
//    4. Dropdown’un boyutunu bulun, Dropdown’da 4 öğe oldugunu kontrol edin.

        int actualDropDownSize = optionList.size();
        int expectedDropDownSize=4;

        Assert.assertEquals(actualDropDownSize,expectedDropDownSize);


    }

    @AfterMethod
    public void teardown() {
        driver.close();
    }
}

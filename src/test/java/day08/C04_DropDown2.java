package day08;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class C04_DropDown2 {

    //  https://www.amazon.com/ adresine gidin.
    //- Test 1
    //    Arama kutusunun yanindaki kategori menusundeki kategori sayisinin 45 oldugunu test edin
    //-Test 2
    //    1. Kategori menusunden Books secenegini  secin
    //    2. Arama kutusuna Java yazin ve aratin
    //    3. Bulunan sonuc sayisini yazdirin
    //    4. Sonucun Java kelimesini icerdigini test edin
WebDriver driver;
    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        //  https://www.amazon.com/ adresine gidin.
        driver.get("https://www.amazon.com/");
    }

    @Test
    public void test1() {
        //- Test 1
        //    Arama kutusunun yanindaki kategori menusundeki kategori sayisinin 45 oldugunu test edin
        WebElement dropdownElement = driver.findElement(By.xpath("//select[@aria-describedby='searchDropdownDescription']"));

        Select select = new Select(dropdownElement);
        List<WebElement> optionsList = select.getOptions();

        int actualListSize = optionsList.size();
        int expectedListSize =45;

        Assert.assertEquals(actualListSize,expectedListSize,"The list size is not equals to 45");

    }

    @Test
    public void test2() {
        //-Test 2
        //    1. Kategori menusunden Books secenegini  secin
        WebElement dropdownElement = driver.findElement(By.xpath("//select[@aria-describedby='searchDropdownDescription']"));

        Select select = new Select(dropdownElement);

        select.selectByVisibleText("Books");
        //    2. Arama kutusuna Java yazin ve aratin
    WebElement seachBox= driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
    seachBox.sendKeys("Java");
    seachBox.submit();
        //    3. Bulunan sonuc sayisini yazdirin
        WebElement result = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        String actualResult = result.getText();
        System.out.println(actualResult);
        //    4. Sonucun Java kelimesini icerdigini test edin
        String expectedResult="Java";

        Assert.assertTrue(actualResult.contains(expectedResult),"Java icermiyor");
    }

    @AfterClass
    public void teardown() {
    driver.close();
    }

}

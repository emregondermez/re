package day14;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C02_Faker extends TestBase {
    //"https://facebook.com" Adresine gidin
    //“create new account” butonuna basin
    //“firstName” giris kutusuna bir isim yazin
    //“surname” giris kutusuna bir soyisim yazin
    //“email” giris kutusuna bir email yazin
    //“email” onay kutusuna emaili tekrar yazin
    //Bir sifre girin
    //Tarih icin gun secin
    //Tarih icin ay secin
    //Tarih icin yil secin
    //Cinsiyeti secin
    //Isaretlediginiz cinsiyetin secili, diger cinsiyet kutusunun secili olmadigini test edin.
    //Sayfayi kapatin

    @Test
    public void faker() {
        //"https://facebook.com" Adresine gidin
        driver.get("https://facebook.com");
        driver.findElement(By.xpath("(//button[@value='1'])[3]")).click();
        //“create new account” butonuna basin
        driver.findElement(By.xpath("(//a[@role='button'])[2]")).click();
        //“firstName” giris kutusuna bir isim yazin
        WebElement firstName=driver.findElement(By.xpath("//input[@placeholder='First name']"));

        Faker faker = new Faker();
        String fakePassword = faker.internet().password();
        String fakeEmail = faker.internet().emailAddress();
        Actions actions = new Actions(driver);
        actions.click(firstName)
                .sendKeys(faker.name().name())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.name().lastName())
                .sendKeys(Keys.TAB)
                .sendKeys(fakeEmail)
                .sendKeys(Keys.TAB)
                .sendKeys(fakeEmail)
                .sendKeys(Keys.TAB)
                .sendKeys(fakePassword)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys("May")
                .sendKeys(Keys.TAB)
                .sendKeys("23")
                .sendKeys(Keys.TAB)
                .sendKeys("1995")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.RIGHT).click()
                .perform();

        WebElement female = driver.findElement(By.xpath("//input[@value='1']"));
        Assert.assertFalse(female.isSelected());

        WebElement male = driver.findElement(By.xpath("//input[@value='2']"));
        Assert.assertTrue(male.isSelected());

    }
}

package Test;

import Test.BaseTest;
import com.thoughtworks.gauge.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import static Constants.Constants.*;
import static org.junit.Assert.assertEquals;
import org.openqa.selenium.interactions.SendKeysAction;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.Keys;

import java.util.List;

public class StepImplementation extends BasePage {
    private static Logger logger = LogManager.getLogger(BasePage.class);

    @Step("Arama Butonuna Tıklama")
    public void searchButton() {
        logger.info("Arama butonuna Tıklanıyor");
        driverWait.until(ExpectedConditions.elementToBeClickable(By.xpath(AramaButonu))).click();
        logger.info("Arama butonuna Tıklandı");
    }

    @Step("Arama kutusuna <key> yazıldı")
    public void searchKey(String key) {
        logger.info(key + "aranıyor");
        WebElement element = driver.findElement(By.xpath(AramaButonu));
        element.sendKeys(key);
        element.sendKeys(Keys.ENTER);
        logger.info(key + "arandı");
    }

    @Step("Urune IN")
    public void scrollToElement() {
        logger.info("Urüne iniliyor");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath(URUN)));
        logger.info("Urüne inildi");
    }

    @Step("Urun detayi")
    public void productIndex() {
        logger.info("Urune Tıklanıyor");
        driver.findElement(By.xpath(URUN)).click();
        logger.info("Urune Tıklandı");
    }

    @Step("Miktar seçme")
    public void List() {
        logger.info("miktar seçimi yapılıyor");
        driver.findElement(By.xpath(MIKTAR)).click();
        driverWait.until(ExpectedConditions.elementToBeClickable(By.xpath(Adet))).click();
        logger.info("miktar seçimi yapıldı");

    }

    @Step("Sepete ekle")
    public void addToBasket() {
        logger.info("Sepete Ekleniyor");
        driver.findElement(By.xpath(SepetEkle)).click();
        logger.info("Sepete eklendi");
    }

    @Step("Sepete Git")
    public void Basket() {
        logger.info("Sepete Gidiliyor");
        driver.findElement(By.xpath(Sepet)).click();
        logger.info("Sepete gidildi");
    }

    @Step("elementte seçilen değer var mı")
    public void AssertBack() {
        logger.info("ÜRÜNLER KONTROL EDİLİYOR");
        WebElement element = driver.findElement(By.xpath(COUNTS));
        String elText = element.getAttribute("value");
        System.out.println(elText);
        Assert.assertEquals(COUNT, elText);
        logger.info("ÜRÜNLER KONTROL EDİLDİ");
    }

    @Step("<2> saniye kadar bekle")
    public void implementation1(Object arg0) {

    }
    @Step("<x> saniye bekle")
    public void waitForSecond(Integer x) throws InterruptedException {
        logger.info("Static bekleme konuluyor");
        Thread.sleep(1000 * x);
        logger.info("Static bekleme yapıldı");
    }


}



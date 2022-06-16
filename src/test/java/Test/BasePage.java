package Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebElement;
import java.util.List;
import org.openqa.selenium.By;

public class BasePage extends BaseTest {

    WebDriverWait driverWait = new WebDriverWait(driver, 60);

    public List<WebElement> listElements(By by) { //Elemenetler Listeleniyor
        return driver.findElements(by);
    }
}

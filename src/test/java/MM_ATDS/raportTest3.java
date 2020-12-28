package MM_ATDS;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import java.util.List;


public class raportTest3 {

    private WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        options.addArguments("window-size=1903,969");
        driver = new ChromeDriver(options);
       // driver.manage().window().maximize();
        driver.get("https://cbpdev.energa.loc/ami/MainLogin.l4d");

    }

    @Test
    public void raportTest() {
        driver.findElement(By.xpath("/html/body/div/div[2]/button[3]")).click();
        driver.findElement(By.xpath("/html/body/div/div[3]/p[2]/a")).click();
        amiLogowanie("Z4100542", "Jan123!#Pap");
    }

    private void amiLogowanie(String name, String password) {
        WebElement loginField = driver.findElement(By.className("loginForm"));
        List<WebElement> loginFields = loginField.findElements(By.tagName("input"));
        loginFields.get(0).sendKeys(name);
        loginFields.get(1).sendKeys(password);
        driver.findElement(By.id("submitBtn")).click();
        Actions builder = new Actions(driver);
        WebElement showMenu = driver.findElement(By.id("showMenu"));
        builder.moveToElement(showMenu).perform();

    }

    @After
    public void tearDown(){
        // Zamknij przeglądarkę
        // driver.quit();
    }
}
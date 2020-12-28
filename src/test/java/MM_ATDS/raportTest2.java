package MM_ATDS;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;


public class raportTest2 {

    private WebDriver driver;


    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        Dimension d = new Dimension(1903,969);
        driver.manage().window().setSize(d);
        driver.get("https://cbpdev.energa.loc/ami/MainLogin.l4d");
        driver.findElement(By.xpath("/html/body/div/div[2]/button[3]")).click();
        driver.findElement(By.xpath("/html/body/div/div[3]/p[2]/a")).click();
    }

    @Test
    public void raportTest() throws InterruptedException {
        amiLogowanie("Z4100542", "Jan123!#Pap");
    }

    private void amiLogowanie(String name, String password) {
        WebElement loginField = driver.findElement(By.className("loginForm"));
        List<WebElement> loginFields = loginField.findElements(By.tagName("input"));
        loginFields.get(0).sendKeys(name);
        loginFields.get(1).sendKeys(password);
        driver.findElement(By.id("submitBtn")).click();

        WebElement amiMenuLewaStrefa2 = driver.findElement(By.id("leftMenuArea"));
        List<WebElement> zakladki2 = amiMenuLewaStrefa2.findElements(By.tagName("a"));


        for (int i = 15; i < zakladki2.size(); i++) {
            if (driver.findElements(By.id("showMenu")).size() > 0 && driver.findElement(By.id("showMenu")).isDisplayed()) {
                WebDriverWait wait = new WebDriverWait(driver, 10);
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("amiRightArea")));
                Actions builder = new Actions(driver);
                WebElement showMenu = driver.findElement(By.id("showMenu"));
                builder.moveToElement(showMenu).perform();
                WebElement amiMenuLewaStrefa = driver.findElement(By.id("leftMenuArea"));
                List<WebElement> zakladki = amiMenuLewaStrefa.findElements(By.tagName("a"));
                zakladki.get(i).click();
            } else if ((driver.findElement(By.id("language-select")).isDisplayed())) {
                driver.navigate().back();
            }
        }
    }

    @After
    public void tearDown() {
        // Zamknij przeglądarkę
        // driver.quit();
    }
}
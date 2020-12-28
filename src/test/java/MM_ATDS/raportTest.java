package MM_ATDS;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.junit.*;
import org.openqa.selenium.interactions.Actions;
import java.util.List;


public class raportTest {

    private WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://cbpdev.energa.loc/ami/MainLogin.l4d");
        driver.manage().deleteAllCookies();
        driver.findElement(By.xpath("/html/body/div/div[2]/button[3]")).click();
        driver.findElement(By.xpath("/html/body/div/div[3]/p[2]/a")).click();
    }

    @Test
    public void raportTest() throws InterruptedException {
        amiLogowanie("LOGIN", "HASLO");
    }

    private void amiLogowanie(String name, String password) throws InterruptedException {
        WebElement loginField = driver.findElement(By.className("loginForm"));
        List<WebElement> loginFields = loginField.findElements(By.tagName("input"));
        loginFields.get(0).sendKeys(name);
        loginFields.get(1).sendKeys(password);
        driver.findElement(By.id("submitBtn")).click();

        for (int i = 24; i < 26; i++) {

            if (driver.findElement(By.id("showMenu")).isDisplayed()) {
                Thread.sleep(2000);
                Actions builder = new Actions(driver);
                WebElement showMenu = driver.findElement(By.id("showMenu"));
                builder.moveToElement(showMenu).perform();
                WebElement amiMenuLewaStrefa = driver.findElement(By.id("leftMenuArea"));
                List<WebElement> zakladki = amiMenuLewaStrefa.findElements(By.tagName("a"));
                zakladki.get(i).click();
            }

            else if (driver.findElement(By.id("language-select")).isDisplayed())
            {
                Thread.sleep(1500);
                driver.navigate().back();
            }

        }}

        @After
        public void tearDown(){
            // Zamknij przeglądarkę
            // driver.quit();
        }
    }

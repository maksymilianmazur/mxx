package cucumber.test.OgolneObiekty;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;
import static org.junit.Assert.assertEquals;

public class Login {

    private String login;
    private WebDriver driver;
    private boolean initialized = false;

    @Before
    public void init() throws Exception {
        if (!initialized) {
            System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
            driver = new ChromeDriver();
            Dimension d = new Dimension(1903,969);
            driver.manage().window().setSize(d);
            driver.get("https://cbpdev.energa.loc/ami/MainLogin.l4d");
            driver.findElement(By.xpath("/html/body/div/div[2]/button[3]")).click();
            driver.findElement(By.xpath("/html/body/div/div[3]/p[2]/a")).click();
            initialized = true;
        }
    }

    @When("^uzytkownik loguje sie do systemu (.*) oraz (.*)$")
    public void uzytkownikZalogujeSieDoSystemu(String login, String password) {
        this.login = login;
        WebElement loginField = driver.findElement(By.className("loginForm"));
        List<WebElement> loginFields = loginField.findElements(By.tagName("input"));
        loginFields.get(0).sendKeys(login);
        loginFields.get(1).sendKeys(password);
        driver.findElement(By.id("submitBtn")).click();
    }

    @Then("^sprawdzenie poprawnosci logowania$")
    public void sprawdzeniePoprawnosciLogowania() {
        assertEquals(login, driver.findElement(By.id("topPageInfoArea")).getText());
    }

    @And("^uzytkownik zamyka przegladarke$")
    public void zamknieciePrzegladarki() {
        driver.quit();
    }

    public WebDriver getDriver() {
        return driver;
    }
}

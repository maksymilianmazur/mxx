package cucumber.test;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;
import java.util.Random;
import static org.junit.Assert.assertEquals;

public class CodersGuru {

    private WebDriver driver;
    String[] randomNames = new String[] {"Arek","Marek","Jarek","Jan","Jurek","Alexy","Gracjan"};
    String[] randomSurnames = new String[] {"Kowalski","Mazur","Skubiszewski","Michalski","Mamrot","Sawczenko","Kozak","Stanislawczyk","Traczyk"};
    String[] randomDomain = new String[]{"pl","com","de"};
    Random random = new Random();
    int randomInteger = random.nextInt(150);
    int randomInteger2 = random.nextInt((999)+100);
    int randomInteger3 = random.nextInt((99)+10);
    @Given("^an open browser with CodersGuru website$")
    public void anOperBrowserWithCodersGuruWebsite() {
        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/drivers/chromedriver");
        driver = new ChromeDriver();         // Uruchom nowy egzemplarz przeglądarki Chrome
        driver.manage().window().maximize();         // Zmaksymalizuj okno przeglądarki
        driver.get("https://tester.codersguru.pl/");         //otworzenie witryny www
    }

    @When("^user press the button „załóż konto”$")
    public void userPressTheButtonZałóżKonto() {
        WebElement buttonZalozKonto = driver.findElement(By.className("main-page-top__email-input-sent"));
        buttonZalozKonto.click();
    }
    @And("^user fills registration data$")
    public void userFillsRegistrationData() {
        WebElement accountField = driver.findElement(By.className("registration__control-container")); //zaznaczenie "prywatnie"
        List<WebElement> accountType = accountField.findElements(By.tagName("button"));
        accountType.get(0).click();
        WebElement registrationZone = driver.findElement(By.className("has-validation-callback"));
        List<WebElement> inputFields = registrationZone.findElements(By.tagName("input"));
        String[] randomCity = new String[] {"Wroclaw","Warszawa","Praga","Berlin","Moskwa","Gdansk","Opole","Gdynia","Sopot"};
        String[] randomStreet = new String[] {"Poleska","Opolska","Klimasa","Kozanowska","Stoleczna","Prusa","Dubois","Wawrzyniaka","Sopocka"};
        inputFields.get(0).sendKeys(randomInteger+ "przykladowymail" +randomInteger2 + "@gmail."+ randomDomain[randomInteger%3]);
        inputFields.get(1).sendKeys(randomNames[randomInteger%7]);
        inputFields.get(2).sendKeys(randomSurnames[randomInteger%9]);
        inputFields.get(3).sendKeys("Password"+randomInteger);
        inputFields.get(4).sendKeys("Password"+randomInteger);
        inputFields.get(5).sendKeys(randomCity[randomInteger%9]);
        inputFields.get(6).sendKeys(randomInteger3+"-"+randomInteger2);
        inputFields.get(7).sendKeys(randomStreet[randomInteger%9]);
        inputFields.get(8).sendKeys(randomInteger3+"/"+randomInteger3%10);
    }

    @And("^user selects a checkbox$")
    public void userSelectsACheckbox() {
        WebElement checkbox = driver.findElement(By.xpath("/html/body/div/div/div/form/div[12]/input"));
        checkbox.click();
    }

    @And("^user press a button „zarejestruj”$")
    public void userPressAButtonZarejestruj() {
        WebElement button2 = driver.findElement(By.xpath("/html/body/div/div/div/form/div[13]/button"));
        button2.click();
    }

    @Then("^user has a private account$")
    public void userHasAPrivateAccount() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/section[1]/div/div[3]/a/img")).click();
        assertEquals(randomNames[randomInteger%7], driver.findElement(By.id("name")).getText());
        assertEquals(randomSurnames[randomInteger%9],driver.findElement(By.id("lastname")).getText());
    }

}

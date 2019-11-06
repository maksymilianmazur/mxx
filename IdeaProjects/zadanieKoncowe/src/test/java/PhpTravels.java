package cucumber.test;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import java.util.List;

public class PhpTravels {
    private WebDriver driver;

    @Given("^an open browser with PHPTravels website$")
    public void anOpenBrowserWithPHPTravelsWebsite() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/drivers/chromedriver");
        driver = new ChromeDriver();         // Uruchom nowy egzemplarz przeglądarki Chrome
        driver.manage().window().maximize();// Zmaksymalizuj okno przeglądarki
        driver.get("https://www.phptravels.net/");         //otworzenie witryny www
        Thread.sleep(15000);
//        driver.switchTo().frame("chat-widget"); //zamykanie chat-widgetu
//        driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div/div[3]/div[3]/button")).click();
//        Thread.sleep(3000);
//        driver.switchTo().defaultContent();
//        Actions builder = new Actions(driver);
//        WebElement popup = driver.findElement(By.id("livechat-eye-catcher"));
//        builder.moveToElement(popup).perform();
//        driver.findElement(By.xpath("/html/body/div[6]/div[1]")).click();
        driver.findElement(By.id("usertrack-consent__button")).click(); //zamykanie wyskakujacych okienek
        driver.findElement(By.className("cc-dismiss")).click();

}

    @When("^user selects the flights tab$")
    public void userSelectsTheFlightsTab() {
        WebElement flightTab = driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[1]/div[3]/div/div/div/div/div/nav/ul/li[2]/a")); //otworzenie zakładki flights
        flightTab.click();
    }

    @And("^user fills flight data$")
    public void userFillsFlightData() throws InterruptedException {
        WebElement from = driver.findElement(By.id("s2id_location_from"));  // wypełnienie pola from oraz wybrania konkretnego lotniska za pomocą get
        List<WebElement> inputFrom = from.findElements(By.tagName("input"));
        inputFrom.get(0).sendKeys("Warsaw");
        Thread.sleep(6000);
        List<WebElement> fromConfirmation = driver.findElements(By.className("select2-match"));
        fromConfirmation.get(0).click();
        WebElement to = driver.findElement(By.id("s2id_location_to")); // wypełnienie pola to oraz wybrania konkretnego lotniska za pomocą get
        List<WebElement> inputTo = to.findElements(By.tagName("input"));
        inputTo.get(0).sendKeys("New York");
        Thread.sleep(6000);
        List<WebElement> toConfirmation = driver.findElements(By.className("select2-match"));
        toConfirmation.get(0).click();
         //wybranie odpowiedniej daty
        for (int i = 0; i < 2; i++) {
            driver.findElement(By.id("FlightsDateStart")).click();
            Thread.sleep(5000);
            WebElement calendar = driver.findElement(By.xpath("/html/body/div[3]/div[7]"));
            Actions builder = new Actions(driver);
            builder.moveToElement(calendar).perform();
            WebElement arrow = driver.findElement(By.xpath("/html/body/div[3]/div[7]/nav/div[3]"));
            arrow.click();
        }
        Actions builder = new Actions(driver);
        driver.findElement(By.id("FlightsDateStart")).click();
        Thread.sleep(3500);
        WebElement calendar = driver.findElement(By.xpath("/html/body/div[3]/div[7]"));
        builder.moveToElement(calendar).perform();
        driver.findElement(By.xpath("/html/body/div[3]/div[7]/div/div/div[2]/div[27]")).click();
    }

    @And("^user press the button search$")
    public void userPressTheButtonSearch() {
        WebElement searchButton = driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[1]/div[3]/div/div/div/div/div/div/div[2]/div/div/form/div/div[2]/div[4]/button"));
        searchButton.click();
    }

    @And("^user selects a flight$")
    public void userSelectsAFlight() {
        WebElement flightList = driver.findElement(By.id("LIST"));
        List<WebElement> flightListButton = flightList.findElements(By.tagName("button"));
        flightListButton.get(1).click();
    }

    @And("^user fills the login data$")
    public void userFillsTheBookAsAGuestData() {
        WebElement guestForm = driver.findElement(By.id("loginform"));
        List<WebElement> loginFormInput = guestForm.findElements(By.tagName("input"));
        loginFormInput.get(0).sendKeys("maksmazur17@tlen.pl");
        loginFormInput.get(1).sendKeys("Valencia1");
    }

    @And("^user fills the Billing Address data$")
    public void userFillsTheBillingAddressData() {
        WebElement billingAddress = driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[1]/div/div/div[1]/div[2]/div/form/div[2]/div[1]/div"));
        List<WebElement> billingAddressInput = billingAddress.findElements(By.tagName("input"));
        billingAddressInput.get(0).sendKeys("Ewa");
        billingAddressInput.get(1).sendKeys("Mazur");
        billingAddressInput.get(2).sendKeys("przykladowymail@gmail.com");
        billingAddressInput.get(3).sendKeys("750215354");
        billingAddressInput.get(4).sendKeys("1970-06-05");
        billingAddressInput.get(5).sendKeys("ZS0000177");
        billingAddressInput.get(6).sendKeys("2021-05-05");
    }

    @And("^user fills the payment types$")
    public void userFillsThePaymentTypes() {
        WebElement paymentCardField = driver.findElement(By.className("payment-desc"));
        List<WebElement> paymentCardInput = paymentCardField.findElements(By.tagName("input"));
        paymentCardInput.get(0).sendKeys("82102052260000610204177895");
        paymentCardInput.get(1).sendKeys("133");
        WebElement cardType = driver.findElement(By.id("cardtype"));
        new Select(cardType).selectByVisibleText("MasterCard");
        WebElement expirationDate = driver.findElement(By.id("expiry-month"));
        new Select(expirationDate).selectByValue("07");
        WebElement expirationYear = driver.findElement(By.id("expiry-year"));
        new Select(expirationYear).selectByValue("2022");
    }

    @And("^user selects a checkbox with Rules&Restrictions and availability checking$")
    public void userSelectsACheckboxWithRulesRestrictionsAndAvailabilityChecking() {
        driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[1]/div/div/div[1]/div[2]/div/form/div[5]/label")).click();
        driver.findElement(By.id("confirmBooking")).click();
    }
}

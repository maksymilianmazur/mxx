package cucumber.test.KalendarzOplatyMocowej;
import cucumber.api.java.en.And;
import cucumber.test.SelectMenu;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.Calendar;
import java.util.List;
import java.util.Random;
import static org.junit.Assert.assertEquals;
public class KalendarzEdycjaUstawyMocowej {

    protected WebDriver driver;

    public KalendarzEdycjaUstawyMocowej(SelectMenu selectMenu) {
        this.driver = selectMenu.getDriver();
    }

    @And("^uzytkownik ustawia uprawnienia dotyczące edycji kalendarza dla uzytkownika na (.*) 'Edycja Ustawy Mocowej'$")
    public void uzytkownikUstawiaUprawnieniaDotycząceEdycjiKalendarzaDlaUzytkownikaNaEdycjaUstawyMocowej(String login) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("view-wrapper")));
        WebElement userList = driver.findElement(By.name("user-list"));
        userList.clear();
        userList.sendKeys(login + Keys.ENTER);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tabs-area")));
        WebElement tabsArea = driver.findElement(By.id("tabs-area"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("tab")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("view-wrapper")));
        List<WebElement> listTabArea = tabsArea.findElements(By.className("tab"));
        wait.until(ExpectedConditions.elementToBeClickable(listTabArea.get(1)));
        listTabArea.get(1).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("user-permission")));
        WebElement checkBoxSuperuzytkownik = driver.findElement(By.id("SUPERUSER"));
        WebElement checkBoxSuperEdycjaUstawyMocowej = driver.findElement(By.id("CAPACITY_CHARGE_MANAGEMENT"));
        WebElement checkBoxSuperuzytkownikZaawEdycjaUstawyMocowej = driver.findElement(By.id("CAPACITY_CHARGE_SUPER_MANAGEMENT"));
        if (checkBoxSuperuzytkownik.isSelected()) {
            checkBoxSuperuzytkownik.click();
        }

        if (!checkBoxSuperEdycjaUstawyMocowej.isSelected()) {
            checkBoxSuperEdycjaUstawyMocowej.click();
        }

        if (checkBoxSuperuzytkownikZaawEdycjaUstawyMocowej.isSelected()) {
            checkBoxSuperuzytkownikZaawEdycjaUstawyMocowej.click();
        }

        driver.findElement(By.id("save-user-settings")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("view-2-wrapper")));
        //driver.navigate().back();
        driver.get("https://cbpdev.energa.loc/ami/PpeList.go");
    }

    @And("^uzytkownik edytuje godziny mocowe zgodnie ze swoimi uprawnieniami$")
    public void uzytkownikEdytujeGodzinyMocoweZgodnieZeSwoimiUprawnieniami() {
        Calendar cal = Calendar.getInstance();
        long year = cal.get(Calendar.YEAR);
        Random random = new Random();
        int randomInteger = random.nextInt(11);
        int randomInteger2 = random.nextInt(699);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("edit-panel")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("calendar-wrapper")));
        driver.findElement(By.id("toolBtn")).click();
        WebElement spinnerContainerGear = driver.findElement(By.className("spinnerContainer"));
        List<WebElement> spinnerElementGear = spinnerContainerGear.findElements(By.className("spinnerElement"));
        spinnerElementGear.get(1).click();
        List<WebElement> spinnerElementGearUsed = spinnerContainerGear.findElements(By.className("used"));
        assertEquals(spinnerElementGearUsed.size(),1);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("calendar-wrapper")));
        WebElement monthMenuPanel = driver.findElement(By.className("o-menu-panel--list"));//wybor miesiaca
        List<WebElement> monthMenuList = monthMenuPanel.findElements(By.tagName("div"));
        monthMenuList.get(randomInteger).click();
        Select yearSelect = new Select(driver.findElement(By.id("year-select"))); //wybor roku
        yearSelect.selectByValue(String.valueOf(year + 1));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("calendar-wrapper")));//wybor dnia oraz godziny
        List<WebElement> tbodyMonths = driver.findElements(By.tagName("tbody"));
        List<WebElement> tdDaysHours = tbodyMonths.get(randomInteger).findElements(By.className(".o-capacity-charge-calendar--col"));
        tdDaysHours.get(randomInteger2).click();
    }

    @And("^uzytkownik potwierdza wprowadzone zmiany$")
    public void uzytkownikPotwierdzaWprowadzoneZmiany() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-panel-simple")));
        WebElement saveButtonZone = driver.findElement(By.id("button-panel-simple"));
        WebElement saveButton = saveButtonZone.findElement(By.tagName("button"));
        saveButton.click();
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        alert.getText();
        assertEquals(alert.getText(),"Zapisano");
        alert.accept();
    }

}

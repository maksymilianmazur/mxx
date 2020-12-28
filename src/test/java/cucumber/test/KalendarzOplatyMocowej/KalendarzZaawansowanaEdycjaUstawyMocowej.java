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

public class KalendarzZaawansowanaEdycjaUstawyMocowej {

    protected WebDriver driver;
    public KalendarzZaawansowanaEdycjaUstawyMocowej(SelectMenu selectMenu) {
        this.driver = selectMenu.getDriver();
    }

    @And("^uzytkownik ustawia uprawnienia edycji kalendarza dla uzytkownika (.*) na 'Zaawansowana Edycja Ustawy Mocowej'$")
    public void uzytkownikUstawiaUprawnieniaDotycząceMożliwościEdycjiKalendarzaDlaUzytkownikaZNaZaawansowanaEdycjaUstawyMocowej(String login){
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

        if (checkBoxSuperEdycjaUstawyMocowej.isSelected()) {
            checkBoxSuperEdycjaUstawyMocowej.click();
        }

        if (!checkBoxSuperuzytkownikZaawEdycjaUstawyMocowej.isSelected()) {
            checkBoxSuperuzytkownikZaawEdycjaUstawyMocowej.click();
        }

        driver.findElement(By.id("save-user-settings")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("view-2-wrapper")));
        //driver.navigate().back();
        driver.get("https://cbpdev.energa.loc/ami/PpeList.go");
    }


    @And("^uzytkownik edytuje godziny mocowe w przyszłości zgodnie ze swoimi uprawnieniami$")
    public void uzytkownikEdytujeGodzinyMocoweWPrzyszłościZgodnieZeSwoimiUprawnieniami() {

        Calendar cal = Calendar.getInstance();
        long year = cal.get(Calendar.YEAR);
        Random random = new Random();
        int randomInteger2 = random.nextInt(480)+100;
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("edit-panel")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("calendar-wrapper")));
        driver.findElement(By.id("toolBtn")).click();
        WebElement spinnerContainerGear = driver.findElement(By.className("spinnerContainer"));
        List<WebElement> spinnerElementGear = spinnerContainerGear.findElements(By.className("spinnerElement"));
        List<WebElement> spinnerElementGearUsed = spinnerContainerGear.findElements(By.className("used"));
        assertEquals(spinnerElementGearUsed.size(),1);
        spinnerElementGear.get(2).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("calendar-wrapper")));
        WebElement monthMenuPanel = driver.findElement(By.className("o-menu-panel--list"));//wybor miesiaca
        List<WebElement> monthMenuList = monthMenuPanel.findElements(By.tagName("div"));
        monthMenuList.get(1).click();
        Select yearSelect = new Select(driver.findElement(By.id("year-select"))); //wybor roku
        yearSelect.selectByValue(String.valueOf(year));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("calendar-wrapper")));//wybor dnia oraz godziny
        List<WebElement> tbodyMonths = driver.findElements(By.tagName("tbody"));
        List<WebElement> tdDaysHours = tbodyMonths.get(1).findElements(By.className(".o-capacity-charge-calendar--col"));
        tdDaysHours.get(randomInteger2).click();
    }

    @And("^uzytkownik potwierdza wprowadzone zmiany w kalendarzu$")
    public void uzytkownikPotwierdzaWprowadzoneZmianyWKalendarzu() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-panel-advanced")));
        WebElement saveButtonZone = driver.findElement(By.id("button-panel-advanced"));
        WebElement saveButton = saveButtonZone.findElement(By.tagName("button"));
        saveButton.click();
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        alert.getText();
        assertEquals(alert.getText(),"Zapisanie spowoduje wysłanie korekt do wszystkich korekt, które obejmują poprawiany okres. Czy jesteś pewien?");
        alert.accept();
        wait.until(ExpectedConditions.alertIsPresent());
        alert.accept();
    }

}

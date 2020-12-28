package cucumber.test.OgolneObiekty;
import cucumber.api.java.en.And;
import cucumber.test.SelectMenu;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;
import java.util.Random;
public class ProcesorDanychTest {
    protected WebDriver driver;
    Random random = new Random();
    public ProcesorDanychTest(SelectMenu selectMenu) {
        this.driver = selectMenu.getDriver();
    }
    @And("^uzytkownik wybiera licznik wirtualny oraz przechodzi przez jego podzakladki$")
    public void uzytkownikWybieraLicznikWirtualnyOrazPrzechodziPrzezJegoPodzakladki() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        int randomInteger = random.nextInt(15);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("amiView-cell-contentContainer")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("viewContainer")));
        List<WebElement> listaLicznikowWirtualnych = driver.findElements(By.className("amiView-cell-contentContainer"));
        listaLicznikowWirtualnych.get(randomInteger).click();
        List<WebElement> listaPrzyciskow = driver.findElements(By.className("button"));
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("name")));
//        assertEquals(listaLicznikowWirtualnych.get(randomInteger).getText(),driver.findElement(By.id("name")).getAttribute("value"));

        for (int i = 0; i < listaPrzyciskow.size(); i++) {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("topSubMenu_properties")));
            listaPrzyciskow.get(i).click();
        }
    }

    @And("^uzytownik wybiera walidatory oraz przechodzi przez jego podzakladki$")
    public void uzytownikWybieraWalidatoryOrazPrzechodziPrzezJegoPodzakladki() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        driver.findElement(By.id("topMenuArea")).click();
        List<WebElement> spinnerElement = driver.findElements(By.className("spinnerElement"));
        spinnerElement.get(2).click();
        driver.findElement(By.id("_tab4")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("viewContainer")));
    }

    @And("^uzytkownik wybiera biblioteki oraz przechodzi przez jego podzakladki$")
    public void uzytkownikWybieraBibliotekiOrazPrzechodziPrzezJegoPodzakladki() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        driver.findElement(By.id("topMenuArea")).click();
        List<WebElement> spinnerElement = driver.findElements(By.className("spinnerElement"));
        spinnerElement.get(3).click();
        driver.findElement(By.id("tab4")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("viewContainer")));
    }
}

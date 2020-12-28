package cucumber.test.OgolneObiekty;
import cucumber.api.java.en.And;
import cucumber.test.SelectMenu;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;

public class HarmonogramTest {

    private WebDriver driver;
    public HarmonogramTest(SelectMenu selectMenu) {
        this.driver = selectMenu.getDriver();
    }
    @And("^uzytkownik wybiera harmonogram z listy$")
    public void uzytkownikWybieraHarmonogramZListy() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("amiView-dataTable-container")));
        WebElement PolelistaHarmonogramow = driver.findElement(By.className("amiView-dataTable"));
        List<WebElement> listaHarmonogramow = PolelistaHarmonogramow.findElements(By.tagName("a"));
        listaHarmonogramow.get(20).click();
    }

    @And("^uzytkownik przechodzi przez podzakladki harmonogramow$")
    public void uzytkownikPrzechodziPrzezPodzakladkiHarmonogramow() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("topAreaTabs")));
        WebElement fieldTopAreaTabs = driver.findElement(By.id("topAreaTabs"));
        List<WebElement> topAreaTabs = fieldTopAreaTabs.findElements(By.className("oneTab"));
        for(int i=0; i<topAreaTabs.size();i++)
        {
            topAreaTabs.get(i).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("details")));
        }
    }
}

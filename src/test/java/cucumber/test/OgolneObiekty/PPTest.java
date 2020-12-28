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

public class PPTest {
    private WebDriver driver;
    Random random = new Random();
    public PPTest(SelectMenu selectMenu) {
        this.driver = selectMenu.getDriver();
    }
    @And("^użytkownik wybiera PP z listy$")
    public void użytkownikWybieraPPZListy() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement searchParamField = driver.findElement(By.id("xSearchParam"));
        if (searchParamField.isDisplayed()) {
            WebElement closeSearchParamField = searchParamField.findElement(By.className("close"));
            closeSearchParamField.click();
        }

        for (int i = 0; i <3; i++) {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("topAreaTabs")));
            WebElement topAreaTabsFieldPP = driver.findElement(By.id("topAreaTabs"));
            List<WebElement> topAreaTabsPP = topAreaTabsFieldPP.findElements(By.tagName("div"));
            topAreaTabsPP.get(i).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("regularOffset")));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("amiView-contentContainer")));
        }
        List<WebElement> listaPP = driver.findElements(By.className("amiView-cell-contentContainer"));
        int randomInteger = random.nextInt(15);
        listaPP.get(randomInteger).click();
    }

    @And("^użytkownik otwiera podzakładki z PP$")
    public void użytkownikOtwieraPodzakładkiZPP() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("amiRightArea")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("topAreaTabs")));
        List<WebElement> listaPolePPTop = driver.findElements(By.className("oneTab"));
        listaPolePPTop.size();
        for (int i = 0; i < listaPolePPTop.size(); i++) {
            Thread.sleep(1000);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("amiRightArea")));
            listaPolePPTop.get(i).click();
        }
    }
}

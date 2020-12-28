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

public class PPETest {

    protected WebDriver driver;
    Random random = new Random();
    public PPETest(SelectMenu selectMenu) {
        this.driver = selectMenu.getDriver();
    }

    @And("^użytkownik wybiera PPE z listy$")
    public void użytkownikWybieraPPEZListy() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("amiView-dataTable-container")));
        int randomInteger = random.nextInt(20);
        WebElement searchParamField = driver.findElement(By.id("xSearchParam"));
        if (searchParamField.isDisplayed()) {
            WebElement closeSearchParamField = searchParamField.findElement(By.className("close"));
            closeSearchParamField.click();
        }
        List<WebElement> listaPPE = driver.findElements(By.className("amiView-cell-contentContainer"));
        listaPPE.get(randomInteger).click();
    }

    @And("^użytkownik otwiera podzakładki z PPE$")
    public void użytkownikOtwieraPodzakładkiZPPE() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("topAreaTabs")));
        WebElement polePPETop = driver.findElement(By.id("topAreaTabs"));
        List<WebElement> listaPolePPeTop = polePPETop.findElements(By.className("oneTab"));
        listaPolePPeTop.size();

        for (int i = 0; i < listaPolePPeTop.size(); i++) {
            Thread.sleep(1000);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("regularOffset")));
            listaPolePPeTop.get(i).click();
        }
    }

}

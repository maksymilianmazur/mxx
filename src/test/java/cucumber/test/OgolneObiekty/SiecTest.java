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

public class SiecTest {

    protected WebDriver driver;
    Random random = new Random();
    public SiecTest(SelectMenu selectMenu) {
        this.driver = selectMenu.getDriver();
    }


    @And("^użytkownik wybiera nazwe z listy$")
    public void użytkownikWybieraNazweZListy() {
        WebElement searchParamField = driver.findElement(By.id("xSearchParam"));
        if(searchParamField.isDisplayed())
        { WebElement closeSearchParamField = searchParamField.findElement(By.className("close"));
        closeSearchParamField.click();}
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("amiView-contentContainer")));
        List<WebElement> listaPodpunktow = driver.findElements(By.className("amiView-cell-contentContainer"));
        int randomInteger = random.nextInt(15);
        listaPodpunktow.get(randomInteger).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("amiRightArea")));
    }

    @And("^użytkownik otwiera podzakładki z Sieci$")
    public void użytkownikOtwieraPodzakładkiZSieci() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement topAreaTabsFieldNetwork2=driver.findElement(By.id("topAreaTabs"));
        List<WebElement> topAreaTabsNetwork2= topAreaTabsFieldNetwork2.findElements(By.tagName("div"));
        for(int i=0; i<topAreaTabsNetwork2.size();i++) {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("amiRightArea-top")));
            WebElement topAreaTabsFieldNetwork=driver.findElement(By.id("topAreaTabs"));
            List<WebElement> topAreaTabsNetwork= topAreaTabsFieldNetwork.findElements(By.tagName("div"));
            if(topAreaTabsNetwork.get(i).isDisplayed()) {
                topAreaTabsNetwork.get(i).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("viewManager")));}
        }
    }
}

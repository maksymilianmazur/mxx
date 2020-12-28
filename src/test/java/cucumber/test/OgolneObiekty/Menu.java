package cucumber.test.OgolneObiekty;
import cucumber.api.java.en.And;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;
public class Menu {

    private WebDriver driver;

    public Menu(Login login) {
        this.driver = login.getDriver();
    }

    @And("^użytkownik otwiera wszystkie zakładki$")
    public void użytkownikOtwieraWszystkieZakładki() {
        Actions builder = new Actions(driver);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        for (int i = 0; i < driver.findElements(By.className("amiMenuLeft-itemArea")).size(); i++) {
            if (driver.findElements(By.id("showMenu")).size() > 0 && driver.findElement(By.id("showMenu")).isDisplayed())
            {
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("amiRightArea")));
                WebElement showMenu = driver.findElement(By.id("showMenu"));
                builder.moveToElement(showMenu).perform();
                WebElement amiMenuLewaStrefa = driver.findElement(By.id("leftMenuArea"));
                List<WebElement> zakladki = amiMenuLewaStrefa.findElements(By.tagName("a"));
                zakladki.get(i).click();
            }
            else if ((driver.findElement(By.id("language-select")).isDisplayed()))
            {
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("menu-wrapper")));
                driver.navigate().back();
            }
        }
    }
}

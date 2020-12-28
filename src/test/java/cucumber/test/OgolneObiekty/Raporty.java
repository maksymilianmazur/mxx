package cucumber.test.OgolneObiekty;
import cucumber.api.java.en.And;
import cucumber.test.SelectMenu;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;

public class Raporty {
    protected WebDriver driver;

    public Raporty(SelectMenu selectMenu) {
        this.driver = selectMenu.getDriver();
    }
    @And("^użytkownik wybiera szablony$")
    public void użytkownikWybieraSzablony() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("topMenuArea")));
        driver.findElement(By.id("topMenuArea")).click();
        List<WebElement> spinnerElement = driver.findElements(By.className("spinnerElement"));
        spinnerElement.get(2).click();

        //List<WebElement> generowanieRap = driver.findElements(By.("spinnerElement"));
    }
}

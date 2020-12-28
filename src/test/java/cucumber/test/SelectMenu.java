package cucumber.test;

import cucumber.api.java.en.And;
import cucumber.test.OgolneObiekty.Login;
import klasyDodatkowe.MenuList;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class SelectMenu {
    protected WebDriver driver;

    public SelectMenu(Login login) {
        this.driver = login.getDriver();
    }

    @And("^uzytkownik wybiera opcje menu (.*)$")
    public void użytkownikOtwieraZakładkęPPE(String nazwa) {
        Actions builder = new Actions(driver);
        WebElement showMenu = driver.findElement(By.id("showMenu"));
        builder.moveToElement(showMenu).perform();
        WebElement amiMenuLewaStrefa = driver.findElement(By.id("leftMenuArea"));
        List<WebElement> zakladki = amiMenuLewaStrefa.findElements(By.tagName("a"));
        zakladki.get(MenuList.find(nazwa).getValue()).click();
    }

    public WebDriver getDriver() {
        return driver;
    }
}

package przyklad1;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.Random;
import java.util.ArrayList;
import java.util.List;

public class MyStoreTest {
    private WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/chromedriver");
        // Uruchom nowy egzemplarz przeglądarki Chrome
        driver = new ChromeDriver();
        // Zmaksymalizuj okno przeglądarki
        driver.manage().window().maximize();
        //otworzenie witryny www z formularzem
        driver.get("https://prod-kurs.coderslab.pl/index.php");
    }

    @Test
    public void myStoreValueCheck() throws InterruptedException {
        List<Integer> list = new ArrayList();
        list.add(0);
        list.add(3);
        list.add(6);


        chooseObject(getRandomElement(list)); // wywołanie funkcji z wartością ze zbioru {0,3,6}
        Thread.sleep(3000);
        if (getRandomElement(list) < 6) {
            WebElement filters = driver.findElement(By.xpath("/html/body/main/section/div/div[1]/div[2]/div[2]/section[4]"));
            List<WebElement> selectFilters = filters.findElements(By.tagName("input"));
            selectFilters.get(0).click();
        }
        else {
            WebElement filters2 = driver.findElement(By.xpath("/html/body/main/section/div/div[1]/div[2]/div[2]/section[1]"));
            List<WebElement> selectFilters2 = filters2.findElements(By.tagName("input"));
            selectFilters2.get(1).click();
        }

    }

    public int getRandomElement(List<Integer> list) {
        Random rand = new Random();
        return list.get(rand.nextInt(list.size()));
    }

    private void chooseObject(int index) {
        WebElement products = driver.findElement(By.className("js-top-menu"));
        List<WebElement> selectCategory = products.findElements(By.className("dropdown-item"));
        selectCategory.get(index).click();
    }


    @After
    public void tearDown() {
    }
}
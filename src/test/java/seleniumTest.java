
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class seleniumTest {
    private static io.github.bonigarcia.wdm.WebDriverManager WebDriverManager;
    private WebDriver driver;
    ChromeOptions options = new ChromeOptions();


    @BeforeAll
    static void setUpAll() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
    }

    @AfterEach
    void tearDown() {
        driver.quit();
        driver = null;
        driver = new ChromeDriver(options);
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--no-sandbox");
        options.addArguments("--headless");
    }
    @Test
     void test (){
driver.get("http://localhost:9999/");
driver.findElement(By.cssSelector("input[type='text']")).sendKeys("валерий данковцев");
driver.findElement(By.cssSelector("input[type='tel']")).sendKeys("+79295964548");
driver.findElement(By.tagName("label")).click();
driver.findElement(By.className("button__text")).click();
String actual ="  Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время.";
String expected = driver.findElement(By.tagName("p")).getText();
        Assertions.assertEquals(expected,actual);
    }

}




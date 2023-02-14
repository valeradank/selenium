
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SeleniumTest {


    static WebDriver driver;


    @BeforeAll
    static void setUpAll() {
        WebDriverManager.chromedriver().setup();

    }

    @BeforeEach
    void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--no-sandbox");
        options.addArguments("--headless");
        driver = new ChromeDriver(options);

    }

    @AfterEach
    void tearDown() {
        driver.quit();


    }

    @Test
    void test() {
        driver.get("http://localhost:9999/");
        driver.findElement(By.cssSelector("input[type='text']")).sendKeys("валерий данковцев");
        driver.findElement(By.cssSelector("input[type='tel']")).sendKeys("+79295964548");
        driver.findElement(By.tagName("label")).click();
        driver.findElement(By.className("button__text")).click();
        String actual = "  Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время.";
        String expected = driver.findElement(By.cssSelector("[data-test-id='order-success']")).getText();
        Assertions.assertEquals(expected, actual);
    }

}




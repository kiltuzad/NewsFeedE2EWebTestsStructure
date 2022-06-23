import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

abstract public class SetUp {

    @BeforeAll
    public static void setUpAllure() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    public void setUp() {
        WebDriverManager.safaridriver().setup();
        Configuration.browser= "safari";
        Configuration.driverManagerEnabled = true;
        Configuration.timeout = 10000;
       Configuration.headless = false;
    }
    @BeforeEach
    public void init(){
        setUp();
    }
    @AfterEach
    public void tearDown() {
        Selenide.closeWebDriver();
    }
}

// allure generate --clean --output /Users/dunice/Desktop/NewsFeedAutotests/allure-results
// allure serve -h localhost


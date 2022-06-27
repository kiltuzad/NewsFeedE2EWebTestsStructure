import com.beust.ah.A;
import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LoginTest extends SetUp {

    private final Account account = new Account();
    HeaderElements headerElements = new HeaderElements();
    private final static String HOME_URL ="https://news-feed-2.dunice-testing.com/";

    @Test
    public void loginTest() throws InterruptedException {
        HomePage homePage = new HomePage(HOME_URL);
        account.loginUser();
        Thread.sleep(2000);
        assertEquals(("Hello, sasa "), headerElements.helloHeader.getText());
    }

    @Test
    public void negativeLoginTest() throws InterruptedException {
        HomePage homePage = new HomePage(HOME_URL);
        account.negativeLoginUser();
        Thread.sleep(2000);
        account.negativeLogText.shouldBe(Condition.visible);
    }
}

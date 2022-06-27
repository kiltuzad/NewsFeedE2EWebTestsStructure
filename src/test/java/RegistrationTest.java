
import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RegistrationTest extends SetUp {

    private final Account account = new Account();
   private final HeaderElements headerElements = new HeaderElements();
    private final static String HOME_URL ="https://news-feed-2.dunice-testing.com/";

    @Test
    public void registrationTest() throws InterruptedException {
        HomePage homePage = new HomePage(HOME_URL);
        account.registrationUser();
        Thread.sleep(3000);
        assertEquals(("Hello, "+account.loginText+" "), headerElements.getHelloHeader().getText());
    }

    @Test
    public void negativeRegistrationTest() throws InterruptedException {
        HomePage homePage = new HomePage(HOME_URL);
        account.negativeRegistrationUser();
        Thread.sleep(3000);
        account.negativeRegText.shouldBe(Condition.visible);
    }
}


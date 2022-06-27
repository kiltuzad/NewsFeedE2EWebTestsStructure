import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DeleteUserTest extends SetUp {
    private final Account account = new Account();
    private final HeaderElements headerElements = new HeaderElements();
    private final static String HOME_URL ="https://news-feed-2.dunice-testing.com/";

    @Test
    public  void deleteUserTest() throws InterruptedException {
        HomePage homePage = new HomePage(HOME_URL);
        account.registrationUser();
        Thread.sleep(3000);
        assertEquals(("Hello, "+account.loginText+" "), headerElements.getHelloHeader().getText());
        account.getMyProfile().shouldBe(Condition.visible).click();
        account.deleteUser();
        assertEquals(("Hello, "+" "), headerElements.getHelloHeader().getText());
    }

    @Test
    public void negativeDeleteUserTest() throws InterruptedException {
        HomePage homePage = new HomePage(HOME_URL);
        account.registrationUser();
        Thread.sleep(3000);
        assertEquals(("Hello, "+account.loginText+" "), headerElements.getHelloHeader().getText());
        account.getMyProfile().shouldBe(Condition.visible).click();
        account.negativeDeleteUser();
        assertEquals(("Hello, "+account.loginText+" "), headerElements.getHelloHeader().getText());
    }
}

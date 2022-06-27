import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UpdateProfileTest extends SetUp{
    private final Account account = new Account();
    private final HeaderElements headerElements = new HeaderElements();
    private final static String HOME_URL ="https://news-feed-2.dunice-testing.com/";

    @Test
    public void updateProfileTest() throws InterruptedException {
        HomePage homePage = new HomePage(HOME_URL);
        account.registrationUser();
        Thread.sleep(3000);
        assertEquals(("Hello, "+account.loginText+" "), headerElements.getHelloHeader().getText());
        account.getMyProfile().shouldBe(Condition.visible).click();
        account.updateProfile();
        Thread.sleep(2000);
        assertEquals(("Hello, "+account.newUpdateNameText+" "), headerElements.getHelloHeader().getText());
    }

    @Test
    public void negativeUpdateProfileTest() throws InterruptedException {
        HomePage homePage = new HomePage(HOME_URL);
        account.registrationUser();
        Thread.sleep(3000);
        assertEquals(("Hello, "+account.loginText+" "), headerElements.getHelloHeader().getText());
        account.getMyProfile().shouldBe(Condition.visible).click();
        account.negativeUpdateProfile();
        Thread.sleep(1000);
        account.negativeText.shouldBe(Condition.visible);
    }
}

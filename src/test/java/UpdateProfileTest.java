import com.codeborne.selenide.Condition;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UpdateProfileTest extends SetUp{
    private final Account account = new Account();
    private final HeaderElements headerElements = new HeaderElements();
    private final static String HOME_URL ="https://news-feed-2.dunice-testing.com/";

    @Epic(value = "Account.")
    @Feature("Действия с акаунтом.")
    @Story("Правильное обновление информации.")
    @Description(value = "updateProfileTest.")
    @Test
    public void updateProfileTest() throws InterruptedException {
        HomePage homePage = new HomePage(HOME_URL);
        account.registrationUser();
        assertEquals(("Hello, "+account.loginText+" "), headerElements.getHelloHeader().getText());
        account.getMyProfile().shouldBe(Condition.visible).click();
        account.updateProfile();
        assertEquals(("Hello, "+account.newUpdateNameText+" "), headerElements.getHelloHeader().getText(),"Не валидный логин или email");
    }

    @Epic(value = "Account.")
    @Feature("Действия с акаунтом.")
    @Story("Не правильное обновление информации.")
    @Description(value = "negativeUpdateProfileTest.")
    @Test
    public void negativeUpdateProfileTest() throws InterruptedException {
        HomePage homePage = new HomePage(HOME_URL);
        account.registrationUser();
        assertEquals(("Hello, "+account.loginText+" "), headerElements.getHelloHeader().getText());
        account.getMyProfile().shouldBe(Condition.visible).click();
        account.negativeUpdateProfile();
        account.negativeText.shouldBe(Condition.visible);
        assertEquals(account.negativeText.getText(), "unknown" ,"Валидный email");
    }
}

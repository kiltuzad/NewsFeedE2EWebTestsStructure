import com.codeborne.selenide.Condition;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DeleteUserTest extends SetUp {
    private final Account account = new Account();
    private final HeaderElements headerElements = new HeaderElements();
    private final static String HOME_URL ="https://news-feed-2.dunice-testing.com/";

    @Epic(value = "Account.")
    @Feature("Действия с акаунтом.")
    @Story("Правильное удаление пользователя.")
    @Description(value = "deleteUserTest.")
    @Test
    public  void deleteUserTest() throws InterruptedException {
        HomePage homePage = new HomePage(HOME_URL);
        account.registrationUser();
        assertEquals(("Hello, "+account.loginText+" "), headerElements.getHelloHeader().getText());
        account.getMyProfile().shouldBe(Condition.visible).click();
        account.deleteUser();
        assertEquals(("Hello, "+" "), headerElements.getHelloHeader().getText(),"Профиль не удалён");
    }

    @Epic(value = "Account.")
    @Feature("Действия с акаунтом.")
    @Story("Не правильное удаление пользователя.")
    @Description(value = "negativeDeleteUserTest.")
    @Test
    public void negativeDeleteUserTest() throws InterruptedException {
        HomePage homePage = new HomePage(HOME_URL);
        account.registrationUser();
        assertEquals(("Hello, "+account.loginText+" "), headerElements.getHelloHeader().getText());
        account.getMyProfile().shouldBe(Condition.visible).click();
        account.negativeDeleteUser();
        assertEquals(("Hello, "+account.loginText+" "), headerElements.getHelloHeader().getText(),"Профиль удалён");
    }
}

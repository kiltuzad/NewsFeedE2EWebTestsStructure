import com.beust.ah.A;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class LoginTest extends SetUp {

    private final Account account = new Account();
    HeaderElements headerElements = new HeaderElements();
    private final static String HOME_URL ="https://news-feed-2.dunice-testing.com/";

    @Epic(value = "Account.")
    @Feature("Действия с акаунтом.")
    @Story("Правильная авторизация.")
    @Description(value = "Войти в акаунт.")
    @Test
    public void loginTest() throws InterruptedException {
        HomePage homePage = new HomePage(HOME_URL);
        account.loginUser();
        assertEquals(("Hello, sasa "), headerElements.helloHeader.getText(), "Не валидный логин");
    }

    @Epic(value = "Account.")
    @Feature("Действия с акаунтом.")
    @Story("Не правильная авторизация.")
    @Description(value = "Войти в акаунт.")
    @Test
    public void negativeLoginTest() throws InterruptedException {
        HomePage homePage = new HomePage(HOME_URL);
        account.negativeLoginUser();
        account.negativeLogText.shouldBe(Condition.visible);
        assertEquals(account.negativeLogText.getText(), "Could not find user" , "Прфиль уже существует");
    }
}

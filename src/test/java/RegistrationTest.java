
import com.codeborne.selenide.Condition;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RegistrationTest extends SetUp {

    private final Account account = new Account();
   private final HeaderElements headerElements = new HeaderElements();
    private final static String HOME_URL ="https://news-feed-2.dunice-testing.com/";

    @Epic(value = "Account.")
    @Feature("Действия с акаунтом.")
    @Story("Правильная регистрация.")
    @Description(value = "registrationTest.")
    @Test
    public void registrationTest() throws InterruptedException {
        HomePage homePage = new HomePage(HOME_URL);
        account.registrationUser();
        assertEquals(("Hello, "+account.loginText+" "), headerElements.getHelloHeader().getText(),"Не валидная регистрация");
    }

    @Epic(value = "Account.")
    @Feature("Действия с акаунтом.")
    @Story("Не правильная регистрация.")
    @Description(value = "negativeRegistrationTest.")
    @Test
    public void negativeRegistrationTest() throws InterruptedException {
        HomePage homePage = new HomePage(HOME_URL);
        account.negativeRegistrationUser();
        account.negativeRegText.shouldBe(Condition.visible);
        assertEquals(account.negativeRegText.getText(), "user email must be a well-formed email address" ,"Валидная регистрация");
    }
}


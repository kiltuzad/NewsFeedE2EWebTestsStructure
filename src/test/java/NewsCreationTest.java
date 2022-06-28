import com.codeborne.selenide.Condition;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NewsCreationTest extends SetUp{
    private final Account account = new Account();
    private final Posts posts = new Posts();
    private final HeaderElements headerElements = new HeaderElements();
    private final static String HOME_URL ="https://news-feed-2.dunice-testing.com/";

    @Epic(value = "Posts.")
    @Feature("Действия с новостью.")
    @Story("Правильное добавление новости.")
    @Description(value = "newsCreationTest.")
    @Test
    public void newsCreationTest() throws InterruptedException {
        HomePage homePage = new HomePage(HOME_URL);
        account.registrationUser();
        assertEquals(("Hello, "+account.loginText+" "), headerElements.getHelloHeader().getText());
        account.getMyProfile().shouldBe(Condition.visible).click();
        posts.addNewPost();
        posts.getNewPostTest().shouldNot(Condition.visible);
    }

    @Epic(value = "Posts.")
    @Feature("Действия с новостью.")
    @Story("Не правильное добавление новости.")
    @Description(value = "negativeNewsCreationTest.")
    @Test
    public void negativeNewsCreationTest() throws InterruptedException {
        HomePage homePage = new HomePage(HOME_URL);
        account.registrationUser();
        assertEquals(("Hello, "+account.loginText+" "), headerElements.getHelloHeader().getText());
        account.getMyProfile().shouldBe(Condition.visible).click();
        posts.negativeAddNewPost();
        posts.negativeText.shouldBe(Condition.visible);
    }
}

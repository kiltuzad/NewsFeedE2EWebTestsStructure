import com.codeborne.selenide.Condition;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GetPostTest extends SetUp {
    private final Posts posts = new Posts();
    private final Account account = new Account();
    private final HeaderElements headerElements = new HeaderElements();
    private final static String HOME_URL ="https://news-feed-2.dunice-testing.com/";

    @Epic(value = "Posts.")
    @Feature("Действия с новостью.")
    @Story("Правильный поиск новости.")
    @Description(value = "getPostTest.")
    @Test
    public void getPostTest() throws InterruptedException {
        HomePage homePage = new HomePage(HOME_URL);
        account.registrationUser();
        assertEquals(("Hello, "+account.loginText+" "), headerElements.getHelloHeader().getText());
        account.getMyProfile().shouldBe(Condition.visible).click();
        posts.addNewPost();
        headerElements.getNewsFeeds().shouldBe(Condition.visible).click();
        posts.getPost();
        posts.getVoidNewsSearch().shouldBe(Condition.visible);
        assertTrue(posts.getVoidNewsSearch().shouldBe(Condition.visible).isDisplayed(), "Новость не найдена");
    }
    @Epic(value = "Posts.")
    @Feature("Действия с новостью.")
    @Story("Не правильный поиск новости.")
    @Description(value = "negativeGetPostTest.")
    @Test
    public void negativeGetPostTest() throws InterruptedException {
        HomePage homePage = new HomePage(HOME_URL);
        account.registrationUser();
        assertEquals(("Hello, "+account.loginText+" "), headerElements.getHelloHeader().getText());
        account.getMyProfile().shouldBe(Condition.visible).click();
        posts.addNewPost();
        headerElements.getNewsFeeds().shouldBe(Condition.visible).click();
        posts.negativeGetPost();
        posts.getVoidNewsSearch().shouldNotBe(Condition.visible);
        assertFalse(posts.getVoidNewsSearch().shouldNotBe(Condition.visible).isDisplayed(), "Новость найдена");
    }
}

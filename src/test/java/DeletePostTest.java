import com.codeborne.selenide.Condition;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DeletePostTest extends SetUp {
    private final Account account = new Account();
    private final HeaderElements headerElements = new HeaderElements();
    private final Posts posts = new Posts();
    private final static String HOME_URL ="https://news-feed-2.dunice-testing.com/";

    @Epic(value = "Posts.")
    @Feature("Действия с новостью.")
    @Story("Правильное удаление новости.")
    @Description(value = "deletePostTest.")
    @Test
    public void deletePostTest() throws InterruptedException {
        HomePage homePage = new HomePage(HOME_URL);
        account.registrationUser();
        assertEquals(("Hello, "+account.loginText+" "), headerElements.getHelloHeader().getText());
        account.getMyProfile().shouldBe(Condition.visible).click();
        posts.addNewPost();
        posts.deletePost();
        posts.getNewPostTest().shouldNot(Condition.visible);
    }
    @Epic(value = "Posts.")
    @Feature("Действия с новостью.")
    @Story("Не правильное удаление новости.")
    @Description(value = "negativeDeletePostTest.")
    @Test
    public void negativeDeletePostTest() throws InterruptedException {
        HomePage homePage = new HomePage(HOME_URL);
        account.registrationUser();
        assertEquals(("Hello, "+account.loginText+" "), headerElements.getHelloHeader().getText());
        account.getMyProfile().shouldBe(Condition.visible).click();
        posts.addNewPost();
        posts.negativeDeletePost();
        posts.newPostTest.shouldBe(Condition.visible);
    }
}

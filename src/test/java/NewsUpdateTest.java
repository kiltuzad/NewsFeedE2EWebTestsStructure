import com.codeborne.selenide.Condition;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class NewsUpdateTest extends SetUp{
    private final Posts posts = new Posts();
    private final Account account = new Account();
    private final HeaderElements headerElements = new HeaderElements();
    private final static String HOME_URL ="https://news-feed-2.dunice-testing.com/";
    @Epic(value = "Posts.")
    @Feature("Действия с новостью.")
    @Story("Правильное обновление новости.")
    @Description(value = "newsUpdateTest.")
    @Test
    public void newsUpdateTest() throws InterruptedException {
        HomePage homePage = new HomePage(HOME_URL);
        account.registrationUser();
        assertEquals(("Hello, "+account.loginText+" "), headerElements.getHelloHeader().getText());
        account.getMyProfile().shouldBe(Condition.visible).click();
        posts.addNewPost();
        posts.updateNews();
        assertNotEquals((posts.newsUpdateTitle), posts.newsCreationsTitle);
    }
    @Epic(value = "Posts.")
    @Feature("Действия с новостью.")
    @Story("Не правильное обнавление новости.")
    @Description(value = "negativeNewsUpdateTest.")
    @Test
    public void negativeNewsUpdateTest() throws InterruptedException {
        HomePage homePage = new HomePage(HOME_URL);
        account.registrationUser();
        assertEquals(("Hello, "+account.loginText+" "), headerElements.getHelloHeader().getText());
        account.getMyProfile().shouldBe(Condition.visible).click();
        posts.addNewPost();
        posts.negativeUpdateNews();
        posts.negativeText.shouldBe(Condition.visible);
    }
}

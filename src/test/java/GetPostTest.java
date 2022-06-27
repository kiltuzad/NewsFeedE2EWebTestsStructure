import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GetPostTest extends SetUp {
    private final Posts posts = new Posts();
    private final Account account = new Account();
    private final HeaderElements headerElements = new HeaderElements();
    private final static String HOME_URL ="https://news-feed-2.dunice-testing.com/";

    @Test
    public void getPostTest() throws InterruptedException {
        HomePage homePage = new HomePage(HOME_URL);
        account.registrationUser();
        Thread.sleep(3000);
        assertEquals(("Hello, "+account.loginText+" "), headerElements.getHelloHeader().getText());
        account.getMyProfile().shouldBe(Condition.visible).click();
        posts.addNewPost();
        headerElements.getNewsFeeds().shouldBe(Condition.visible).click();
        posts.getPost();
        posts.getVoidNewsSearch().shouldBe(Condition.visible);
    }

    @Test
    public void negativeGetPostTest() throws InterruptedException {
        HomePage homePage = new HomePage(HOME_URL);
        account.registrationUser();
        Thread.sleep(3000);
        assertEquals(("Hello, "+account.loginText+" "), headerElements.getHelloHeader().getText());
        account.getMyProfile().shouldBe(Condition.visible).click();
        posts.addNewPost();
        headerElements.getNewsFeeds().shouldBe(Condition.visible).click();
        posts.negativeGetPost();
        posts.getVoidNewsSearch().shouldNotBe(Condition.visible);
    }
}

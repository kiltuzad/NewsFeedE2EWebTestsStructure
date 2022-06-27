import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DeletePostTest extends SetUp {
    private final Account account = new Account();
    private final HeaderElements headerElements = new HeaderElements();
    private final Posts posts = new Posts();
    private final static String HOME_URL ="https://news-feed-2.dunice-testing.com/";

    @Test
    public void deletePostTest() throws InterruptedException {
        HomePage homePage = new HomePage(HOME_URL);
        account.registrationUser();
        Thread.sleep(3000);
        assertEquals(("Hello, "+account.loginText+" "), headerElements.getHelloHeader().getText());
        account.getMyProfile().shouldBe(Condition.visible).click();
        posts.addNewPost();
        posts.deletePost();
        posts.getNewPostTest().shouldNot(Condition.visible);
    }

    @Test
    public void negativeDeletePostTest() throws InterruptedException {
        HomePage homePage = new HomePage(HOME_URL);
        account.registrationUser();
        Thread.sleep(3000);
        assertEquals(("Hello, "+account.loginText+" "), headerElements.getHelloHeader().getText());
        account.getMyProfile().shouldBe(Condition.visible).click();
        posts.addNewPost();
        posts.negativeDeletePost();
        posts.newPostTest.shouldBe(Condition.visible);
    }
}

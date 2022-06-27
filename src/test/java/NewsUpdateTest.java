import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class NewsUpdateTest extends SetUp{
    private final Posts posts = new Posts();
    private final Account account = new Account();
    private final HeaderElements headerElements = new HeaderElements();
    private final static String HOME_URL ="https://news-feed-2.dunice-testing.com/";

    @Test
    public void newsUpdteTest() throws InterruptedException {
        HomePage homePage = new HomePage(HOME_URL);
        account.registrationUser();
        Thread.sleep(3000);
        assertEquals(("Hello, "+account.loginText+" "), headerElements.getHelloHeader().getText());
        account.getMyProfile().shouldBe(Condition.visible).click();
        posts.addNewPost();
        posts.updateNews();
        Thread.sleep(2000);
        assertNotEquals((posts.newsUpdateTitle), posts.newsCreationsTitle);
    }

    @Test
    public void negativeNewsUpdateTest() throws InterruptedException {
        HomePage homePage = new HomePage(HOME_URL);
        account.registrationUser();
        Thread.sleep(3000);
        assertEquals(("Hello, "+account.loginText+" "), headerElements.getHelloHeader().getText());
        account.getMyProfile().shouldBe(Condition.visible).click();
        posts.addNewPost();
        posts.negativeUpdateNews();
        Thread.sleep(1000);
        posts.negativeText.shouldBe(Condition.visible);
    }
}

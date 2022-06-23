import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class NewsUpdateTest extends SetUp{
    Methods methods = new Methods();
    private final static String HOME_URL ="https://news-feed-2.dunice-testing.com/";

    @Test
    public void newsUpdteTest() throws InterruptedException {
        HomePage homePage = new HomePage(HOME_URL);
        methods.registrationUser();
        methods.myProfile();
        methods.addNewPost();
        methods.updateNews();
        Thread.sleep(2000);
        assertNotEquals((methods.newsUpdateTitle), methods.newsCreationsTitle);
    }

    @Test
    public void negativeNewsUpdateTest() throws InterruptedException {
        HomePage homePage = new HomePage(HOME_URL);
        methods.registrationUser();
        methods.myProfile();
        methods.addNewPost();
        methods.negativeUpdateNews();
    }
}

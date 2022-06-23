import org.junit.jupiter.api.Test;

public class NewsCreationTest extends SetUp{
    Methods methods = new Methods();
    private final static String HOME_URL ="https://news-feed-2.dunice-testing.com/";

    @Test
    public void newsCreationTest() throws InterruptedException {
        HomePage homePage = new HomePage(HOME_URL);
        methods.registrationUser();
        methods.myProfile();
        methods.addNewPost();
    }

    @Test
    public void negativeNewsCreationTest() throws InterruptedException {
        HomePage homePage = new HomePage(HOME_URL);
        methods.registrationUser();
        methods.myProfile();
        methods.negativeAddNewPost();
    }
}

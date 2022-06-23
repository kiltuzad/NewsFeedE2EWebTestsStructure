import org.junit.jupiter.api.Test;

class LoginTest extends SetUp {

    Methods methods = new Methods();
    private final static String HOME_URL ="https://news-feed-2.dunice-testing.com/";

    @Test
    public void loginTest() throws InterruptedException {
        HomePage homePage = new HomePage(HOME_URL);
        methods.loginUser();
    }

    @Test
    public void negativeLoginTest() throws InterruptedException {
        HomePage homePage = new HomePage(HOME_URL);
        methods.negativeLoginUser();
    }
}

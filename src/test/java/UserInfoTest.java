import org.junit.jupiter.api.Test;

public class UserInfoTest extends SetUp {
    Methods methods = new Methods();
    private final static String HOME_URL ="https://news-feed-2.dunice-testing.com/";
    @Test
    public void userInfoTest() throws InterruptedException {
        HomePage homePage = new HomePage(HOME_URL);
        methods.registrationUser();
        methods.myProfile();
    }
}

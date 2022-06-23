import org.junit.jupiter.api.Test;

public class UpdateProfileTest extends SetUp{
    Methods methods = new Methods();
    private final static String HOME_URL ="https://news-feed-2.dunice-testing.com/";

    @Test
    public void updateProfileTest() throws InterruptedException {
        HomePage homePage = new HomePage(HOME_URL);
        methods.registrationUser();
        methods.myProfile();
        methods.updateProfile();
    }

    @Test
    public void negativeUpdateProfileTest() throws InterruptedException {
        HomePage homePage = new HomePage(HOME_URL);
        methods.registrationUser();
        methods.myProfile();
        methods.negativeUpdateProfile();
    }
}

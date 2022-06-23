
import org.junit.jupiter.api.Test;

class RegistrationTest extends SetUp {

    private final Methods methods = new Methods();
    private final static String HOME_URL ="https://news-feed-2.dunice-testing.com/";

    @Test
    public void registrationTest() throws InterruptedException {
        HomePage homePage = new HomePage(HOME_URL);
        methods.registrationUser();
    }

    @Test
    public void negativeRegistrationTest() throws InterruptedException {
        HomePage homePage = new HomePage(HOME_URL);
        methods.negativeRegistrationUser();
    }
}


import org.junit.jupiter.api.Test;

public class GetPostTest extends SetUp {
    private final Methods methods = new Methods();
    private final static String HOME_URL ="https://news-feed-2.dunice-testing.com/";

    @Test
    public void getPostTest() throws InterruptedException {
        HomePage homePage = new HomePage(HOME_URL);
        methods.registrationUser();
        methods.myProfile();
        methods.addNewPost();
        methods.getPost();
    }

    @Test
    public void negativeGetPostTest() throws InterruptedException {
        HomePage homePage = new HomePage(HOME_URL);
        methods.registrationUser();
        methods.myProfile();
        methods.addNewPost();
        methods.negativeGetPost();
    }
}

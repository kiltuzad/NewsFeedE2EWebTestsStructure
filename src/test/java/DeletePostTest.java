import org.junit.jupiter.api.Test;

public class DeletePostTest extends SetUp {
    private final Methods methods = new Methods();
    private final static String HOME_URL ="https://news-feed-2.dunice-testing.com/";

    @Test
    public void deletePostTest() throws InterruptedException {
        HomePage homePage = new HomePage(HOME_URL);
        methods.registrationUser();
        methods.myProfile();
        methods.addNewPost();
        methods.deletePost();
    }

    @Test
    public void negativeDeletePostTest() throws InterruptedException {
        HomePage homePage = new HomePage(HOME_URL);
        methods.registrationUser();
        methods.myProfile();
        methods.addNewPost();
        methods.negativeDeletePost();
    }
}

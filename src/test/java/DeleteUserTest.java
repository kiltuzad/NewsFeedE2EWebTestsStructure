import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class DeleteUserTest extends SetUp {
    private final Methods methods = new Methods();
    private final HeaderElements headerElements = new HeaderElements();
    private final static String HOME_URL ="https://news-feed-2.dunice-testing.com/";

    @Test
    public  void deleteUserTest() throws InterruptedException {
        HomePage homePage = new HomePage(HOME_URL);
        methods.registrationUser();
        methods.myProfile();
        methods.deleteUser();
        assertEquals(("Hello, "+" "), headerElements.helloHeader.getText());
    }

    @Test
    public void negativeDeleteUserTest() throws InterruptedException {
        HomePage homePage = new HomePage(HOME_URL);
        methods.registrationUser();
        methods.myProfile();
        methods.negativeDeleteUser();
        assertEquals(("Hello, "+methods.loginText+" "), headerElements.helloHeader.getText());
    }
}

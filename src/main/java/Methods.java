import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import java.io.File;
import java.util.Random;
import static org.junit.jupiter.api.Assertions.*;

public class Methods {

    private final LoginPage loginPage = new LoginPage();
    private final HeaderElements headerElements = new HeaderElements();
    private final Registration registration = new Registration();
    private final UserInfo userInfo = new UserInfo();
    private final UpdateProfile updateProfile = new UpdateProfile();
    private final DeleteUser deleteUser = new DeleteUser();
    private final NewsCreation newsCreation = new NewsCreation();
    private final NewsUpdate newsUpdate = new NewsUpdate();
    private final DeletePost deletePost = new DeletePost();
    private final GetPost getPost = new GetPost();

    String loginText;
    String newsCreationsTitle;
    String newsCreationsTags;
    String newsUpdateTitle;
    // random string generation
    public static String generateRandomHexString (int length){
        Random r = new Random();
        StringBuffer sb = new StringBuffer();
        while(sb.length() < length){
            sb.append(Integer.toHexString(r.nextInt()));
        }
        return sb.toString().substring(0, length);
    }
    public void registrationUser() throws InterruptedException {
        headerElements.enterButton.shouldBe(Condition.visible).click();
        registration.registrationB.shouldBe(Condition.visible);
        registration.emailReg.sendKeys(Methods.generateRandomHexString(5) + "@gmail.com");
        registration.loginReg.sendKeys(Methods.generateRandomHexString(5));
        loginText = registration.loginReg.getAttribute("value");
        registration.passwordReg.sendKeys(Methods.generateRandomHexString(6));
        String avatarPath = "src/main/resources/avatar.jpeg";
        File file = new File(new File(avatarPath).getAbsolutePath());
        registration.avatarReg.sendKeys(file.getAbsolutePath());
        registration.submitRegButton.click();
        headerElements.helloHeader.shouldBe(Condition.visible);
        Thread.sleep(3000);
        assertEquals(("Hello, "+loginText+" "), headerElements.helloHeader.getText());
    }
    public void negativeRegistrationUser() throws InterruptedException {
        headerElements.enterButton.shouldBe(Condition.visible).click();
        registration.registrationB.shouldBe(Condition.visible);
        registration.emailReg.sendKeys(Methods.generateRandomHexString(8));
        registration.loginReg.sendKeys(Methods.generateRandomHexString(5));
        loginText = registration.loginReg.getAttribute("value");
        registration.passwordReg.sendKeys(Methods.generateRandomHexString(6));
        String avatarPath = "src/main/resources/avatar.jpeg";
        File file = new File(new File(avatarPath).getAbsolutePath());
        registration.avatarReg.sendKeys(file.getAbsolutePath());
        registration.submitRegButton.click();
        headerElements.helloHeader.shouldBe(Condition.visible);
        Thread.sleep(3000);
        registration.negativeText.shouldBe(Condition.visible);
    }

    public void loginUser() throws InterruptedException {
        loginPage.email.shouldBe(Condition.visible).click();
        loginPage.email.sendKeys("sasa@gmail.ru");
        loginPage.password.shouldBe(Condition.visible).click();
        loginPage.password.sendKeys("123456");
        headerElements.homeButton.click();
        Thread.sleep(2000);
        assertEquals(("Hello, sasa "), headerElements.helloHeader.getText());
    }
    public void  negativeLoginUser() throws InterruptedException {
        loginPage.email.shouldBe(Condition.visible).click();
        loginPage.email.sendKeys(Methods.generateRandomHexString(10) + "@gmail.com");
        loginPage.password.shouldBe(Condition.visible).click();
        loginPage.password.sendKeys(Methods.generateRandomHexString(6));
        headerElements.homeButton.click();
        Thread.sleep(2000);
        loginPage.negativeText.shouldBe(Condition.visible);
    }

    public void myProfile() throws InterruptedException {
        userInfo.myProfile.shouldBe(Condition.visible).click();
        Thread.sleep(500);
    }

    public void updateProfile() throws InterruptedException {
        updateProfile.update.shouldBe(Condition.visible).click();
        updateProfile.updateProfileText.shouldBe(Condition.visible);
        updateProfile.newUpdateEmail.sendKeys(Methods.generateRandomHexString(5) + "@gmail.com");
        updateProfile.newUpdateName.sendKeys(Methods.generateRandomHexString(5));
        String newUpdateNameText = updateProfile.newUpdateName.getAttribute("value");
        updateProfile.saveUpdate.shouldBe(Condition.visible).click();
        Thread.sleep(1000);
        assertEquals(("Hello, "+newUpdateNameText+" "), headerElements.helloHeader.getText());
    }

    public void negativeUpdateProfile() throws InterruptedException {
        updateProfile.update.shouldBe(Condition.visible).click();
        updateProfile.updateProfileText.shouldBe(Condition.visible);
        updateProfile.newUpdateEmail.sendKeys(Methods.generateRandomHexString(5));
        updateProfile.newUpdateName.sendKeys(Methods.generateRandomHexString(5));
        String newUpdateNameText = updateProfile.newUpdateName.getAttribute("value");
        updateProfile.saveUpdate.shouldBe(Condition.visible).click();
        Thread.sleep(1000);
        updateProfile.negativeText.shouldBe(Condition.visible);
    }

    public void addNewPost() throws InterruptedException {
        newsCreation.userPostText.shouldBe(Condition.visible);
        newsCreation.newPost.shouldBe(Condition.visible).click();
        newsCreation.addNewPostText.shouldBe(Condition.visible);
        newsCreation.titlePost.sendKeys(Methods.generateRandomHexString(8));
        newsCreationsTitle = newsCreation.titlePost.getAttribute("value");
        newsCreation.postPost.sendKeys(Methods.generateRandomHexString(15));
        String newsCat = "src/main/resources/OrnyiCat.jpg";
        File file = new File(new File(newsCat).getAbsolutePath());
        newsCreation.picturePost.sendKeys(file.getAbsolutePath());
        newsCreation.tagPost.sendKeys(Methods.generateRandomHexString(10));
        newsCreationsTags = newsCreation.tagPost.getAttribute("value");
        newsCreation.savePost.shouldBe(Condition.visible).click();
        Thread.sleep(1000);
    }

    public void negativeAddNewPost() throws InterruptedException {
        newsCreation.userPostText.shouldBe(Condition.visible);
        newsCreation.newPost.shouldBe(Condition.visible).click();
        newsCreation.addNewPostText.shouldBe(Condition.visible);
        newsCreation.titlePost.sendKeys(" ");
        newsCreation.postPost.sendKeys(Methods.generateRandomHexString(15));
        String newsCat = "src/main/resources/OrnyiCat.jpg";
        File file = new File(new File(newsCat).getAbsolutePath());
        newsCreation.picturePost.sendKeys(file.getAbsolutePath());
        newsCreation.tagPost.sendKeys(Methods.generateRandomHexString(5));
        newsCreation.savePost.shouldBe(Condition.visible).click();
        Thread.sleep(1000);
        newsCreation.negativeText.shouldBe(Condition.visible);
    }

    public void updateNews() throws InterruptedException {
        newsUpdate.newPostTest.shouldBe(Condition.visible);
        newsUpdate.postUpdate.shouldBe(Condition.visible).click();
        newsUpdate.updatePostText.shouldBe(Condition.visible);
        newsUpdate.updateTitle.sendKeys(Methods.generateRandomHexString(8));
        newsUpdateTitle = newsUpdate.updateTitle.getAttribute("value");
        newsUpdate.updatePost.sendKeys(Methods.generateRandomHexString(12));
        newsUpdate.updateTags.sendKeys(Methods.generateRandomHexString(5));
        Thread.sleep(1000);
        newsUpdate.updateSave.shouldBe(Condition.visible).click();
    }

    public void negativeUpdateNews() throws InterruptedException {newsUpdate.newPostTest.shouldBe(Condition.visible);
        newsUpdate.postUpdate.shouldBe(Condition.visible).click();
        newsUpdate.updatePostText.shouldBe(Condition.visible);
        newsUpdate.updateTitle.sendKeys(Methods.generateRandomHexString(8));
        newsUpdateTitle = newsUpdate.updateTitle.getAttribute("value");
        newsUpdate.updatePost.sendKeys(Methods.generateRandomHexString(12));
        newsUpdate.updateTags.doubleClick();
        newsUpdate.updateTags.sendKeys(" ");
        newsUpdate.updateSave.shouldBe(Condition.visible).click();
        Thread.sleep(1000);
        newsUpdate.negativeText.shouldBe(Condition.visible);
    }

    public void deletePost(){
        deletePost.newPostTest.shouldBe(Condition.visible);
        deletePost.deleteNewPost.shouldBe(Condition.visible).click();
        deletePost.newPostTest.shouldNot(Condition.visible);
    }

    public void negativeDeletePost(){
        deletePost.newPostTest.shouldBe(Condition.visible);
        deletePost.postUpdate.shouldBe(Condition.visible).click();
        deletePost.updatePostText.shouldBe(Condition.visible);
        deletePost.closeUpdatePost.shouldBe(Condition.visible).click();
        deletePost.newPostTest.shouldBe(Condition.visible);
    }

    public void getPost(){
        headerElements.newsFeeds.shouldBe(Condition.visible).click();
        getPost.selectNewsFeedsSearch.shouldBe(Condition.visible).click();
        getPost.optionSelectNewsFeedsSearch.shouldBe(Condition.visible).click();
        getPost.newsFeedsSearch.shouldBe(Condition.visible).click();
        getPost.newsFeedsSearch.sendKeys(newsCreationsTags);
        getPost.search.shouldBe(Condition.visible).click();
        getPost.voidNewsSearch.shouldBe(Condition.visible);
    }

    public void negativeGetPost() {
        headerElements.newsFeeds.shouldBe(Condition.visible).click();
        getPost.selectNewsFeedsSearch.shouldBe(Condition.visible).click();
        getPost.optionSelectNewsFeedsSearch.shouldBe(Condition.visible).click();
        getPost.newsFeedsSearch.shouldBe(Condition.visible).click();
        getPost.newsFeedsSearch.sendKeys(Methods.generateRandomHexString(10));
        getPost.search.shouldBe(Condition.visible).click();
        getPost.voidNewsSearch.shouldNotBe(Condition.visible);
    }

    public void deleteUser() throws InterruptedException {
        deleteUser.deleteProfile.shouldBe(Condition.visible).click();
        Thread.sleep(2000);
        Selenide.switchTo().alert().accept();
        headerElements.newsFeeds.shouldBe(Condition.visible).click();
    }

    public void negativeDeleteUser() throws InterruptedException {
        deleteUser.deleteProfile.shouldBe(Condition.visible).click();
        Selenide.switchTo().alert().dismiss();
        Thread.sleep(2000);
        headerElements.newsFeeds.shouldBe(Condition.visible).click();
    }

}

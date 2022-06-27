import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.io.File;

import static com.codeborne.selenide.Selenide.$;

public class Account {
    HeaderElements headerElements = new HeaderElements();

    String loginText;
    String newUpdateNameText;

    //registration
    SelenideElement registrationB= $(By.xpath("//div[text()='Registration']"));
    SelenideElement emailReg = $(By.xpath("//input[@name='emailReg']"));
    SelenideElement loginReg = $(By.xpath("//input[@name='loginReg']"));
    SelenideElement passwordReg = $(By.xpath("//input[@name='passwordReg']"));
    SelenideElement avatarReg = $(By.xpath("//input[@name='avatar']"));
    SelenideElement submitRegButton = $(By.xpath("//button[text()='Save']"));
    //negative registration
    SelenideElement negativeRegText = $(By.xpath("//div[contains(text(),'user email must be a well-formed')]"));

    // login
    SelenideElement email = $(By.xpath("//input[@id='formBasicEmail']"));
    SelenideElement password = $(By.xpath("//input[@id='formBasicPassword']"));
    //negative login
    SelenideElement negativeLogText = $(By.xpath("//div[contains(text(),'Could not find')]"));
    //user info
    SelenideElement myProfile = $(By.xpath("//a[text()='My profile']"));

    //update profile
    SelenideElement update = $(By.xpath("//button[text()='Update']"));
    SelenideElement updateProfileText = $(By.xpath("//div[text()='Update Profile']"));
    SelenideElement newUpdateEmail = $(By.xpath("//input[@placeholder='Enter new e-mail']"));
    SelenideElement newUpdateName = $(By.xpath("//input[@placeholder='Enter new name']"));
    SelenideElement saveUpdate = $(By.xpath("//button[@type='submit']"));
    //negative update profile
    SelenideElement negativeText = $(By.xpath("//div[contains(text(),'unknow')]"));

    //delete user
    SelenideElement deleteProfile = $(By.xpath("//button[text()='Delete profile']"));

    public SelenideElement getRegistrationB() {
        return registrationB;
    }

    public SelenideElement getEmailReg() {
        return emailReg;
    }

    public SelenideElement getLoginReg() {
        return loginReg;
    }

    public SelenideElement getPasswordReg() {
        return passwordReg;
    }

    public SelenideElement getAvatarReg() {
        return avatarReg;
    }

    public SelenideElement getSubmitRegButton() {
        return submitRegButton;
    }

    public SelenideElement getNegativeRegText() {
        return negativeRegText;
    }

    public SelenideElement getEmail() {
        return email;
    }

    public SelenideElement getPassword() {
        return password;
    }

    public SelenideElement getNegativeLogText() {
        return negativeLogText;
    }

    public SelenideElement getMyProfile() {
        return myProfile;
    }

    public SelenideElement getUpdate() {
        return update;
    }

    public SelenideElement getUpdateProfileText() {
        return updateProfileText;
    }

    public SelenideElement getNewUpdateEmail() {
        return newUpdateEmail;
    }

    public SelenideElement getNewUpdateName() {
        return newUpdateName;
    }

    public SelenideElement getSaveUpdate() {
        return saveUpdate;
    }

    public SelenideElement getNegativeText() {
        return negativeText;
    }

    public SelenideElement getDeleteProfile() {
        return deleteProfile;
    }

    public void loginUser() {
        getEmail().shouldBe(Condition.visible).click();
        email.setValue("sasa@gmail.ru");
        getPassword().shouldBe(Condition.visible).click();
        password.setValue("123456");
        headerElements.getHomeButton().click();
    }

    public void  negativeLoginUser() throws InterruptedException {
        getEmail().shouldBe(Condition.visible).click();
        email.setValue(Methods.generateRandomHexString(10) + "@gmail.com");
        getPassword().shouldBe(Condition.visible).click();
        password.setValue(Methods.generateRandomHexString(6));
        headerElements.getHomeButton().click();
    }

    public void registrationUser() throws InterruptedException {
        headerElements.getEnterButton().shouldBe(Condition.visible).click();
        getRegistrationB().shouldBe(Condition.visible);
        emailReg.setValue(Methods.generateRandomHexString(5) + "@gmail.com");
        loginReg.setValue(Methods.generateRandomHexString(5));
        loginText = loginReg.getAttribute("value");
        passwordReg.setValue(Methods.generateRandomHexString(6));
        String avatarPath = "src/main/resources/avatar.jpeg";
        File file = new File(new File(avatarPath).getAbsolutePath());
        avatarReg.setValue(file.getAbsolutePath());
        getSubmitRegButton().click();
        headerElements.getHelloHeader().shouldBe(Condition.visible);
    }

    public void negativeRegistrationUser() {
        headerElements.getEnterButton().shouldBe(Condition.visible).click();
        getRegistrationB().shouldBe(Condition.visible);
        emailReg.setValue(Methods.generateRandomHexString(7));
        loginReg.setValue(Methods.generateRandomHexString(5));
        loginText = loginReg.getAttribute("value");
        passwordReg.setValue(Methods.generateRandomHexString(6));
        String avatarPath = "src/main/resources/avatar.jpeg";
        File file = new File(new File(avatarPath).getAbsolutePath());
        avatarReg.setValue(file.getAbsolutePath());
        getSubmitRegButton().click();
    }

    public void updateProfile() {
        getUpdate().shouldBe(Condition.visible).click();
        getUpdateProfileText().shouldBe(Condition.visible);
        newUpdateEmail.setValue(Methods.generateRandomHexString(5) + "@gmail.com");
        newUpdateName.setValue(Methods.generateRandomHexString(5));
        newUpdateNameText = newUpdateName.getAttribute("value");
        getSaveUpdate().shouldBe(Condition.visible).click();
    }

    public void negativeUpdateProfile() throws InterruptedException {
        getUpdate().shouldBe(Condition.visible).click();
        getUpdateProfileText().shouldBe(Condition.visible);
        newUpdateEmail.setValue(Methods.generateRandomHexString(5));
        newUpdateName.setValue(Methods.generateRandomHexString(5));
        newUpdateNameText = newUpdateName.getAttribute("value");
        getSaveUpdate().shouldBe(Condition.visible).click();
    }
    public void deleteUser() throws InterruptedException {
        getDeleteProfile().shouldBe(Condition.visible).click();
        Thread.sleep(2000);
        Selenide.switchTo().alert().accept();
        headerElements.getNewsFeeds().shouldBe(Condition.visible).click();
    }
    public void negativeDeleteUser() throws InterruptedException {
        getDeleteProfile().shouldBe(Condition.visible).click();
        Selenide.switchTo().alert().dismiss();
        Thread.sleep(2000);
        headerElements.newsFeeds.shouldBe(Condition.visible).click();
    }
}

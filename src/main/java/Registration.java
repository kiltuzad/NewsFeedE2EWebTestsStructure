import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class Registration {
    private final static String HOME_URL ="https://news-feed-2.dunice-testing.com/";
    SelenideElement registrationB= $(By.xpath("//div[text()='Registration']"));
    SelenideElement emailReg = $(By.xpath("//input[@name='emailReg']"));
    SelenideElement loginReg = $(By.xpath("//input[@name='loginReg']"));
    SelenideElement passwordReg = $(By.xpath("//input[@name='passwordReg']"));
    SelenideElement avatarReg = $(By.xpath("//input[@name='avatar']"));
    SelenideElement submitRegButton = $(By.xpath("//button[text()='Save']"));

    //negative
    SelenideElement negativeText = $(By.xpath("//div[contains(text(),'user email must be a well-formed')]"));
}

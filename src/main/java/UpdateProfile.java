import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class UpdateProfile {
    SelenideElement update = $(By.xpath("//button[text()='Update']"));
    SelenideElement updateProfileText = $(By.xpath("//div[text()='Update Profile']"));
    SelenideElement newUpdateEmail = $(By.xpath("//input[@placeholder='Enter new e-mail']"));
    SelenideElement newUpdateName = $(By.xpath("//input[@placeholder='Enter new name']"));
    SelenideElement saveUpdate = $(By.xpath("//button[@type='submit']"));
    //negative
    SelenideElement negativeText = $(By.xpath("//div[contains(text(),'unknow')]"));

}

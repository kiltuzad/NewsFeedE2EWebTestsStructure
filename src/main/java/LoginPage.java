import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage {

    SelenideElement authTitle = $(By.xpath("//button[contains(text(),'Log In')]"));
    SelenideElement regTitle = $(By.xpath("//button[contains(text(),'Sign Up')]"));

    // login
    SelenideElement email = $(By.xpath("//input[@id='formBasicEmail']"));
    SelenideElement password = $(By.xpath("//input[@id='formBasicPassword']"));

    //negative
    SelenideElement negativeText = $(By.xpath("//div[contains(text(),'Could not find')]"));



}

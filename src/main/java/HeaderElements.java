import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class HeaderElements {
    SelenideElement enterButton = $(By.xpath("//button[contains(text(),'Sign Up')]"));
    SelenideElement homeButton = $(By.xpath("//button[contains(text(),'Log In')]"));
    SelenideElement newsFeeds = $(By.xpath("//a[text()='Newsfeeds']"));
    SelenideElement quitButton = $(By.cssSelector("#tool-bar__logout"));

    SelenideElement helloHeader = $(By.xpath("//div[@class='Header_header__greetings__3WI4_'] "));

}

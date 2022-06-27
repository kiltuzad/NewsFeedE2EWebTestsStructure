import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class HeaderElements {
    SelenideElement enterButton = $(By.xpath("//button[contains(text(),'Sign Up')]"));
    SelenideElement homeButton = $(By.xpath("//button[contains(text(),'Log In')]"));
    SelenideElement newsFeeds = $(By.xpath("//a[text()='Newsfeeds']"));
    SelenideElement helloHeader = $(By.xpath("//div[@class='Header_header__greetings__3WI4_'] "));

    public SelenideElement getEnterButton() {
        return enterButton;
    }

    public SelenideElement getHomeButton() {
        return homeButton;
    }

    public SelenideElement getNewsFeeds() {
        return newsFeeds;
    }

    public SelenideElement getHelloHeader() {
        return helloHeader;
    }

}

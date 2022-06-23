import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class DeletePost {
    SelenideElement newPostTest = $(By.xpath("//img[@alt ='news image']/.."));
    SelenideElement deleteNewPost = $(By.xpath("//button[text()='Delete']"));

    //negative
    SelenideElement postUpdate = $(By.xpath("//img[@alt ='news image']/..//button[text()='Update']"));
    SelenideElement closeUpdatePost = $(By.xpath("//button[text()='Close']"));
    SelenideElement updatePostText = $(By.xpath("//div[text()='Update post']"));
}

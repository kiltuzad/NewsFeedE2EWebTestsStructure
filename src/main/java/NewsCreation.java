import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class NewsCreation {
    SelenideElement userPostText = $(By.xpath("//div[contains(text(),'User post')]"));
    SelenideElement newPost = $(By.xpath("//button[text()='New Post']"));
    SelenideElement addNewPostText = $(By.xpath("//div[text()='Add new post']"));
    SelenideElement titlePost = $(By.xpath("//input[@name='title']"));
    SelenideElement postPost = $(By.xpath("//textarea[@name='body']"));
    SelenideElement picturePost = $(By.xpath("//input[@name='picture']"));
    SelenideElement tagPost = $(By.xpath("//input[@name='tags']"));
    SelenideElement savePost = $(By.xpath("//button[@type='submit']"));

    //negative
    SelenideElement negativeText = $(By.xpath("//div[contains(text(),'TAGS_NOT')]"));

}

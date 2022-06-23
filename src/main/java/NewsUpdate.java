import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class NewsUpdate {
    SelenideElement newPostTest = $(By.xpath("//img[@alt ='news image']/.."));
    SelenideElement postUpdate = $(By.xpath("//img[@alt ='news image']/..//button[text()='Update']"));
    SelenideElement updatePostText = $(By.xpath("//div[text()='Update post']"));
    SelenideElement updateTitle = $(By.xpath("//input[@name='title']"));
    SelenideElement updatePost = $(By.xpath("//textarea[@name='body']"));
    SelenideElement updateTags = $(By.xpath("//input[@name='tags']"));
    SelenideElement updateSave = $(By.xpath("//button[@type='submit']"));

    //negative
    SelenideElement negativeText = $(By.xpath("//div[contains(text(),'TAGS_NOT')]"));
}

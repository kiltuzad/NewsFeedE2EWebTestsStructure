import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class GetPost {
    SelenideElement selectNewsFeedsSearch = $(By.xpath("//select[@name='select']"));
    SelenideElement optionSelectNewsFeedsSearch = $(By.xpath("//option[@value='tags']"));
    SelenideElement newsFeedsSearch = $(By.xpath("//input[@name='search']"));
    SelenideElement search =$(By.xpath("//button[text()='Search']"));
    //negative
    SelenideElement voidNewsSearch = $(By.xpath("//div[contains(@class,'Search_')]/following-sibling::div"));
}

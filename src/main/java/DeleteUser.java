import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class DeleteUser {
    SelenideElement deleteProfile = $(By.xpath("//button[text()='Delete profile']"));
}

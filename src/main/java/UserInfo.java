import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;

public class UserInfo {
    SelenideElement myProfile = $(By.xpath("//a[text()='My profile']"));

}

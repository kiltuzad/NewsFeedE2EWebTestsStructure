import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
public class AccountPage {

    SelenideElement deleteUser = $(By.xpath("//*[@id=\"remove-user-btn\"]/span[1]"));

}

import com.codeborne.selenide.Selenide;

public class HomePage {
    public HomePage(String url){
        Selenide.open(url);
    }
}

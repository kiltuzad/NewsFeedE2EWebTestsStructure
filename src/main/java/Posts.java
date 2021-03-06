import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class Posts {
    String newsUpdateTitle;
    String newsCreationsTitle;
    String newsCreationsTags;
    String tTitlePostText;
    SelenideElement userPostText = $(By.xpath("//div[contains(text(),'User post')]"));
    SelenideElement newPost = $(By.xpath("//button[text()='New Post']"));
    SelenideElement addNewPostText = $(By.xpath("//div[text()='Add new post']"));
    SelenideElement titlePost = $(By.xpath("//input[@name='title']"));
    SelenideElement postPost = $(By.xpath("//textarea[@name='body']"));
    SelenideElement picturePost = $(By.xpath("//input[@name='picture']"));
    SelenideElement tagPost = $(By.xpath("//input[@name='tags']"));
    SelenideElement savePost = $(By.xpath("//button[@type='submit']"));
    SelenideElement titlePostText = $(By.xpath("//*[@id=\"root\"]/div/div/div[2]/div[4]/div/div[1]/div[1]"));
    //negative
    SelenideElement negativeText = $(By.xpath("//div[contains(text(),'TAGS_NOT')]"));

    //news update
    SelenideElement newPostTest = $(By.xpath("//img[@alt ='news image']/.."));
    SelenideElement postUpdate = $(By.xpath("//img[@alt ='news image']/..//button[text()='Update']"));
    SelenideElement updatePostText = $(By.xpath("//div[text()='Update post']"));
    SelenideElement updateTitle = $(By.xpath("//input[@name='title']"));
    SelenideElement updatePost = $(By.xpath("//textarea[@name='body']"));
    SelenideElement updateTags = $(By.xpath("//input[@name='tags']"));
    SelenideElement updateSave = $(By.xpath("//button[@type='submit']"));

    //delete post
    SelenideElement deleteNewPost = $(By.xpath("//button[text()='Delete']"));
    //negative delete post
    SelenideElement closeUpdatePost = $(By.xpath("//button[text()='Close']"));

    //get post
    SelenideElement selectNewsFeedsSearch = $(By.xpath("//select[@name='select']"));
    SelenideElement optionSelectNewsFeedsSearch = $(By.xpath("//option[@value='tags']"));
    SelenideElement newsFeedsSearch = $(By.xpath("//input[@name='search']"));
    SelenideElement search =$(By.xpath("//button[text()='Search']"));
    //negative get post
    SelenideElement voidNewsSearch = $(By.xpath("//div[contains(@class,'Search_')]/following-sibling::div"));

    //pagination
    ElementsCollection newsPosts = $$(By.xpath("//*[@id='root']/div/main/div[2]/div"));

    public SelenideElement getUserPostText() {
        return userPostText;
    }

    public SelenideElement getTitlePostText(){
       return titlePostText;
    }

    public SelenideElement getNewPost() {
        return newPost;
    }

    public SelenideElement getAddNewPostText() {
        return addNewPostText;
    }

    public SelenideElement getTitlePost() {
        return titlePost;
    }

    public SelenideElement getPostPost() {
        return postPost;
    }

    public SelenideElement getPicturePost() {
        return picturePost;
    }

    public SelenideElement getTagPost() {
        return tagPost;
    }

    public SelenideElement getSavePost() {
        return savePost;
    }

    public SelenideElement getNegativeText() {
        return negativeText;
    }
    public SelenideElement getNewPostTest() {
        return newPostTest;
    }

    public SelenideElement getPostUpdate() {
        return postUpdate;
    }

    public SelenideElement getUpdatePostText() {
        return updatePostText;
    }

    public SelenideElement getUpdateTitle() {
        return updateTitle;
    }

    public SelenideElement getUpdatePost() {
        return updatePost;
    }

    public SelenideElement getUpdateTags() {
        return updateTags;
    }

    public SelenideElement getUpdateSave() {
        return updateSave;
    }
    public SelenideElement getDeleteNewPost() {
        return deleteNewPost;
    }
    public SelenideElement getCloseUpdatePost() {
        return closeUpdatePost;
    }
    public SelenideElement getSelectNewsFeedsSearch() {
        return selectNewsFeedsSearch;
    }

    public SelenideElement getOptionSelectNewsFeedsSearch() {
        return optionSelectNewsFeedsSearch;
    }

    public SelenideElement getNewsFeedsSearch() {
        return newsFeedsSearch;
    }

    public SelenideElement getSearch() {
        return search;
    }

    public SelenideElement getVoidNewsSearch() {
        return voidNewsSearch;
    }

    public void addNewPost() throws InterruptedException {
        getUserPostText().shouldBe(Condition.visible);
        getNewPost().shouldBe(Condition.visible).click();
        getAddNewPostText().shouldBe(Condition.visible);
        titlePost.setValue(Methods.generateRandomHexString(8));
        newsCreationsTitle = titlePost.getAttribute("value");
        postPost.setValue(Methods.generateRandomHexString(15));
        String newsCat = "src/main/resources/OrnyiCat.jpg";
        File file = new File(new File(newsCat).getAbsolutePath());
        picturePost.setValue(file.getAbsolutePath());
        tagPost.setValue(Methods.generateRandomHexString(10));
        newsCreationsTags = tagPost.getAttribute("value");
        getSavePost().shouldBe(Condition.visible).click();
    }
    public void negativeAddNewPost() throws InterruptedException {
        getUserPostText().shouldBe(Condition.visible);
        getNewPost().shouldBe(Condition.visible).click();
        getAddNewPostText().shouldBe(Condition.visible);
        titlePost.setValue(" ");
        newsCreationsTitle = titlePost.getAttribute("value");
        postPost.setValue(Methods.generateRandomHexString(15));
        String newsCat = "src/main/resources/OrnyiCat.jpg";
        File file = new File(new File(newsCat).getAbsolutePath());
        picturePost.setValue(file.getAbsolutePath());
        tagPost.setValue(Methods.generateRandomHexString(10));
        newsCreationsTags = tagPost.getAttribute("value");
        getSavePost().shouldBe(Condition.visible).click();
    }
    public void updateNews() throws InterruptedException {
        getNewPostTest().shouldBe(Condition.visible);
        getPostUpdate().shouldBe(Condition.visible).click();
        getUpdatePostText().shouldBe(Condition.visible);
        updateTitle.setValue(Methods.generateRandomHexString(8));
        newsUpdateTitle = updateTitle.getAttribute("value");
        updatePost.setValue(Methods.generateRandomHexString(12));
        updateTags.setValue(Methods.generateRandomHexString(5));
        Thread.sleep(1000);
        getUpdateSave().shouldBe(Condition.visible).click();
    }
    public void negativeUpdateNews(){
        getNewPostTest().shouldBe(Condition.visible);
        getPostUpdate().shouldBe(Condition.visible).click();
        getUpdatePostText().shouldBe(Condition.visible);
        updateTitle.setValue(Methods.generateRandomHexString(8));
        newsUpdateTitle = updateTitle.getAttribute("value");
        updatePost.setValue(Methods.generateRandomHexString(12));
        getUpdateTags().shouldBe(Condition.visible).doubleClick();
        updateTags.setValue(" ");
        getUpdateSave().shouldBe(Condition.visible).click();
    }

    public void deletePost(){
        getNewPostTest().shouldBe(Condition.visible);
        getDeleteNewPost().shouldBe(Condition.visible).click();
    }

    public void negativeDeletePost(){
        newPostTest.shouldBe(Condition.visible);
        postUpdate.shouldBe(Condition.visible).click();
        updatePostText.shouldBe(Condition.visible);
        closeUpdatePost.shouldBe(Condition.visible).click();
    }
    public void getPost(){
        getSelectNewsFeedsSearch().shouldBe(Condition.visible).click();
        getOptionSelectNewsFeedsSearch().shouldBe(Condition.visible).click();
        getNewsFeedsSearch().shouldBe(Condition.visible).click();
        newsFeedsSearch.setValue(newsCreationsTags);
        getSearch().shouldBe(Condition.visible).click();
    }
    public void negativeGetPost() {
        getSelectNewsFeedsSearch().shouldBe(Condition.visible).click();
        getOptionSelectNewsFeedsSearch().shouldBe(Condition.visible).click();
        getNewsFeedsSearch().shouldBe(Condition.visible).click();
        newsFeedsSearch.setValue(Methods.generateRandomHexString(10));
        getSearch().shouldBe(Condition.visible).click();
    }

    public void paginationPost(){
        List<Object> newsPostsList = new ArrayList<>();
        for(int i = 0; i<200; i++){
            newsPostsList.add((newsPosts.get(i).scrollIntoView(true).getText()));
        }
    }

}

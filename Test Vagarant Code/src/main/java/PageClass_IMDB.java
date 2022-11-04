import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageClass_IMDB extends BaseObjectClass{

    public PageClass_IMDB(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@type='text']")
    WebElement inputSrchIMDB;

    @FindBy(xpath = "//a[@data-testid='search-result--const']")
    WebElement btnSrch;

    @FindBy(xpath = "//li[@data-testid='title-details-releasedate']/div")
    WebElement txtReleaseDt;

    @FindBy(xpath = "//li[@data-testid='title-details-origin']/div")
    WebElement txtCountry;

    public void enterAndSearchMovie(String movie){
        inputSrchIMDB.sendKeys(movie);
        waitBox(btnSrch,3000);
        btnSrch.click();
    }

    public String fetchReleaseDate(){
        return txtReleaseDt.getText();
    }

    public String fetchCountry(){
        return txtCountry.getText();
    }

}

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageClass_Wiki extends BaseObjectClass{

    public PageClass_Wiki(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@id='searchInput']")
    WebElement inputSrchWiki;

    @FindBy(xpath = "//button[@class='pure-button pure-button-primary-progressive']")
    WebElement btnSrch;

    @FindBy(xpath = "//th/div[text()='Release date']//following::div")
    WebElement txtReleaseDt;

    @FindBy(xpath = "//th[text()='Country']//following::td")
    WebElement txtCountry;

    public void enterAndSearchMovie(String movie){
        inputSrchWiki.sendKeys(movie);
        btnSrch.click();
    }

    public String fetchReleaseDate(){
        return txtReleaseDt.getText();
    }

    public String fetchCountry(){
        return txtCountry.getText();
    }

}

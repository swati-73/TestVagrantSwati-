import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

public class BaseObjectClass {
    public WebDriver driver;

    public void launchURL(String url){

        try {
            driver.get(url);
        } catch (Exception e) {
            System.out.println("Exception in method launchURL: " + e.toString());
        }
    }

    //waitForElement
    public void waitBox(WebElement element, int timeout){
        try {
            driver.manage().timeouts().implicitlyWait(timeout,TimeUnit.SECONDS);
//            WebDriverWait wait = new WebDriverWait(driver, timeout);
//            wait.until(ExpectedConditions.visibilityOf(element));

        }
        catch (Exception e){
            System.out.println("Exception in method waitBox: "+e.toString());
            Assert.fail();
        }
    }

    public boolean checkDate(String wikiDate, String imdbDate){

        String[] dt=wikiDate.split(" ");
        String temp="";

        for (int i = 0; i <dt.length ; i++) {

            temp=dt[1]+ " "+dt[0]+", "+dt[2];

        }
        System.out.println(temp);
        return imdbDate.contains(temp);

    }


}

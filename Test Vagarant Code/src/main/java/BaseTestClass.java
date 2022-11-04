import com.sun.org.apache.bcel.internal.classfile.Code;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class BaseTestClass {

    public WebDriver driver;
    @BeforeSuite
    public void beforeSuite(){
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
    }
    @BeforeMethod
    public void beforeMethod(Method method) {

        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }

    @AfterMethod
    public void afterMethod(){
        driver.quit();
    }

}

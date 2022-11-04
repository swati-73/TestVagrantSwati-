import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import java.lang.reflect.Array;

public class TestClass extends BaseTestClass {

    PageClass_Wiki wiki;
    PageClass_IMDB imdb;

    @BeforeMethod
    public void before(){

        wiki=new PageClass_Wiki(driver);
        imdb=new PageClass_IMDB(driver);

    }

    @Test
    public void testReleaseDate(){

        String Movie="Pushpa: The Rise";
        wiki.launchURL("https://www.wikipedia.org/");
        wiki.enterAndSearchMovie(Movie);
        String WikiReleaseDate=wiki.fetchReleaseDate();

        imdb.launchURL("https://www.imdb.com/");
        imdb.enterAndSearchMovie(Movie);
        String ImdbReleaseDate=imdb.fetchReleaseDate();

        Assert.assertTrue(wiki.checkDate( WikiReleaseDate, ImdbReleaseDate));
    }

    @Test
    public void testCountry(){
        String Movie="Pushpa: The Rise";
        wiki.launchURL("https://www.wikipedia.org/");
        wiki.enterAndSearchMovie(Movie);
        String WikiCountry=wiki.fetchCountry();

        imdb.launchURL("https://www.imdb.com/");
        imdb.enterAndSearchMovie(Movie);
        String ImdbCountry=imdb.fetchCountry();

        System.out.println("Wiki Release Date is: "+WikiCountry);
        System.out.println("IMDB Release Date is: "+ImdbCountry);

        Assert.assertTrue(ImdbCountry.contains(WikiCountry));
    }
}

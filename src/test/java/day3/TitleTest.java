package day3;

import day3.CDF.ChromeDriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class TitleTest {
    public String baseUrl = "https://google.com";
    public WebDriver driver ;

    @BeforeClass
    public void openSite() {
//        System.setProperty("webdriver.chrome.driver","/Users/igor/Applications/chromedriver");
//        driver = new ChromeDriver();
        driver = ChromeDriverFactory.initCD();
        driver.get(baseUrl);
    }

    @Test
    public void testTitle() {

        Assert.assertEquals(driver.getTitle(), "Google");
    }

    @AfterClass
    public void closeSite() {
        driver.quit();
    }
}

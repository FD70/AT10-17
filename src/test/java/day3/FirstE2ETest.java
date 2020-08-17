package day3;

import day3.CDF.ChromeDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.testng.Assert;
import org.testng.annotations.*;

public class FirstE2ETest {
    private String baseUrl = "http://demo.guru99.com/test/newtours/";
    private WebDriver driver ;

    @BeforeClass
    public void openSite() {
//        System.setProperty("webdriver.chrome.driver","/Users/igor/Applications/chromedriver");
//        driver = new ChromeDriver();
        driver = ChromeDriverFactory.initCD();
        driver.get(baseUrl);
    }

    @Test
    public void verifyHomepageTitle() {
        String expectedTitle = "Welcome: Mercury Tours";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);
    }

    @Test
    public void verifyMainLabel() {
        String actualText = driver.findElement(By.cssSelector("#site-name > a")).getText();
        String expectedText = "Demo Site";
        Assert.assertEquals(actualText, expectedText);
    }

    @AfterClass
    public void closeSite() {
        driver.quit();
    }
}

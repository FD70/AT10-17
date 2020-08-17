package day3;

import day3.CDF.ChromeDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ElementExistsTest {
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
    public void elementExists() {
        //WebElement existingElement = driver.findElement(By.xpath("/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[2]/td[3]/form/table/tbody/tr[4]/td/table/tbody/tr[4]/td[2]/div/input"));
        WebElement existingElement = driver.findElement(By.xpath("//input[@type=\"submit\"]"));
        Assert.assertTrue(existingElement.isDisplayed());

        try {
        WebElement notExistingElement = driver.findElement(By.name("noSuchName"));
        // в норме, этот код не должен выполняться
        Assert.fail("Element: noSuchName founded");
        }
        catch (NoSuchElementException e) {

        }
    }

    @AfterClass
    public void closeSite() {
        driver.quit();
    }
}

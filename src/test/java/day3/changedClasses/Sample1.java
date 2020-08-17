package day3.changedClasses;

import day3.CDF.ChromeDriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;

public class Sample1 {
    public static void main(String[] args) {
        //System.setProperty("webdriver.chrome.driver","/Users/igor/Applications/chromedriver");
        //WebDriver safariDriver = new SafariDriver();
        WebDriver chromeDriver = ChromeDriverFactory.initCD();
        try {
            String baseUrl = "http://demo.guru99.com/test/newtours/";

            //safariDriver.get(baseUrl);
            chromeDriver.get(baseUrl);

            //System.out.println("Safari title = " + safariDriver.getTitle());
            System.out.println("Chrome title = " + chromeDriver.getTitle());
        } finally {
            //safariDriver.quit();
            chromeDriver.quit();
        }
    }
}

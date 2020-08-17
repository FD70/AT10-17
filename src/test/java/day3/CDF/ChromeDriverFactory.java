package day3.CDF;

import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeDriverFactory {
    private static String chromeDriverPath = "D:/chromedriver.exe";

    public static ChromeDriver initCD() {
        System.setProperty("webdriver.chrome.driver", chromeDriverPath);
        return new ChromeDriver();
    }
}

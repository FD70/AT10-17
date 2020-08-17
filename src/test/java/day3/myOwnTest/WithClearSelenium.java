package day3.myOwnTest;

import day3.CDF.ChromeDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class WithClearSelenium {

    WebDriver driver;

    @BeforeClass
    public void initThis() {
        driver = ChromeDriverFactory.initCD();
    }

    @Test
    public void withClearSelenium() {
        String baseURL = "https://www.open.ru";

        driver.get(baseURL);
        // Мы на главной странице
        //Извлечь курсы валют
        Double usdBuy = getCourse("//tr[2]//td[2]//*[@class=\"main-page-exchange__rate\"]");
        Double usdTrade = getCourse("//tr[2]//td[4]//*[@class=\"main-page-exchange__rate\"]");
        Double eurBuy = getCourse("//tr[3]//td[2]//*[@class=\"main-page-exchange__rate\"]");
        Double eurTrade = getCourse("//tr[3]//td[4]//*[@class=\"main-page-exchange__rate\"]");

        System.out.println("usdBuy " + usdBuy);
        System.out.println("usdTrade " + usdTrade);
        System.out.println("eurBuy " + eurBuy);
        System.out.println("eurTrade " + eurTrade);

        // ..и проверить, что курс продажи доллара выше, чем курс покупки.
        //Аналогичная проверка - для евро.
        Assert.assertTrue(usdBuy < usdTrade);
        Assert.assertTrue(eurBuy < eurTrade);
    }

    @AfterClass
    public void closeBrowser() {
        driver.quit();
    }

    public Double getCourse(String xPath) {
        return Double.parseDouble(driver.findElement(By.xpath(xPath)).getText().replace(",","."));
    }
}

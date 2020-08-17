package day3.myOwnTest;

import day3.CDF.ChromeDriverFactory;
import org.openqa.selenium.WebDriver;
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

        //tr[2]//td[2]//*[@class="main-page-exchange__rate"]

        //Извлечь курсы валют и проверить, что курс продажи доллара выше, чем курс покупки.
        //Аналогичная проверка - для евро.
    }

    @AfterClass
    public void closeBrowser() {
        driver.quit();
    }
}

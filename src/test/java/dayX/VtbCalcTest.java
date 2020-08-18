package dayX;

import com.codeborne.selenide.Configuration;
import dayX.SelenidPages.VTB.VtbExchangePage;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$x;


public class VtbCalcTest {
    // Используйте только Selenide.
    // Написать минимум четыре тест кейса
    // - рубли в доллары, доллары в рубли, до $30000, более $30000

    private VtbExchangePage page;
    @BeforeClass
    public void before() {
        page = VtbExchangePage.getExchangePage();
        $x("//*[@id=\"cookiemsgoffpls\"]/p[1]").click();
    }
    @Test
    public void test1() {
        System.out.println(page.getRurToUsdCourse(100.0));
    }

    @Test
    public void test3() {
        System.out.println(page.getRurToEurCourse(29000.0));
    }

    @Test
    public void test4() {
        System.out.println(page.getEurToRurCourse(31000.0));
    }

    @Test
    public void test2() {
        System.out.println(page.getUsdToRurCourse(100.0));
    }
}

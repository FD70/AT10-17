package dayX;


import dayX.SelenidPages.VTB.VtbExchangePage;
import org.testng.Assert;
import org.testng.annotations.*;

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
        Double input = 1.1;
        Double result = page.getRurToUsdCourse(input);
        Assert.assertNotEquals(result, 0.0);
        Assert.assertTrue(result < input);
    }

    @Test
    public void test2() {
        System.out.println(page.getUsdToRurCourse(2000.2));
    }

    @Test
    public void test3() {
        System.out.println(page.getRurToEurCourse(3.3));
    }

    @Test
    public void test4() {
        System.out.println(page.getEurToRurCourse(4.4));
    }

    @Test
    public void test5() {
        System.out.println(page.getUsdToEurCourse(5.5));
        System.out.println(page.getEurToUsdCourse(6.6));
    }
}

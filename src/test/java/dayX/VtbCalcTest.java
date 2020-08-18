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
        double rur = 1.1;
        double result = page.getRurToUsdCourse(rur);
        Assert.assertNotEquals(result, 0.0);
        Assert.assertTrue(rur > result);
    }

    @Test
    public void test2() {
        double usd = 2000.20;
        double result = page.getUsdToRurCourse(usd);
        Assert.assertNotEquals(result, 0.0);
        Assert.assertTrue(usd < result );
    }

    @Test
    public void test3() {
        double rur = 31000.0;
        double result = page.getRurToEurCourse(rur);
        Assert.assertNotEquals(result, 0.0);
        Assert.assertTrue(rur > result);
    }

    @Test
    public void test4() {
        double eur = 1;
        double result = page.getEurToRurCourse(eur);
        Assert.assertNotEquals(result, 0.0);
        Assert.assertTrue(eur < result);
    }

    @Test
    public void test5() {
        double result = page.getUsdToEurCourse(1.0);
        System.out.println(result);
        System.out.println(page.getEurToUsdCourse(result));
    }
}

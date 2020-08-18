package dayX.SelenidPages.VTB;

import static com.codeborne.selenide.Selenide.*;

public class VtbExchangePage {
    private static String  url = "https://www.vtb.ru/personal/platezhi-i-perevody/obmen-valjuty/";
    static String USD = "USD";
    static String RUR = "RUR";
    static String EUR = "EUR";



    private void method1change(String val) {
        $x("//input[@id=\"method1\"]/../../div[3]").click();
        $x("//input[@id=\"method1\"]/../..//li[contains(.,\"" + val + "\")]").click();
    }
    private void method2change(String val) {
        $x("//input[@id=\"method2\"]/../../div[3]").click();
        $x("//input[@id=\"method2\"]/../..//li[contains(.,\"" + val + "\")]").click();
    }
    private void exchangeMethod (String have, String want) {
        method1change(have);
        method2change(want);
    }

    public static VtbExchangePage getExchangePage() {
        return open(url, VtbExchangePage.class);
    }

    // rur eur usd
    public Double getRurToUsdCourse (Double rub) {
        return getCourse(rub, RUR, USD);
    }
    public Double getRurToEurCourse (Double rub) {
        return getCourse(rub, RUR, EUR);
    }
    public Double getUsdToRurCourse (Double usd) {
        return getCourse(usd, USD, RUR);
    }
    public Double getUsdToEurCourse (Double usd) {
        return getCourse(usd, USD, EUR);
    }
    public Double getEurToRurCourse (Double eur) {
        return getCourse(eur, EUR, RUR);
    }
    public Double getEurToUsdCourse (Double eur) {
        return getCourse(eur, EUR, USD);
    }
    private Double getCourse (Double val, String m1, String m2) {
        exchangeMethod(m1, m2);

        $x("//input[@id=\"method1\"]").clear();
        String oldM2value = $x("//input[@id=\"method2\"]").val();
        $x("//input[@id=\"method1\"]").sendKeys(val.toString().replace(".",","));
        //клик на название, чтобы метод вернул курс
        $x("//input[@id=\"method1\"]/../../../label").click();

        // проверка, и ожидание, что курс рассчитался
        String result  = oldM2value;
        for (int i = 0; i < 10; i++) {
            result = $x("//input[@id=\"method2\"]").val();
            if (oldM2value.equals(result) || result.equals("0")) {
                try {
                    Thread.sleep(500);
                } catch (Exception ignored) {}
            } else {
                break;
            }
        }
        //FIXME почему-то replace отказывается работать в этом месте
        //TestReplace ==> там работает, здесь - нет
        result = result.replaceAll("\\s", "").replace(",",".");
        System.out.println(result);
        return Double.parseDouble(result);
    }
}

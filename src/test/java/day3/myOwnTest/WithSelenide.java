package day3.myOwnTest;

import day3.SelenidPages.openBank.OpenBankMainPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;

public class WithSelenide {

    @Test
    public void withSelenide() {
        OpenBankMainPage obmp = open("https://www.open.ru", OpenBankMainPage.class);

        //Извлечь курсы валют
        // ..и проверить, что курс продажи доллара выше, чем курс покупки.
        //Аналогичная проверка - для евро.
        System.out.println("USD: " + obmp.getUsdBuy() + " / " + obmp.getUsdTrade());
        System.out.println("EUR: " + obmp.getEurBuy() + " / " + obmp.getEurTrade());
        Assert.assertTrue(obmp.getUsdBuy() < obmp.getUsdTrade());
        Assert.assertTrue(obmp.getEurBuy() < obmp.getEurTrade());

    }
}

package dayX;

import java.util.Map;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;


public class RestAssuredSample {
    static String LOCALES = "locales";
    static String CURRENCIES = "currencies";
    static String TIMEZONES = "timezones";
    static String CITIES = "cities";
    static String COUNTRIES = "countries";

    static String HOST = "wft-geo-db.p.rapidapi.com";
    static String KEY = "c6cac7bc7amshee2830eca70001bp1f2baejsn4ebfc34c5cff";
    static Map<String, String> baseUrl = Map.of(
            LOCALES,"https://wft-geo-db.p.rapidapi.com/v1/locale/locales",
            CURRENCIES, "https://wft-geo-db.p.rapidapi.com/v1/locale/currencies",
            TIMEZONES, "https://wft-geo-db.p.rapidapi.com/v1/locale/timezones",
            CITIES, "https://wft-geo-db.p.rapidapi.com/v1/geo/cities",
            COUNTRIES, "https://wft-geo-db.p.rapidapi.com/v1/geo/countries"
    );

    // https://rapidapi.com/wirefreethought/api/geodb-cities/endpoints
    // Тестируем это API. По одному кейсу на  эндпоинты
    // Locales, Currencies, TimeZones, Cities, Countries.

    @Test
    public void testGetLocales() {
    }

    @Test
    public void testGetCurrencies() {
    }

    @Test
    public void testGetTimezones() {

    }

    @Test
    public void testGetCities() {

    }

    @Test
    public void testGetCountries() {
        given().
                header("x-rapidapi-host", HOST).
                header("x-rapidapi-key", KEY).
                when().
                get(baseUrl.get(COUNTRIES)).
                then().
                assertThat().
                body("data", hasSize(5));
    }
}

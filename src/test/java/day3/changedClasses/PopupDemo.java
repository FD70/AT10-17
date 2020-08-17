package day3.changedClasses;

import day3.CDF.ChromeDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.annotations.*;
import java.util.Set;

public class PopupDemo {
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeClass
    public void initThis() {
        driver = ChromeDriverFactory.initCD();
        wait = new WebDriverWait(driver, 20);
    }

    @Test
    public void popupDemo() {

        //Launching the site.
        driver.get("http://demo.guru99.com/popup.php");
        driver.manage().window().maximize();

        driver.findElement(By.xpath("//*[contains(@href,'popup.php')]")).click();

        String mainWindow = driver.getWindowHandle();
        System.out.println("Main window handle = " + mainWindow);

        // To handle all new opened window.
        Set<String> allWindows = driver.getWindowHandles();

        for (String childWindow : allWindows) {

            if (!mainWindow.equalsIgnoreCase(childWindow)) {
                System.out.println("Child window handle = " + childWindow);
                // Switching to Child window
                driver.switchTo().window(childWindow);
                driver.findElement(By.name("emailid")).sendKeys("gaurav.3n@gmail.com");
                driver.findElement(By.name("btnLogin")).click();

                wait.until(
                        ExpectedConditions
                                .visibilityOfElementLocated(
                                        By.xpath("/html/body/table/tbody/tr[1]/td/h2")));

                WebElement userIdElement = driver.findElement(By.xpath("/html/body/table/tbody/tr[4]/td[2]"));
                WebElement passwordElement = driver.findElement(By.xpath("/html/body/table/tbody/tr[5]/td[2]"));

                System.out.println(userIdElement.getText());
                System.out.println(passwordElement.getText());

                // Closing the Child Window.
                driver.close();
            }
        }
        // Switching to Parent window i.e Main Window.
        driver.switchTo().window(mainWindow);
    }

    @AfterClass
    public void closeBrowser() {
        driver.quit();
    }
}

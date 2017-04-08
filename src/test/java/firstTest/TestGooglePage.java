package firstTest;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Test for QA2 lesson 3
 */
public class TestGooglePage {

    @Test
    public void testGooglePage() {
        System.setProperty("webdriver.gecko.driver", "C:/Users/Irrinka/geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("http://google.com");

        WebElement element = driver.findElement(By.id("lst-ib"));
        element.sendKeys("Selenium");
        element.submit();

        Boolean title = (new WebDriverWait(driver, 10))
                .until(new ExpectedCondition<Boolean>() {
                    public Boolean apply(WebDriver webDriver) {
                        return webDriver.getTitle().startsWith("Selenium");
                    }
                });
        Assert.assertTrue("Wrong title of page", title);

        driver.quit();
    }
}

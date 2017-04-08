package firstTest;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * Home task for QA2 lesson 3
 */

public class SportsDirect {

    @Test
    public void filterSwimsuits() throws InterruptedException {
        System.setProperty("webdriver.gecko.driver", "C:/Users/Irrinka/geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://lv.sportsdirect.com/swimming/ladies-swimwear/swimsuits");
        WebElement elementPopUp = driver.
                findElement(By.xpath("//div[@class='modal-header']/button[@class='close']"));
        elementPopUp.click();

        final WebElement elementCheckBoxUnisex = driver.
                findElement(By.xpath("//span[@data-item='AFLOR^Unisex Adults']"));
        final WebElement elementProductCountGirls = driver.
                findElement(By.xpath("//div[@data-productname='Girls']"));

        elementCheckBoxUnisex.click();

        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.attributeContains(elementCheckBoxUnisex, "class",
                "SelectedFilter"));

        WebElement elementCheckBoxGirls = driver.
                findElement(By.xpath("//span[@data-filtername='Girls']"));

        elementCheckBoxGirls.click();

        WebElement elementProductCountUnisex = driver.
                findElement(By.xpath("//div[@data-productname='Unisex Adults']"));

        int countUnisexAdults = Integer.
                parseInt(elementProductCountUnisex.getAttribute("data-productcount"));

        int countGirls = Integer.
                parseInt(elementProductCountGirls.getAttribute("data-productcount"));

        WebElement elementSelectProductList = driver.findElement(By.id("navlist"));

        int productList = elementSelectProductList.findElements(By.xpath("*")).size();

        Assert.assertEquals(productList, countGirls + countUnisexAdults);
    }
}

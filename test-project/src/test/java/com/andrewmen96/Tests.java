package com.andrewmen96;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Tests {
    public static WebDriver driver;
    public static JsbinPage jsbin;


    @BeforeClass
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", ConfProperties.getProperies("chromedriver"));
        driver = new ChromeDriver();
        jsbin = new JsbinPage(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(ConfProperties.getProperies("jsbinpage"));
    }

    @Test
    public void tests() {
        driver.switchTo().frame("<proxy>");
        driver.switchTo().frame("JS Bin Output ");
        jsbin.delete();
    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }
}

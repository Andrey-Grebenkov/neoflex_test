package com.andrewmen96;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class JsbinPage {

    public static int i;

    public WebDriver driver;

    public JsbinPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }


    @FindBy(xpath = "//*[text()='(X) Закрыть счет']")
    private List<WebElement> closePriceButton;

    @FindBy(xpath = "//*[contains(@class,'acc-')]//b")
    private List<WebElement> balance;

    public void delete() {
//        List<WebElement> closePriceButton = driver.findElements(By.xpath("//*[text()='(X) Закрыть счет']"));
//        List<WebElement> balance = driver.findElements(By.xpath("//*[contains(@class,'acc-')]//b"));
        for (WebElement ba : balance) {
            if (ba.getText().equals("0"))
                closePriceButton.get(i).click();
        }
    }
}

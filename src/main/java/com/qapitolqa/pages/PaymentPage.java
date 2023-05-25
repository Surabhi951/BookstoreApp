package com.qapitolqa.pages;

import com.qapitolqa.baseclass.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class PaymentPage extends BaseClass {

    public PaymentPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterPaymentDetails() throws InterruptedException {
        WebElement cardNo = driver.findElement(By.id("cardNumber"));
        cardNo.clear();
        cardNo.sendKeys("4111 1111 1111 1111");
        WebElement expirationMonth = driver.findElement(By.id("expirationMonth"));
        expirationMonth.clear();
        expirationMonth.sendKeys("10");
        WebElement expirationYear = driver.findElement(By.id("expirationYear"));
        expirationYear.clear();
        expirationYear.sendKeys("23");
        WebElement cvv = driver.findElement(By.id("cvv"));
        cvv.clear();
        cvv.sendKeys("543");

        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).build().perform();
        Thread.sleep(1000);

        WebElement addCardBtn = driver.findElement(By.xpath("//*[@id=\"root\"]/main/div/div[3]/div[2]/div[2]/button"));
        addCardBtn.click();
        Thread.sleep(5000);

    }

    public void selectPaymentCard() throws InterruptedException {
        WebElement radioBtn = driver.findElement(By.name("paymentMethod"));
        Actions actions1 = new Actions(driver);
        actions1.moveToElement(radioBtn).click().build().perform();


        WebElement proceedToPalaceOrderBtn = driver.findElement(By.xpath("//*[@id=\"root\"]/main/div/div[4]/button"));
        proceedToPalaceOrderBtn.click();
        Thread.sleep(5000);
    }
}

package com.qapitolqa.pages;

import com.qapitolqa.baseclass.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import java.util.Iterator;
import java.util.Set;

public class ShippingPage extends BaseClass {

    public ShippingPage(WebDriver driver) {
        this.driver = driver;
    }

    public void shippingOrder() throws InterruptedException {
        WebElement placeOrderBtn = driver.findElement(By.xpath("//*[@id=\"root\"]/main/div/div[2]/div[2]/div/div/div[6]/button"));
        placeOrderBtn.click();
        Thread.sleep(5000);
    }

    public void verifyShippingOrder() throws InterruptedException {
        WebElement verifyReceipt = driver.findElement(By.xpath("//*[@id=\"root\"]/main/div/div/div[1]/div/div[2]/p[2]/a"));
        Actions actions = new Actions(driver);
        actions.moveToElement(verifyReceipt);
        verifyReceipt.click();

        Set<String> window = driver.getWindowHandles();
        Iterator<String> iterator = window.iterator();
        String parentWindow = iterator.next();
        String childWindow = iterator.next();
        driver.switchTo().window(childWindow);

        WebElement verify = driver.findElement(By.xpath("/html/body/table/tbody/tr[2]/td/table/tbody/tr/td/table[2]/tbody/tr[1]/td"));
        System.out.println(verify.getText());
        Assert.assertEquals(verify.getText(), "Receipt from BookStore");
        Thread.sleep(1000);
        driver.close();
        driver.switchTo().window(parentWindow);
    }
}

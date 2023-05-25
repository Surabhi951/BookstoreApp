package com.qapitolqa.pages;

import com.qapitolqa.baseclass.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPage extends BaseClass {

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public void addProductToCartAndCheckout() throws InterruptedException {
        WebElement addToCart = driver.findElement(By.xpath("//*[@id=\"root\"]/main/div/div[1]/div[3]/div/div/div[4]/button"));
        addToCart.click();
        Thread.sleep(2000);
        WebElement proceedTOCheckout = driver.findElement(By.xpath("//*[@id=\"root\"]/main/div/div[2]/div[2]/div/div/div[3]/button"));
        proceedTOCheckout.click();
        Thread.sleep(2000);
    }

    public void addProductIntoCart() throws InterruptedException {
        WebElement addToCart = driver.findElement(By.xpath("//*[@id=\"root\"]/main/div/div[1]/div[3]/div/div/div[4]/button"));
        addToCart.click();
        Thread.sleep(2000);
    }

    public void proceedToCheckOut() throws InterruptedException {
        WebElement proceedTOCheckout = driver.findElement(By.xpath("//*[@id=\"root\"]/main/div/div[2]/div[2]/div/div/div[3]/button"));
        proceedTOCheckout.click();
        Thread.sleep(5000);
    }
}

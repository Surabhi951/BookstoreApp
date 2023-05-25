package com.qapitolqa.pages;

import com.qapitolqa.baseclass.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.awt.*;
import java.awt.event.KeyEvent;


public class HomePage extends BaseClass {

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void selectBook() throws AWTException, InterruptedException {
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_PAGE_DOWN);
        robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"root\"]/main/div/div[1]/div[8]/div/a/img")).click();
        Thread.sleep(2000);
    }

    public void selectNewBook() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"root\"]/main/div/div[1]/div[2]/div/a/img")).click();
        Thread.sleep(2000);
    }

    public void AddMultipleBooks() throws InterruptedException {
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).build().perform();
        WebElement page = driver.findElement(By.xpath("//*[@id=\"root\"]/main/div/div[2]/ul/li[3]/a"));
        page.click();
        WebElement book1 = driver.findElement(By.xpath("//*[@id=\"root\"]/main/div/div[1]/div[1]/div/a/img"));
        book1.click();

        WebElement addToCartBtn = driver.findElement(By.xpath("//*[@id=\"root\"]/main/div/div[1]/div[3]/div/div/div[4]/button"));
        Actions actions1 = new Actions(driver);
        actions1.moveToElement(addToCartBtn).click().build().perform();
        Thread.sleep(2000);

        WebElement addMoreBook = driver.findElement(By.xpath("//*[@id=\"root\"]/main/div/div[2]/div[1]/div[2]/a"));
        addMoreBook.click();
        Thread.sleep(2000);

        WebElement book2 = driver.findElement(By.xpath("//*[@id=\"root\"]/main/div/div[1]/div[4]/div/a/img"));
        book2.click();

        WebElement addToCartButton1 = driver.findElement(By.xpath("//*[@id=\"root\"]/main/div/div[1]/div[3]/div/div/div[4]/button"));
        Actions actions2 = new Actions(driver);
        actions2.moveToElement(addToCartButton1).click().build().perform();
        Thread.sleep(2000);
    }

    public void updateProfile() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"username\"]")).click();
        WebElement profile = driver.findElement(By.xpath("//*[@id=\"basic-navbar-nav\"]/div/div/div/a[1]"));
        profile.click();
        WebElement lastName = driver.findElement(By.id("lastName"));
        lastName.sendKeys("bhagat");
        WebElement pass = driver.findElement(By.xpath("//*[@id=\"password\"]"));
        pass.sendKeys("surabhi12345");
        WebElement confirmPass = driver.findElement(By.id("confirmPassword"));
        confirmPass.sendKeys("surabhi12345");

        WebElement updateBtn = driver.findElement(By.xpath("//*[@id=\"root\"]/main/div/div/div[1]/form/button"));
        Actions actions = new Actions(driver);
        actions.moveToElement(updateBtn).click();
        Thread.sleep(5000);
    }

    public void logoutFromBookStoreApp() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"username\"]")).click();
        WebElement logout = driver.findElement(By.xpath("//*[@id=\"basic-navbar-nav\"]/div/div/div/a[2]"));
        logout.click();
        Thread.sleep(2000);
    }
}


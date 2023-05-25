package com.qapitolqa.pages;

import com.qapitolqa.baseclass.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BaseClass {

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void loginIntoTheBookStoreApp(String uName, String pass) throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"basic-navbar-nav\"]/div/a[2]")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("userNameOrEmail")).sendKeys(uName);
        driver.findElement(By.id("password")).sendKeys(pass);
        driver.findElement(By.xpath("//*[@id=\"root\"]/main/div/div/div/div/div/form/button")).click();
        Thread.sleep(5000);
    }

    public void loginWithNewUser() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"basic-navbar-nav\"]/div/a[2]")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("userNameOrEmail")).sendKeys("radha@gmail.com");
        driver.findElement(By.id("password")).sendKeys("radha123");
        driver.findElement(By.xpath("//*[@id=\"root\"]/main/div/div/div/div/div/form/button")).click();
        Thread.sleep(5000);
    }

    public void newRegisterUserLogin() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"basic-navbar-nav\"]/div/a[2]")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("userNameOrEmail")).sendKeys("sakshi11@gmail.com");
        driver.findElement(By.id("password")).sendKeys("sakshi123");
        driver.findElement(By.xpath("//*[@id=\"root\"]/main/div/div/div/div/div/form/button")).click();
        Thread.sleep(5000);
    }
}

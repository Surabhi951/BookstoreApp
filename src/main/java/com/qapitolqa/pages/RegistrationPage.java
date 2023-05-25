package com.qapitolqa.pages;

import com.qapitolqa.utility.ReadPropertyFile;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.FileNotFoundException;

public class RegistrationPage extends ReadPropertyFile {


    public RegistrationPage(WebDriver driver) throws FileNotFoundException {
        this.driver = driver;
    }

    public void registrationOnBookStoreApp() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"basic-navbar-nav\"]/div/a[2]")).click();
        driver.findElement(By.xpath("//*[@id=\"root\"]/main/div/div/div/div/div/div/div/a")).click();
        WebElement username = driver.findElement(By.xpath("//*[@id=\"userName\"]"));
        username.sendKeys("SurabhiBhagat18");
        WebElement firstName = driver.findElement(By.xpath("/html/body/div/main/div/div/div/div/div/form/div[2]/input"));
        firstName.sendKeys(properties.getProperty("firstName"));
        WebElement email = driver.findElement(By.id("email"));
        email.sendKeys("surabhi703@gmail.com");
        WebElement pass = driver.findElement(By.id("password"));
        pass.sendKeys("surabhi123");
        WebElement confirmPass = driver.findElement(By.xpath("/html/body/div/main/div/div/div/div/div/form/div[5]/input"));
        confirmPass.sendKeys("surabhi123");
        driver.findElement(By.xpath("//*[@id=\"root\"]/main/div/div/div/div/div/form/button")).click();
        Thread.sleep(5000);
    }

    public void registerWithNewUser() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"basic-navbar-nav\"]/div/a[2]")).click();
        driver.findElement(By.xpath("//*[@id=\"root\"]/main/div/div/div/div/div/div/div/a")).click();
        WebElement username = driver.findElement(By.xpath("//*[@id=\"userName\"]"));
        username.sendKeys("sakshishinde4");
        WebElement firstName = driver.findElement(By.xpath("/html/body/div/main/div/div/div/div/div/form/div[2]/input"));
        firstName.sendKeys("sakshi");
        WebElement email = driver.findElement(By.id("email"));
        email.sendKeys("sakshi8@gmail.com");
        WebElement pass = driver.findElement(By.id("password"));
        pass.sendKeys("sakshi123");
        WebElement confirmPass = driver.findElement(By.xpath("/html/body/div/main/div/div/div/div/div/form/div[5]/input"));
        confirmPass.sendKeys("sakshi123");
        driver.findElement(By.xpath("//*[@id=\"root\"]/main/div/div/div/div/div/form/button")).click();
        Thread.sleep(5000);
    }
}

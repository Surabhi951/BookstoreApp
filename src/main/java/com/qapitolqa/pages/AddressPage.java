package com.qapitolqa.pages;

import com.qapitolqa.baseclass.BaseClass;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class AddressPage extends BaseClass {

    Select dropDown;

    public AddressPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterAddressDetails() throws InterruptedException {
        WebElement addressLine1 = driver.findElement(By.id("addressLine1"));
        addressLine1.sendKeys("06,BTM 2nd stage Near vega city mall");
        WebElement city = driver.findElement(By.id("city"));
        city.sendKeys("Bangalore");
        WebElement state = driver.findElement(By.id("state"));
        state.sendKeys("Karnataka");

        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).build().perform();
        Thread.sleep(1000);

        WebElement countryCode = driver.findElement(By.id("country"));
        dropDown = new Select(countryCode);
        dropDown.selectByVisibleText("India");
        Thread.sleep(1000);

        WebElement postalCode = driver.findElement(By.id("postalCode"));
        postalCode.sendKeys("560075");
        WebElement phone = driver.findElement(By.id("phone"));
        phone.sendKeys("7685439093");
        WebElement addNewAddressBtn = driver.findElement(By.xpath("/html/body/div/main/div/div[3]/div[2]/form/div[2]/button"));
        addNewAddressBtn.click();
        Thread.sleep(5000);

    }

    public void selectAddress() throws InterruptedException {
        WebElement radioBtn = driver.findElement(By.name("billingAddress"));
        Actions actions1 = new Actions(driver);
        actions1.moveToElement(radioBtn).click().build().perform();

        WebElement proceedToPaymentBtn = driver.findElement(By.xpath("//*[@id=\"root\"]/main/div/div[4]/button"));
        proceedToPaymentBtn.click();
        Thread.sleep(5000);
    }

    public void addNewAddressTOAddressPage() throws InterruptedException {
        WebElement addressLine1 = driver.findElement(By.id("addressLine1"));
        addressLine1.sendKeys("01,Vega city mall, 1st stage");
        WebElement city = driver.findElement(By.id("city"));
        city.sendKeys("Bangalore");
        WebElement state = driver.findElement(By.id("state"));
        state.sendKeys("Karnataka");

        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).build().perform();
        Thread.sleep(1000);

        WebElement countryCode = driver.findElement(By.id("country"));
        dropDown = new Select(countryCode);
        dropDown.selectByVisibleText("India");
        Thread.sleep(1000);

        WebElement postalCode = driver.findElement(By.id("postalCode"));
        postalCode.sendKeys("560075");
        WebElement phone = driver.findElement(By.id("phone"));
        phone.sendKeys("8765094563");
        WebElement addNewAddressBtn = driver.findElement(By.xpath("//*[@id=\"root\"]/main/div/div[3]/div[2]/form/div[2]/button"));
        addNewAddressBtn.click();
        Thread.sleep(2000);

        WebElement radioBtn = driver.findElement(By.name("billingAddress"));
        Actions actions1 = new Actions(driver);
        actions1.moveToElement(radioBtn).click().build().perform();

        WebElement proceedToPaymentBtn = driver.findElement(By.xpath("//*[@id=\"root\"]/main/div/div[4]/button"));
        proceedToPaymentBtn.click();
        Thread.sleep(5000);
    }

    public void deleteAddressDetails() throws InterruptedException {
        WebElement delete = driver.findElement(By.xpath("//*[@id=\"root\"]/main/div/div[3]/div[1]/div[1]/div/div/div[3]/button/i"));
        delete.click();
        Thread.sleep(5000);

    }
}

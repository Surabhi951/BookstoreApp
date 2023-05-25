package com.qapitolqa.baseclass;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class BaseClass {

    public static WebDriver driver = null;

    Logger log;


    public void setUP() {
        log = Logger.getLogger(BaseClass.class.getName());
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("autofill.profile_enabled", false);
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.setExperimentalOption("prefs", prefs);
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("http://139.59.27.246:3000/");
        log.info("Chrome browser has Launched");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.MILLISECONDS);
        log.config("Implicit time wait");
    }

    public void closeBrowser() {
        driver.quit();
        log.info("quit");
    }

    public void takeScreenShot() throws IOException {
        TakesScreenshot screenshot = ((TakesScreenshot) driver);
        File srcFile = screenshot.getScreenshotAs(OutputType.FILE);
        File destFile = new File("C:\\Users\\surabhi.bhagat\\IdeaProjects\\AutomateBookStore\\src\\main\\Screenshot" +System.currentTimeMillis() +".png");
        FileHandler.copy(srcFile,destFile);
    }


}
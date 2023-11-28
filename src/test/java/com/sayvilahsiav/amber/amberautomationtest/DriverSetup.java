package com.sayvilahsiav.amber.amberautomationtest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverSetup {
    public static WebDriver initializeDriver() {
        // Set the path to the chromedriver executable
        System.setProperty("webdriver.chrome.driver", "D:\\Study\\Udemy\\Selenium\\chromedriver-win64\\chromedriver.exe");

        // Configure Chrome options
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications"); // Disable browser notifications
        options.addArguments("--start-maximized"); // Start the browser maximized

        // Initialize the ChromeDriver
        WebDriver driver = new ChromeDriver(options);

        return driver;
    }
}

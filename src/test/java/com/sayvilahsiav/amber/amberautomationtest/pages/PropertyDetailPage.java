package com.sayvilahsiav.amber.amberautomationtest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PropertyDetailPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    // Locators for the title and location of the property
    private final By titleLocator = By.cssSelector("div[class='amber-11dmpxk'] h1");
    private final By locationLocator = By.cssSelector("div[class='amber-Text-root amber-1gvc0gz']");

    public PropertyDetailPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    /**
     * Retrieves the title of the property from the property detail page.
     *
     * @return The title of the property.
     */
    public String getPropertyTitle() {
        WebElement titleElement = wait.until(ExpectedConditions.visibilityOfElementLocated(titleLocator));
        return titleElement.getText();
    }

    /**
     * Retrieves the location of the property from the property detail page.
     *
     * @return The location of the property.
     */
    public String getPropertyLocation() {
        WebElement locationElement = wait.until(ExpectedConditions.visibilityOfElementLocated(locationLocator));
        return locationElement.getText();
    }
}

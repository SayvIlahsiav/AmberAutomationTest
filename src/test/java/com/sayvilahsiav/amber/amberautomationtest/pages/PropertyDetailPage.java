package com.sayvilahsiav.amber.amberautomationtest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PropertyDetailPage {
    private WebDriver driver;

    // Locators for the title and location of the property
    private By titleLocator = By.cssSelector("h1[class*='amber-Title-root']");
    private By locationLocator = By.cssSelector("div[class='amber-Text-root amber-1gvc0gz']");

    public PropertyDetailPage(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Retrieves the title of the property from the property detail page.
     * @return The title of the property.
     */
    public String getPropertyTitle() {
        WebElement titleElement = driver.findElement(titleLocator);
        return titleElement.getText();
    }

    /**
     * Retrieves the location of the property from the property detail page.
     * @return The location of the property.
     */
    public String getPropertyLocation() {
        WebElement locationElement = driver.findElement(locationLocator);
        return locationElement.getText();
    }
}

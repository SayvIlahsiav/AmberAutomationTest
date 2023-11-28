package com.sayvilahsiav.amber.amberautomationtest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    private WebDriver driver;
    private WebDriverWait wait;

    // Locators
    private By searchBoxLocator = By.id("main-search");
    private By firstSuggestionLocator = By.id("downshift-0-item-0");

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void openHomePage(String url) {
        driver.get(url);
    }

    public void enterSearchCriteria(String criteria) {
        WebElement searchBox = wait.until(ExpectedConditions.elementToBeClickable(searchBoxLocator));
        searchBox.sendKeys(criteria);

        // Wait for the first suggestion to be clickable and click it
        WebElement firstSuggestion = wait.until(ExpectedConditions.elementToBeClickable(firstSuggestionLocator));
        firstSuggestion.click();
    }

}

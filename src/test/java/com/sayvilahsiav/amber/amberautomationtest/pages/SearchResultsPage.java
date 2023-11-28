package com.sayvilahsiav.amber.amberautomationtest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;

public class SearchResultsPage {
    private WebDriver driver;
    private WebDriverWait wait;

    // Constructor
    public SearchResultsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Method to apply the filter for Room Type - “Private Room”
    public void applyRoomTypeFilter() {
        WebElement roomTypeFilter = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[contains(.,'Private Room')]")));
        roomTypeFilter.click();
    }

    // Method to apply the filter for Sharing - “Private Bathroom”
    public void applyPrivateBathroomFilter() {
        WebElement privateBathroomFilter = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[contains(.,'Private Bathroom')]")));
        privateBathroomFilter.click();
    }

    // Method to apply the filters and show results
    public void applyFiltersAndShowResults() {
        applyRoomTypeFilter();
        applyPrivateBathroomFilter();

        WebElement showResultsButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".amber-UnstyledButton-root.amber-Button-root.amber-1abcetc")));
        showResultsButton.click();
    }

    // Method to open the second search result in a new tab
    public void openSecondSearchResultInNewTab() {
        WebElement secondSearchResult = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='amber-1avyp1d'][2]")));
        secondSearchResult.click();

        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
    }
}

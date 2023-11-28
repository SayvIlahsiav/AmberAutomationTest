package com.sayvilahsiav.amber.amberautomationtest.tests;

import com.sayvilahsiav.amber.amberautomationtest.DriverSetup;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class CityListVerificationTest {
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeMethod
    public void setup() {
        driver = DriverSetup.initializeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://amberstudent.com/");
    }

    @Test
    public void verifyCityListIsUniqueAcrossCountries() {
        // Click on the search box
        WebElement searchBox = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div[data-testid='search-input-section']")));
        searchBox.click();

        // Get list of countries
        List<WebElement> countryElements = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//button[contains(@id,'tab')]")));

        // Global list to keep track of all cities seen across countries
        List<String> allCities = new ArrayList<>();

        // Iterate through each country
        for (int i = 0; i < countryElements.size(); i++) {
            if (i == 0) {
                continue; // Skip the "All" section
            }

            String countryCode = countryElements.get(i).getText().toLowerCase();
            countryElements.get(i).click();

            // Fetch city elements within the country
            List<WebElement> cityElements = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("div[id*='" + countryCode + "'] div[class='amber-1z0x9lj'] div[class='amber-Text-root amber-1mirppv']")));

            // Iterate through each city and check for duplicates
            for (WebElement element : cityElements) {
                String cityName = element.getText();
                Assert.assertFalse(allCities.contains(cityName), "Duplicate city found: " + cityName);
                allCities.add(cityName);
            }
        }

        System.out.println("Total cities count: " + allCities.size());
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}

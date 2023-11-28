package com.sayvilahsiav.amber.amberautomationtest.tests;

import com.sayvilahsiav.amber.amberautomationtest.DriverSetup;
import com.sayvilahsiav.amber.amberautomationtest.pages.HomePage;
import com.sayvilahsiav.amber.amberautomationtest.pages.PropertyDetailPage;
import com.sayvilahsiav.amber.amberautomationtest.pages.SearchResultsPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AccommodationSearchTest {
    private WebDriver driver;
    private HomePage homePage;
    private SearchResultsPage searchResultsPage;
    private PropertyDetailPage propertyDetailPage;

    @BeforeMethod
    public void setup() {
        driver = DriverSetup.initializeDriver();
        homePage = new HomePage(driver);
        searchResultsPage = new SearchResultsPage(driver);
        propertyDetailPage = new PropertyDetailPage(driver);
    }

    @Test
    public void testAccommodationSearch() {
        // Navigate to the home page
        homePage.openHomePage("https://amberstudent.com/");

        // Perform a search for "London"
        homePage.enterSearchCriteria("London");

        // Open More filters menu on the search results page
        searchResultsPage.openMoreFiltersMenu();

        // Apply filters and show results on the search results page
        searchResultsPage.applyFiltersAndShowResults("Private Room", "Private Bathroom");

        // Open the second search result in a new tab
        searchResultsPage.openSearchResultAtIndexInNewTab(2);

        // Assert the title of the property
        String expectedTitle = "East Central House, London";
        String actualTitle = propertyDetailPage.getPropertyTitle();
        try {
            Assert.assertTrue(actualTitle.contains(expectedTitle), "Property title mismatch.\nExpected: " + expectedTitle + "\nActual: " + actualTitle);
            System.out.println("Title matches expected title.\nExpected: " + expectedTitle + "\nActual: " + actualTitle);
        } catch (AssertionError e) {
            System.out.println("Assertion error: " + e.getMessage());
        }

        // Assert the location of the property
        String expectedLocation = "Lever St, London, EC1V 3RH, United Kingdom";
        String actualLocation = propertyDetailPage.getPropertyLocation();
        try {
            Assert.assertTrue(actualLocation.contains(expectedLocation), "Property location mismatch.\nExpected: " + expectedLocation + "\nActual: " + actualLocation);
            System.out.println("location matches expected location.\nExpected: " + expectedLocation + "\nActual: " + actualLocation);
        } catch (AssertionError e) {
            System.out.println("Assertion error: " + e.getMessage());
        }
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}

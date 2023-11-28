# Amber Automation Test Suite

This test suite is a Maven-based Selenium WebDriver project using TestNG in Java. It is designed to automate test cases for the Amber Student accommodation service.

## Prerequisites

Before running the test suite, ensure you have the following installed:

- Java JDK 17 or higher
- Maven 3.6.3 or higher
- Google Chrome Browser
- ChromeDriver compatible with the installed Chrome version

## Setup

1. Clone the repository to your local machine.
2. Navigate to the root directory of the project where the `pom.xml` file is located.
3. Make sure the ChromeDriver executable is in your system's PATH or specify its path in the `DriverSetup.java` file.

## Running Tests

To run the tests, execute the following command from the root directory of the project:

```
mvn clean test
```
This will trigger the execution of all tests in the suite. TestNG will automatically pick up the tests based on the annotations.

## Test Cases
The suite includes the following test cases:
- <b><u>AccommodationSearchTest</u></b>: Searches for accommodation in London with filters for "Private Room" and "Private Bathroom", and verifies the title and location of the second search result.
- <b><u>CityListVerificationTest</u></b>: Verifies that the list of popular cities is unique across all countries listed on the homepage.

## Test Reports
After the test execution, you can find the TestNG reports in the following directory:
```
target/surefire-reports
```
The reports include detailed information about the execution results of each test case.

## Acknowledgments
This project has been carried out as part of a Take-Home assignment by [Amber Student](https://amberstudent.com/) interview process.

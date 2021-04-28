package com.unideb.stepdef;

import static org.testng.Assert.assertEquals;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.unideb.TestRunner;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;

public class StepDefinitionYTSearch extends TestRunner {

    public static final String USERNAME = System.getenv("BROWSERSTACK_USERNAME");
    public static final String AUTOMATE_KEY = System.getenv("BROWSERSTACK_ACCESS_KEY");
    public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";


    private void agree() {
        WebDriverWait wait = new WebDriverWait(driver,5);
        WebElement agreeButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("button.VfPpkd-LgbsSe")));
        agreeButton.click();
    }

    @Given("^I have opened the browser$")
    public void openBrowser() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("browser", "Chrome");
        caps.setCapability("browser_version", "85.0");
        caps.setCapability("os", "Windows");
        caps.setCapability("os_version", "10");
        caps.setCapability("resolution", "1440x900");
        caps.setCapability("name", "Bstack Search Test");
        caps.setCapability("browserstack.local", "true");
        driver = new RemoteWebDriver(new URL(URL), caps);
    }

    @When("I open the YouTube {string} website")
    public void goToYT(String fromurl) {
        driver.navigate().to(fromurl);
        agree();
    }

    @When("^I maximize the window$")
    public void maximizeWindow() {
        driver.manage().window().maximize();
    }

    @When("I enter {string} in the search bar")
    public void searchRick(String searchwords) {
        WebDriverWait wait = new WebDriverWait(driver,5);
        WebElement searchBar = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input#search")));
        searchBar.sendKeys(searchwords);
        WebElement searchButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#search-icon-legacy")));
        searchButton.click();
    }

    @Then("The title element {string} should be {string}")
    public void getElementText(String titleelement, String title) {
        WebDriverWait wait = new WebDriverWait(driver,5);
        WebElement videoTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(titleelement)));
        assertEquals(videoTitle.getText(), title);
    }

    @After
    public void after(Scenario scenario) {
        if (driver != null) {
            driver.quit();
        }
    }
    
}

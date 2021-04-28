package com.unideb.stepdef;

import static org.testng.Assert.assertNotEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.unideb.TestRunner;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;

public class StepDefinitionYTSkipAd extends TestRunner {

    public static final String USERNAME = System.getenv("BROWSERSTACK_USERNAME");
    public static final String AUTOMATE_KEY = System.getenv("BROWSERSTACK_ACCESS_KEY");
    public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";

    private void agree() {
        WebDriverWait wait = new WebDriverWait(driver,10);
        WebElement agreeButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button.VfPpkd-LgbsSe")));

        agreeButton.click();
    }

    @Given("^I have opened the browser for ad test$")
    public void openBrowser() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("browser", "Chrome");
        caps.setCapability("browser_version", "85.0");
        caps.setCapability("os", "Windows");
        caps.setCapability("os_version", "10");
        caps.setCapability("resolution", "1440x900");
        caps.setCapability("name", "Bstack Skip ad Test");
        caps.setCapability("browserstack.local", "true");
        driver = new RemoteWebDriver(new URL(URL), caps);
    }

    @When("I open the YouTube {string} website for ad test")
    public void goToYT(String fromurl) {
        driver.navigate().to(fromurl);
        agree();
    }

    @When("^I maximize the window for ad test$")
    public void maximizeWindow() {
        driver.manage().window().maximize();
    }

    @Then("^Skip the ad$")
    public void checkVideo() {
        WebDriverWait wait = new WebDriverWait(driver,15);
        WebElement skipButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#skip-button\\:6 > span > button")));

        WebElement video = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#movie_player > div.html5-video-container > video")));
        String adsrc = video.getAttribute("src");

        skipButton.click();

        video = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#movie_player > div.html5-video-container > video")));
        String videosrc = video.getAttribute("src");

        assertNotEquals(adsrc,videosrc);
    }

    @After
    public void after(Scenario scenario) {
        if (driver != null) {
            driver.quit();
        }
    }
}

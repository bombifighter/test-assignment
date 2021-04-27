package com.unideb.stepdef;

import static org.testng.Assert.assertNotEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.unideb.TestRunner;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class StepDefinitionYTSkipAd extends TestRunner {

    private void agree() {
        WebDriverWait wait = new WebDriverWait(driver,10);
        WebElement agreeButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button.VfPpkd-LgbsSe")));

        agreeButton.click();
    }

    @Given("^I have opened the browser for ad test$")
    public void openBrowser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
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
        WebDriverWait wait = new WebDriverWait(driver,10);
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
            driver.close();
        }
    }
}

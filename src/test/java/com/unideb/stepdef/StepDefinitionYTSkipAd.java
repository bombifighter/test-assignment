package com.unideb.stepdef;

import static org.testng.Assert.assertEquals;

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

public class StepDefinitionYTSkipAd extends TestRunner {

    private void agree() {
        WebElement agreeButton = driver.findElement(By.cssSelector("button.VfPpkd-LgbsSe"));
        agreeButton.click();
    }

    @Given("^I have opened the browser$")
    public void openBrowser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
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

    @When("I open the video {int}")
    public void openVideo(int number) {
        WebElement video = driver.findElement(By.cssSelector("#contents > ytd-rich-item-renderer:nth-child(" + number + ")"));
        video.click();

    }

    @When("^I click skip ad button$")
    public void skipAd() {
        WebElement skipButton = driver.findElement(By.cssSelector("#skip-button\\:6 > span > button"));
        skipButton.click();

    }

    @Then("^The ad replaced by the video$")
    public void checkVideo() {
        WebElement video = driver.findElement(By.cssSelector("#movie_player > div.html5-video-container > video"));

    }

    @After
    public void after(Scenario scenario) {
        if (driver != null) {
            driver.close();
        }
    }
}

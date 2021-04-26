package com.unideb.stepdef;

import com.unideb.TestRunner;
import io.cucumber.java.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.testng.Assert.assertEquals;

public class StepDefinitionYTTranscript extends TestRunner {

    private void agreeCookies() {
        WebElement agreeButton = driver.findElement(By.cssSelector("button.VfPpkd-LgbsSe"));
        agreeButton.click();
    }

    @Given("^I have opened the browser for transcript test$")
    public void openBrowserYTTranscript() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @When("^I maximize the window on transcript test$")
    public void maximizeWindowYTTranscript() {
        driver.manage().window().maximize();
    }

    @When("I open the YouTube video from {string}")
    public void goToVideo(String fromurl) {
        driver.navigate().to(fromurl);
        agreeCookies();
        waitAndSkipAd();
        skipYTPremium();
    }

    @When("^I open the transcript section$")
    public void openTranscript() {
        WebDriverWait wait = new WebDriverWait(driver,5);
        WebElement moreOptions = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#button")));
        moreOptions.click();
        WebElement transcriptButton = driver.findElement(By.cssSelector("#items > ytd-menu-service-item-renderer > tp-yt-paper-item"));
        transcriptButton.click();
    }

    @Then("^Transcript element appears$")
    public void getTranscriptTitle() {
        WebElement transcriptTitle = driver.findElement(By.cssSelector("#title > yt-formatted-string"));
        assertEquals(transcriptTitle.getText(), "Transcript");
    }

    private void waitAndSkipAd() {
        WebDriverWait wait = new WebDriverWait(driver,15);
        WebElement skipAdButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#skip-button\\:6 > span > button")));
        skipAdButton.click();
    }

    private void skipYTPremium() {
        WebDriverWait wait = new WebDriverWait(driver,5);
        WebElement skipPremiumButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#dismiss-button > a > tp-yt-paper-button")));
        skipPremiumButton.click();
    }

    @Before
    public void before(Scenario scenario) {
        System.out.println("------------------------------");
        System.out.println("Starting - " + scenario.getName());
        System.out.println("------------------------------");
    }

    @After
    public void after(Scenario scenario) {
        System.out.println("------------------------------");
        System.out.println(scenario.getName() + " Status - " + scenario.getStatus());
        System.out.println("------------------------------");
        if (driver != null) {
            driver.close();
        }
    }

    @BeforeStep
    public void beforeStep() {
        System.out.println("------------------------------");
        System.out.println("before step");
        System.out.println("------------------------------");
    }

    @AfterStep
    public void afterStep() {
        System.out.println("------------------------------");
        System.out.println("after step");
        System.out.println("------------------------------");
    }
}

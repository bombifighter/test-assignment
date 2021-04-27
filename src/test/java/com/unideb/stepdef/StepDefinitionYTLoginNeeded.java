package com.unideb.stepdef;

import static org.testng.Assert.assertEquals;

import io.cucumber.java.en.And;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.unideb.TestRunner;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class StepDefinitionYTLoginNeeded extends TestRunner {

    private void agree() {
        WebElement agreeButton = driver.findElement(By.cssSelector("button.VfPpkd-LgbsSe"));
        agreeButton.click();
    }

    @Given("^I have opened the browser for settings test$")
    public void openBrowserYTLoginNeeded() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @When("I open the YouTube {string} website for YT Login needed test")
    public void goToYT(String fromurl) {
        driver.navigate().to(fromurl);
        agree();
    }

    @When("^I maximize the window on YT Login needed test$")
    public void maximizeWindow() {
        driver.manage().window().maximize();
    }

    @When("I click on the {string} button")
    public void clickButton(String button){
        WebElement theButton = driver.findElement(By.xpath(button));
        theButton.click();
    }

    @When("^I click on the Login button$")
    public void clickLogin(){
        WebElement loginButton = driver.findElement(By.cssSelector("#message-button"));
        loginButton.click();
    }

    @Then("The destination URL should be {string}")
    public void getURL(String url) {
        assertEquals(driver.getCurrentUrl(), url);
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

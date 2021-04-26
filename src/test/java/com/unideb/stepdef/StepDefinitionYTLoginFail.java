package com.unideb.stepdef;

import static org.testng.Assert.assertEquals;

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


public class StepDefinitionYTLoginFail extends TestRunner {

    private void agree() {
        WebElement agreeButton = driver.findElement(By.cssSelector("button.VfPpkd-LgbsSe"));
        agreeButton.click();
    }

    @Given("^I have opened the browser for YT Login fail$")
    public void openBrowserYTLoginFail() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @When("I open the YouTube {string} website for YT Login Fail")
    public void goToYTFailLogin(String fromurl) {
        driver.navigate().to(fromurl);
        agree();
    }

    @When("^I maximize the window on YT Login Fail test$")
    public void maximizeWindowYTLoginFail() {
        driver.manage().window().maximize();
    }

    @When("^I click the login button$")
    public void clickLogin() {
        WebElement loginButton = driver.findElement(By.xpath("//*[@id=\"buttons\"]/ytd-button-renderer/a"));
        loginButton.click();
    }

    @When("I write {string} to the username field")
    public void writeWrongUsername(String wrongusername) {
        WebElement usernameField = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div/div[2]/div/div/div[2]/div/div[1]/div/form/span/section/div/div/div[1]/div/div[1]/div/div[1]/input"));
        usernameField.sendKeys(wrongusername);
    }

    @When("^I click next button$")
    public void clickNext() {
        WebElement loginButton = driver.findElement(By.xpath("//*[@id=\"identifierNext\"]/div/button/div[2]"));
        loginButton.click();
    }

    @Then("The {string} should be {string}")
    public void getResponseText(String responsetext, String text) {
        WebDriverWait wait = new WebDriverWait(driver,5);

        WebElement barmi = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(responsetext)));
        String response = barmi.getText();
        System.out.println(response);
        assertEquals(response, text);
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

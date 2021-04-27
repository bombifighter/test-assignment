package com.unideb.stepdef;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.unideb.TestRunner;


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
        WebDriverWait wait = new WebDriverWait(driver,5);
        WebElement loginButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"buttons\"]/ytd-button-renderer/a")));
        loginButton.click();
    }

    @When("I write {string} to the username field")
    public void writeWrongUsername(String wrongusername) {
        WebDriverWait wait = new WebDriverWait(driver,5);
        WebElement usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div[1]/div[2]/div/div[2]/div/div/div[2]/div/div[1]/div/form/span/section/div/div/div[1]/div/div[1]/div/div[1]/input")));
        usernameField.sendKeys(wrongusername);
    }

    @When("^I click next button$")
    public void clickNext() {
        WebDriverWait wait = new WebDriverWait(driver,5);
        WebElement loginButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"identifierNext\"]/div/button/div[2]")));
        loginButton.click();
    }

    @Then("The {string} should be {string}")
    public void getResponseText(String responsetext, String text) {
        WebDriverWait wait = new WebDriverWait(driver,5);
        WebElement resp = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(responsetext)));
        String response = resp.getText();
        assertEquals(response, text);
    }

}

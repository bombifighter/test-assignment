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

public class StepDefinitionYTLoginNeeded extends TestRunner {

    private void agree() {
        WebDriverWait wait = new WebDriverWait(driver,5);
        WebElement agreeButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button.VfPpkd-LgbsSe")));
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
        WebDriverWait wait = new WebDriverWait(driver,5);
        WebElement theButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(button)));
        theButton.click();
    }

    @When("^I click on the Login button$")
    public void clickLogin(){
        WebDriverWait wait = new WebDriverWait(driver,5);
        WebElement loginButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/ytd-app/div/ytd-page-manager/ytd-browse[2]/ytd-two-column-browse-results-renderer/div[1]/ytd-section-list-renderer/div[2]/ytd-item-section-renderer/div[3]/ytd-background-promo-renderer/div[2]/ytd-button-renderer/a/tp-yt-paper-button")));
        loginButton.click();
    }

    @Then("^The destination page title should be 'Sign in'$")
    public void getTitle() {
        WebDriverWait wait = new WebDriverWait(driver,5);
        WebElement text = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div[1]/div[2]/div/div[2]/div/div/div[1]/div/h1/span")));

        assertEquals(text.getText(), "Sign in");
    }

}

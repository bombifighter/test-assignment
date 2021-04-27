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

public class StepDefinitionYTSearch extends TestRunner {

    private void agree() {
        WebDriverWait wait = new WebDriverWait(driver,5);
        WebElement agreeButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("button.VfPpkd-LgbsSe")));
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
    
}

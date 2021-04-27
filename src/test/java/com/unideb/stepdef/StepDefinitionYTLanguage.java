package com.unideb.stepdef;

import com.unideb.TestRunner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import static org.testng.Assert.assertEquals;

public class StepDefinitionYTLanguage extends TestRunner {
    public static final String USERNAME = System.getenv("USERNAME");
  public static final String AUTOMATE_KEY = System.getenv("AUTOMATE_KEY");
  public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + System.getenv("URL");

    private void agreeCookies() {
        WebDriverWait wait = new WebDriverWait(driver,5);
        WebElement agreeButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("button.VfPpkd-LgbsSe")));
        agreeButton.click();
    }

    @Given("^I have opened the browser for language test$")
    public void openBrowserYTTranscript() {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("browser", "Chrome");
        caps.setCapability("browser_version", "85.0");
        caps.setCapability("os", "Windows");
        caps.setCapability("os_version", "10");
        caps.setCapability("resolution", "1440x900");
        caps.setCapability("name", "Bstack-[Java] Sample Test");
        driver = new RemoteWebDriver(new URL(URL), caps);
    }

    @When("^I maximize the window for language test$")
    public void maximizeWindowYTTranscript() {
        driver.manage().window().maximize();
    }

    @When("^I open YouTube$")
    public void openYT() {
        driver.navigate().to("https://www.youtube.com/");
        agreeCookies();
    }

    @When("I change the language to {string}")
    public void changeLanguage(String language) {
        WebDriverWait wait = new WebDriverWait(driver,5);
        WebElement moreOptions = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/ytd-app/div/div/ytd-masthead/div[3]/div[3]/div[2]/ytd-topbar-menu-button-renderer[2]/div/a")));
        moreOptions.click();
        WebElement languageMenuButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/ytd-app/ytd-popup-container/tp-yt-iron-dropdown/div/ytd-multi-page-menu-renderer/div[3]/div[1]/yt-multi-page-menu-section-renderer[1]/div[2]/ytd-compact-link-renderer[1]/a/tp-yt-paper-item")));
        languageMenuButton.click();
        WebElement transcriptButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='" + language + "']")));
        transcriptButton.click();
    }

    @Then("Login button contains {string}")
    public void loginButtonContains(String text) {
        WebDriverWait wait = new WebDriverWait(driver,5);
        WebElement loginButtonText = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/ytd-app/div/div/ytd-masthead/div[3]/div[3]/div[2]/ytd-button-renderer/a/tp-yt-paper-button/yt-formatted-string")));
        assertEquals(loginButtonText.getText(), text);
    }

}

package stepdefinitions;

import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.After;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.sql.Time;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class StepDefinitions {

    private WebDriver driver;

    public void startDriver(String url){

        System.setProperty("webdriver.chrome.driver", new File("C://LexisNexis//src//test//resources//Driver//chromedriver.exe").getPath());
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.get(url);
        driver.manage().window().maximize();

    }

    @After
    public void tearDown(Scenario scenario) throws IOException {

         driver.quit();

    }

    @Given("User is on {string}")
    public void userNavigation(String url) throws InterruptedException {
        startDriver(url);

        Wait<WebDriver> wait = new WebDriverWait(driver, 60);
        WebElement acceptCookies = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='onetrust-accept-btn-handler']")));
        Actions builder = new Actions(driver);
        builder.moveToElement(acceptCookies).click().perform();
        Thread.sleep(10000);
    }



    @When("User clicks on link {string}")
    public void userClicksOnLinkLinks(String link) throws Exception{
        Wait<WebDriver> wait = new WebDriverWait(driver, 60);
        WebElement fsLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='" + link.trim() + "' and @class= 'score-button btn-clickable-area']")));
        Actions builder = new Actions(driver);
        builder.moveToElement(fsLink).click().perform();
    }

    @Then("user should be able to validate the he is navigated to the page with {string}")
    public void userShouldBeAbleToValidateTheHeIsNavigatedToThePageWith(String title) {

        Wait<WebDriver> wait = new WebDriverWait(driver, 60);
        WebElement fsLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='score-hero horizontal']/h1[contains(text(),'" + title +"')]")));
        driver.navigate().back();

    }


    @When("User clicks on link Choose Your Industry tab")
    public void userClicksOnLinkChooseYourIndustryTab() {

        Wait<WebDriver> wait = new WebDriverWait(driver, 60);
        WebElement fsLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Choose Your Industry']")));
        Actions builder = new Actions(driver);
        builder.moveToElement(fsLink).click().perform();
    }

    @Then("user should be able to validate the he can click on submenu {string}")
    public void userShouldBeAbleToValidateTheHeCanClickOnSubmenu(String submenu) {
        Wait<WebDriver> wait = new WebDriverWait(driver, 60);

        String xpathForMenu = "//a[contains(@data-industryname,'Financial Services') and @class='subpage-link']";
        WebElement fsMenuLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpathForMenu)));
        Actions builder = new Actions(driver);
        builder.moveToElement(fsMenuLink).click().perform();

        String xpath = "//a[text()='View Financial Services  Home']/parent::div[@class='section-title-wraper']/following-sibling::ul/descendant::div[text()='" + submenu + "']/parent::a";
        WebElement fsSubMenuLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
        builder.moveToElement(fsSubMenuLink).click().perform();

        WebElement fsLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='score-hero horizontal']/h1[contains(text(),'" + submenu +"')]")));
        driver.navigate().back();
    }


}

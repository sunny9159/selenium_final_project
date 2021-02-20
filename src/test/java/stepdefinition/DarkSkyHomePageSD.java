package stepdefinition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import framework.webPages.DarkSkyAPI;
import framework.webPages.DarkSkyHomePage;
import framework.webPages.DarkSkyRegisterPage;
import org.testng.Assert;

public class DarkSkyHomePageSD {

    private DarkSkyHomePage darkSkyHomePage = new DarkSkyHomePage();
    private DarkSkyAPI darkSkyAPI = new DarkSkyAPI();
    private DarkSkyRegisterPage darkSkyRegisterPage = new DarkSkyRegisterPage();

    @Given("^I am on Darksky Home Page$")
    public void onDarkSkyHomePage(){

        String expectedUrl = "https://darksky.net/";
        String actualUrl = darkSkyHomePage.getPageURL();

        boolean isOnHomepage = actualUrl.startsWith(expectedUrl);

        Assert.assertTrue(isOnHomepage,"Not on home page");

    }

    @When("^I click on Dark Sky API link$")
    public void iClickOnApiLink(){

        darkSkyHomePage.clickOnDarkSkyAPI();
    }

    @When("^I click on Sign Up button$")
    public void iClickOnSignUpButton() throws InterruptedException {

        darkSkyAPI.clickOnSignUpButton();
    }

    @When("^I click on register button$")
    public void iClickOnRegisterButton() throws InterruptedException {
        darkSkyAPI.clickOnSignUpButton();
        darkSkyRegisterPage.clickOnRegisterButton();

    }

    @Then("^I verify I am on Register page by asserting Register header$")
    public void iVerifyIAmOnRegisterPageByAssertingRegisterHeader() {
        String expectedHeaderText = "Register";
        String actualHeaderText = darkSkyRegisterPage.getRegisterHeaderText();

        Assert.assertEquals(expectedHeaderText, actualHeaderText, "Header text doesn't match");
    }
}

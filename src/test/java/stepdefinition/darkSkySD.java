package stepdefinition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import framework.webPages.*;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;

public class darkSkySD {

    private HomePage homepage = new HomePage();
    private BasePage basePage = new BasePage();
    private DarkSkyLoginPage darkskyloginpage = new DarkSkyLoginPage();
    private DarkSkyPage darkskypage = new DarkSkyPage();
    private DarkSkyHoursPage darkSkyHoursPage= new DarkSkyHoursPage();


    @Given("^I am on the darkSky home page$")
    public void iAmOnDarkSkyHomePage() {
        Assert.assertTrue(SharedSD.getDriver().getCurrentUrl().contains("https://darksky.net/"));
    }


    @When("^I am on darkSky Register page$")
    public void goToRegisterPage() {
        darkskypage.darkSkyApiPage();
//        darkskypage.signUp();

    }

    @Then("^I click on signUp Button$")
    public void clickOnSignUpButton(String button) {
        switch (button) {
            case "signUp":
                darkskyloginpage.clickOnRegisterButton();
                break;
        }
    }


    @When("^I click on Register button$")
    public void clickOnSignupButton() throws InterruptedException {
        darkskypage.signUp();

    }


    @Then("^I verify i'm still on Register page$")
    public void iVerifyIMStillOnRegisterPage() {


        Assert.assertEquals(SharedSD.getDriver().getTitle(),"Dark Sky API: Register");

    }

    @Then("^I verify current temp is not greater or less then temps from daily timeline$")
    public void currentTempIsNotGreaterOrLess() {
        int minTemp = darkskypage.getWebTempList().get(0);
        int maxTemp = darkskypage.getWebTempList().get(darkskypage.getWebTempList().size()-1);
        Assert.assertTrue(minTemp<= darkskypage.getCurrentTemp() && darkskypage.getCurrentTemp() <= maxTemp );
    }


    @When("^I expand todays timeline$")
    public void todaysTimeline() throws InterruptedException {

        JavascriptExecutor js = (JavascriptExecutor) SharedSD.getDriver();
        js.executeScript("window.scrollBy(0,500)");
        Thread.sleep(2000);

        darkskypage.setTodaysTemp();


    }

    @Then("^I verify lowest and highest temp is displayed correctly$")
    public void iVerifyLowestAndHighestTempIsDisplayedCorrectly() throws Throwable {
        String miniumTemp = darkskypage.setMinTemp();
        String maxTemp = darkskypage.setMaxTemp();
        String lowest = darkskypage.setLowest();
        String highest = darkskypage.setHighest();
        Thread.sleep(2000);

        Assert.assertTrue(darkskypage.isLowestTempDisplayCorrectly());
        Thread.sleep(2000);

        Assert.assertTrue(darkskypage.isHighestTempDisplayCorrectly());
        Thread.sleep(2000);

        System.out.println("The expected min temp:" + miniumTemp + "and the actual lowest temp:" + lowest );
        System.out.println("The expected max temp:" + maxTemp + "and actual highest temp:" +highest );



    }

    @Then("^ I verify timeline is displayed with two hours incremented$")
    public void iVerifyTimelineIsDisplayedWithTwoHoursIncremented() {
        darkSkyHoursPage.allHours();
        darkSkyHoursPage.getAllHours();
        //Assert.assertEquals(darkSkyHoursPage.getAllHours(),"Time is increment are correctly");
         // darkSkyHoursPage.getAllHours();



    }


    private class HomePage {
    }
}

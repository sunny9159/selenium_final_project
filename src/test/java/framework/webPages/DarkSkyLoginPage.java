package framework.webPages;

import org.openqa.selenium.By;

public class DarkSkyLoginPage extends BasePage {

    private By registerButton = By.xpath("/button[contains(text(),'Register')]");
    private By pageHeader = By.xpath("/h1[@class='stand-alone title']");


    public void clickOnRegisterButton() {
        clickOn(registerButton);
    }

    public String getPageHeader() {

        return getTextFromElement(pageHeader);

    }

}
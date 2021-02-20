package framework.webPages;

import org.openqa.selenium.By;

public class DarkSkyRegisterPage extends BasePage {

    private By registerButton = By.xpath("//button[contains(text(),'Register')]");
    private By registrationHeaderText = By.xpath("//h1[contains(text(),'Register')]");

    public void clickOnRegisterButton(){
        clickOn(registerButton);
    }

    public String getRegisterHeaderText(){
        return getTextFromElement(registrationHeaderText);
    }
}

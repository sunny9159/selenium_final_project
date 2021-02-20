package framework.webPages;

import org.openqa.selenium.By;

public class DarkSkyAPI extends BasePage{

    private By signUpButton = By.xpath("//a[@class='button filled']");

    public void clickOnSignUpButton() throws InterruptedException {
        clickOn(signUpButton);
        Thread.sleep(5000);
    }
}

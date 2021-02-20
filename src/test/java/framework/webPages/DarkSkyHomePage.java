package framework.webPages;

import org.openqa.selenium.By;

public class DarkSkyHomePage extends BasePage {

    private By darkSkyAPI = By.xpath("//div[@class = 'inner']//a[contains(text() ,'Dark Sky API')]");

    public void clickOnDarkSkyAPI(){
        clickOn(darkSkyAPI);
    }
}

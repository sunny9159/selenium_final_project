package framework.webPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DarkSkyPage extends BasePage {

    private By darkSkyApi = By.xpath("//div[@class='inner']//a[contains(text(),'Dark Sky API')]");
    private By signUpField = By.xpath("//a[@class='button filled']");
    private By registerPageVerify= By.xpath("/h1[@class='stand-alone title']");
    private By todaysTemp = By.xpath("//body[@class='forecast']/div[@id='week']/a[1]");
    private By currentTime= By.xpath("//span[@class='hour first']");
    private By minTemp = By.cssSelector("body.forecast:nth-child(2) div.center:nth-child(7) a.day.revealed:nth-child(2) span.tempRange > span.minTemp");
    private By maxTemp = By.xpath("//span[@class='maxTemp']");
    private By lowest = By.xpath("//span[@class='temp']");
    private By highest = By.xpath("//div[@class='dayDetails revealed']//span[@class='temp']");
    private By currentTempOfDarksky= By.xpath("//span[@class='summary swap']");
    private By allTemperatureOfDarkSky= By.cssSelector(".temps  span:last-child");
    private By allHours = By.xpath("div[@id='timeline']//div[@class='hours']/*/span");

    public void darkSkyApiPage() {
       clickOn(darkSkyApi);
    }

    public void signUp() {
        clickOn(signUpField);
    }

    public void setRegisterPageVerify(){

    }

    public void setTodaysTemp(){
        clickOn(todaysTemp);
    }

    public void setCurrentTime(){
        getTextFromElement(currentTime);

    }

    public String setMinTemp(){
        return getTextFromElement(minTemp);
    }

    public String setMaxTemp(){ return getTextFromElement(maxTemp);

    }

    public String setLowest(){
        return getTextFromElement(lowest);

    }

    public String setHighest(){
        return getTextFromElement(highest);
    }
    public boolean isLowestTempDisplayCorrectly() {

        return isElementDisplayed(lowest);
    }

    public boolean isHighestTempDisplayCorrectly() {

        return isElementDisplayed(highest);
    }

//    public String currentTempofDarksky(){
//        return getTextFromElement(currentTempOfDarksky);
//    }


    public int getCurrentTemp(){
        String current=getTextFromElement(currentTempOfDarksky);
        int temp = Integer.parseInt(current.substring(0, 2));
        System.out.println("Current temp is " + temp);
        return temp;
    }

    public List<Integer> getWebTempList(){
        List<Integer> listOfIntTemp=new ArrayList<>();
        List<WebElement> allTempeatureOfTimeline=webActions(allTemperatureOfDarkSky);
        for (WebElement tempp : allTempeatureOfTimeline) {
            String Temp1 = tempp.getText();
            int allTempParse = Integer.parseInt(Temp1.substring(0, 2));
            listOfIntTemp.add(allTempParse);
        }
        Collections.sort(listOfIntTemp);
//        System.out.println(listOfIntTemp);
        System.out.println("Lowest temp: " + listOfIntTemp.get(0));
        System.out.println("Highest temp: " + (listOfIntTemp.get(listOfIntTemp.size()-1)));
        return listOfIntTemp;
    }



    public List<WebElement> getAllTemps() {

        return webActions(allTemperatureOfDarkSky);
    }



}

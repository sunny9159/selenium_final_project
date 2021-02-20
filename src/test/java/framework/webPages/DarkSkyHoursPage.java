package framework.webPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class DarkSkyHoursPage extends BasePage {

    private By allHours = By.xpath("div[@id='timeline']//div[@class='hours']/*/span");

    public List<WebElement> getAllHours() {
        return webActions(allHours);
    }

    public String allHours() {

        SimpleDateFormat sdf = new SimpleDateFormat("ha");
        ArrayList<String> list = new ArrayList<>();

        Calendar calendar = Calendar.getInstance();

        list.add("NOW");
        int twoHours = 11;

        for (
                int i = 0;
                i < twoHours; ) {
            calendar.add(Calendar.HOUR_OF_DAY, 2);
            i++;
        }
            System.out.println(list);

            List<WebElement> elements = getAllHours();
            List<String> websiteTime = new ArrayList<String>();

            for (
                    int i = 1;
                    i < 11; i++) {
                String time = list.get(i).toUpperCase();
                websiteTime.add(time);
            }
       return allHours();

    }

    }


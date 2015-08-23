package CALCULATIONS_TEST_SETS.SHORT_TERM_PARKING_LOT;

import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.concurrent.TimeUnit;


/**
 * Created by LewdBenign on 21.08.2015.
 */
public class STP_COMPLETE_TESTS_SET {
    private WebDriver driver;
    private String baseUrl, Lot, action;
    private String entryDate, entryTime;
    private String leavingDate, leavingTime;

    public void sleep(int x){
        try {
            Thread.sleep(x*1000);
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }

    @Before
    public void setUp(){
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    public void calc(String eD,
                     String eM,
                     String eY,
                     String eH,
                     String eMi,
                     String eAP,
                     String lD,
                     String lM,
                     String lY,
                     String lH,
                     String lMi,
                     String lAP){
        baseUrl = "http://www.grr.org/parking-calculator.php?";
        Lot = "Lot=STP"; //SHORT-TERM PARKING LOT
        action = "&action=calculate&Submit=Calculate#calculator";
        entryDate = ("&EntryDate=" +eM +"%2F" +eD +"%2F" +eY);
        entryTime = ("&EntryTime=" +eH +"%3A" +eMi +"+" +eAP);
        leavingDate = ("&ExitDate=" +lM +"%2F" +lD +"%2F" +lY);
        leavingTime= ("&ExitTime=" +lH +"%3A" +lMi +"+" +lAP);

        //GO TO CALCULATOR AND CALCULATE
        driver.get(baseUrl + Lot + entryDate + entryTime + leavingDate + leavingTime + action);
    }


    @Test
    public void TEST_FUNC_002(){
        //ENTRY DATE AND TIME
        String eDay = "16";
        String eMonth = "04";
        String eYear = "2019";
        String eHour = "10";
        String eMinutes = "00";
        String eAmPm = "AM";

        //LEAVING DATE AND TIME
        String lDay = "16";
        String lMonth = "04";
        String lYear = "2019";
        String lHour = "10";
        String lMinutes = "30";
        String lAmPm = "AM";

        //EXPECTED RESULT
        String expectedResult = "$2.00 (0D/0H/30M)";

        //CALCULATE
        this.calc(eDay, eMonth, eYear, eHour, eMinutes, eAmPm,
                lDay, lMonth, lYear, lHour, lMinutes, lAmPm);

        //COMPARE EXPECTED AND ACTUAL RESULTS
        WebElement costField = driver.findElement(By.xpath("/html/body/div[4]/div/div[5]/form/ul/li[7]/div/div[2]/div"));
        Assert.assertEquals(expectedResult, costField.getText());

        //WAIT FOR FEW SECONDS
        this.sleep(3);
    }

    @Test
    public void TEST_FUNC_008(){
        //ENTRY DATE AND TIME
        String eDay = "16";
        String eMonth = "04";
        String eYear = "2019";
        String eHour = "10";
        String eMinutes = "00";
        String eAmPm = "AM";

        //LEAVING DATE AND TIME
        String lDay = "16";
        String lMonth = "04";
        String lYear = "2019";
        String lHour = "05";
        String lMinutes = "31";
        String lAmPm = "PM";

        //EXPECTED RESULT
        String expectedResult = "$15.00 (0D/7H/31M)";

        //CALCULATE
        this.calc(eDay, eMonth, eYear, eHour, eMinutes, eAmPm,
                lDay, lMonth, lYear, lHour, lMinutes, lAmPm);

        //COMPARE EXPECTED AND ACTUAL RESULTS
        WebElement costField = driver.findElement(By.xpath("/html/body/div[4]/div/div[5]/form/ul/li[7]/div/div[2]/div"));
        Assert.assertEquals(expectedResult, costField.getText());

        //WAIT FOR FEW SECONDS
        this.sleep(3);
    }

    @Test
    public void TEST_FUNC_016(){
        //ENTRY DATE AND TIME
        String eDay = "16";
        String eMonth = "04";
        String eYear = "2019";
        String eHour = "10";
        String eMinutes = "00";
        String eAmPm = "AM";

        //LEAVING DATE AND TIME
        String lDay = "18";
        String lMonth = "04";
        String lYear = "2019";
        String lHour = "12";
        String lMinutes = "00";
        String lAmPm = "AM";

        //EXPECTED RESULT
        String expectedResult = "$48.00 (2D/2H/0M)";

        //CALCULATE
        this.calc(eDay, eMonth, eYear, eHour, eMinutes, eAmPm,
                lDay, lMonth, lYear, lHour, lMinutes, lAmPm);

        //COMPARE EXPECTED AND ACTUAL RESULTS
        WebElement costField = driver.findElement(By.xpath("/html/body/div[4]/div/div[5]/form/ul/li[7]/div/div[2]/div"));
        Assert.assertEquals(expectedResult, costField.getText());

        //WAIT FOR FEW SECONDS
        this.sleep(3);
    }

    @After
    public void tearDown(){
        //CLOSE BROWSER
        driver.quit();
    }

}

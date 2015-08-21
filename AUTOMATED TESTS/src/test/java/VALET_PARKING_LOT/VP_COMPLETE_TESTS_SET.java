package VALET_PARKING_LOT;

import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.concurrent.TimeUnit;


/**
 * Created by LewdBenign on 21.08.2015.
 */
public class VP_COMPLETE_TESTS_SET {
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
        Lot = "Lot=VP"; //SHORT-TERM PARKING LOT
        action = "&action=calculate&Submit=Calculate#calculator";
        entryDate = ("&EntryDate=" +eM +"%2F" +eD +"%2F" +eY);
        entryTime = ("&EntryTime=" +eH +"%3A" +eMi +"+" +eAP);
        leavingDate = ("&ExitDate=" +lM +"%2F" +lD +"%2F" +lY);
        leavingTime= ("&ExitTime=" +lH +"%3A" +lMi +"+" +lAP);

        //GO TO CALCULATOR AND CALCULATE
        driver.get(baseUrl + Lot + entryDate + entryTime + leavingDate + leavingTime + action);
    }


    @Test
    public void TEST_FUNC_056(){
        //ENTRY DATE AND TIME
        String eDay = "16";
        String eMonth = "04";
        String eYear = "2019";
        String eHour = "01";
        String eMinutes = "00";
        String eAmPm = "AM";

        //LEAVING DATE AND TIME
        String lDay = "16";
        String lMonth = "04";
        String lYear = "2019";
        String lHour = "01";
        String lMinutes = "01";
        String lAmPm = "AM";

        //EXPECTED RESULT
        String expectedResult = "$12.00 (0D/0H/1M)";

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
    public void TEST_FUNC_059(){
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
        String lHour = "06";
        String lMinutes = "00";
        String lAmPm = "AM";

        //EXPECTED RESULT
        String expectedResult = "$18.00 (0D/5H/0M)";

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
    public void TEST_FUNC_064(){
        //ENTRY DATE AND TIME
        String eDay = "16";
        String eMonth = "04";
        String eYear = "2019";
        String eHour = "01";
        String eMinutes = "00";
        String eAmPm = "AM";

        //LEAVING DATE AND TIME
        String lDay = "26";
        String lMonth = "04";
        String lYear = "2019";
        String lHour = "4";
        String lMinutes = "28";
        String lAmPm = "AM";

        //EXPECTED RESULT
        String expectedResult = "$198.00 (10D/3H/28M)";

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
package MAIN_VERIFICATION_TESTS_SET;

import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by LewdBenign on 08.08.2015.
 */
public class SAMPLE_CALCULATION_TEST {
    private WebDriver driver;

    @Before
    public void setUp(){
        driver = new FirefoxDriver();
    }

    @Test
    public void SAMPLE_CALCULATION() {
        //LOAD THE CALCULATOR PAGE
        driver.get("http://www.grr.org/parking-calculator.php");

        new Select(driver.findElement(By.id("Lot"))).selectByVisibleText("Valet Parking");

        //--SELECT ENTRY DATE
        WebElement entryDateButton = driver.findElement(By.xpath("/html/body/div[4]/div/div[5]/form/ul/li[2]/div/div[2]/div/div/span/i"));
        entryDateButton.click();
        //SELECT ENTRY MONTH
        WebElement entryMonthButton = driver.findElement(By.xpath("/html/body/div[8]/ul/li[1]/div/div[1]/table/thead/tr[1]/th[2]"));
        entryMonthButton.click();
        //SELECT ENTRY YEAR
        WebElement entryYearButton = driver.findElement(By.xpath("/html/body/div[8]/ul/li[1]/div/div[2]/table/thead/tr/th[2]"));
        entryYearButton.click();
        //SELECT YEAR 2019
        WebElement EntryYear2019 = driver.findElement(By.xpath("/html/body/div[8]/ul/li[1]/div/div[3]/table/tbody/tr/td/span[11]"));
        EntryYear2019.click();
        //SELECT MONTH APRIL
        entryDateButton.click();
        entryMonthButton.click();
        WebElement entryMonthApril = driver.findElement(By.xpath("/html/body/div[8]/ul/li[1]/div/div[2]/table/tbody/tr/td/span[4]"));
        entryMonthApril.click();
        //SELECT ENTRY DAY 16
        entryDateButton.click();
        WebElement EntryDay16 = driver.findElement(By.xpath("/html/body/div[8]/ul/li[1]/div/div[1]/table/tbody/tr[3]/td[3]"));
        EntryDay16.click();

        //SELECT ENTRY TIME
        WebElement entryTimeButton = driver.findElement(By.xpath("/html/body/div[4]/div/div[5]/form/ul/li[3]/div/div[2]/div/div/span/i"));
        entryTimeButton.click();
        //INPUT ENTRY HOUR
        WebElement entryHourField = driver.findElement(By.xpath("/html/body/div[10]/table/tbody/tr[2]/td[1]/input"));
        entryHourField.click();
        entryHourField.clear();
        entryHourField.sendKeys("9");
        //INPUT ENTRY MINUTES
        WebElement entryMinuteField = driver.findElement(By.xpath("/html/body/div[10]/table/tbody/tr[2]/td[3]/input"));
        entryMinuteField.click();
        entryMinuteField.clear();
        entryMinuteField.sendKeys("1");
        //SELECT ENTRY AM/PM
        WebElement entryTimeAMPM = driver.findElement(By.xpath("/html/body/div[10]/table/tbody/tr[2]/td[5]/input"));
        entryTimeAMPM.click();
        entryTimeAMPM.clear();
        entryTimeAMPM.sendKeys("a");

        //SELECT LEAVING DATE
        WebElement leavingDateButton = driver.findElement(By.xpath("/html/body/div[4]/div/div[5]/form/ul/li[4]/div/div[2]/div/div/span/i"));
        leavingDateButton.click();
        //SELECT LEAVING MONTH
        WebElement leavingMonthButton = driver.findElement(By.xpath("/html/body/div[9]/ul/li[1]/div/div[1]/table/thead/tr[1]/th[2]"));
        leavingMonthButton.click();
        //SELECT LEAVING YEAR
        WebElement leavingYearButton = driver.findElement(By.xpath("/html/body/div[9]/ul/li[1]/div/div[2]/table/thead/tr/th[2]"));
        leavingYearButton.click();
        //SELECT LEAVING YEAR 2019
        WebElement leaving2019Year = driver.findElement(By.xpath("/html/body/div[9]/ul/li[1]/div/div[3]/table/tbody/tr/td/span[11]"));
        leaving2019Year.click();
        //SELECT LEAVING MONTH APRIL
        leavingDateButton.click();
        leavingMonthButton.click();
        WebElement leavingAprilMonth = driver.findElement(By.xpath("/html/body/div[9]/ul/li[1]/div/div[2]/table/tbody/tr/td/span[4]"));
        leavingAprilMonth.click();
        //SELECT LEAVING DAY 16
        leavingDateButton.click();
        WebElement leavingDay16 = driver.findElement(By.xpath("/html/body/div[9]/ul/li[1]/div/div[1]/table/tbody/tr[3]/td[3]"));
        leavingDay16.click();

        //SELECT LEAVING TIME
        WebElement leavingTimeButton = driver.findElement(By.xpath("/html/body/div[4]/div/div[5]/form/ul/li[5]/div/div[2]/div/div/span/i"));
        leavingTimeButton.click();
        //INPUT ENTRY HOUR
        WebElement leavingHourField = driver.findElement(By.xpath("/html/body/div[10]/table/tbody/tr[2]/td[1]/input"));
        leavingHourField.click();
        leavingHourField.clear();
        leavingHourField.sendKeys("10");
        //INPUT ENTRY MINUTES
        WebElement leavingMinuteField = driver.findElement(By.xpath("//html/body/div[10]/table/tbody/tr[2]/td[3]/input"));
        leavingMinuteField.click();
        leavingMinuteField.clear();
        leavingMinuteField.sendKeys("0");
        //SELECT ENTRY AM/PM
        WebElement leavingTimeAMPM = driver.findElement(By.xpath("/html/body/div[10]/table/tbody/tr[2]/td[5]/input"));
        leavingTimeAMPM.click();
        leavingTimeAMPM.clear();
        leavingTimeAMPM.sendKeys("a");


        //FIND AND CLICK CALCULATE BUTTON
        WebElement clickOnCalculateButton = driver.findElement(By.xpath("/html/body/div[4]/div/div[5]/form/ul/li[6]/div/div[2]/input[2]"));
        clickOnCalculateButton.click();

        //VERIFY RESULT
        WebElement verifyErrorDateMessage = driver.findElement(By.id("calcparkingresult"));
        Assert.assertEquals("$12.00 (0D/0H/59M)", verifyErrorDateMessage.getText());

        //PAUSE FOR FEW SECONDS
        try {
            Thread.sleep(3000);
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }

    /*NOT TO CLOSE BROWSER AFTER TESTS
    @After
    public void closureActivities(){
        driver.quit();
    }*/
}

package MAIN_VERIFICATION_TESTS_SET;

import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by LewdBenign on 08.08.2015.
 */
public class SELECT_LEAVING_DATE {
    private WebDriver driver;

    @Before
    public void setUp(){
        driver = new FirefoxDriver();
    }

    @Test
    public void selectLeavingDate() {
        //LOAD THE CALCULATOR PAGE
        driver.get("http://www.grr.org/parking-calculator.php");

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

        //FIND AND CLICK CALCULATE BUTTON
        WebElement clickOnCalculateButton = driver.findElement(By.xpath("/html/body/div[4]/div/div[5]/form/ul/li[6]/div/div[2]/input[2]"));
        clickOnCalculateButton.click();

        //VERIFY RESULT
        WebElement verifyErrorDateMessage = driver.findElement(By.id("calcparkingresult"));
        Assert.assertEquals("Error: Enter Date", verifyErrorDateMessage.getText());

        //PAUSE FOR FEW SECONDS
        try {
            Thread.sleep(3000);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }
    /*NOT TO CLOSE BROWSER AFTER TESTS
    @After
    public void closureActivities(){
        driver.quit();
    }*/
}


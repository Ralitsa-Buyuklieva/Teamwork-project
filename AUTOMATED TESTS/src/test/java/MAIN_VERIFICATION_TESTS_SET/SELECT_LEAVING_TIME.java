package MAIN_VERIFICATION_TESTS_SET;

import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by LewdBenign on 08.08.2015.
 */
public class SELECT_LEAVING_TIME {
    private WebDriver driver;

    @Before
    public void setUp(){
        driver = new FirefoxDriver();
    }

    @Test
    public void selectLeavingTime() {
        //LOAD THE CALCULATOR PAGE
        driver.get("http://www.grr.org/parking-calculator.php");

        //SELECT LEAVING TIME
        WebElement leavingTimeButton = driver.findElement(By.xpath("/html/body/div[4]/div/div[5]/form/ul/li[5]/div/div[2]/div/div/span/i"));
        leavingTimeButton.click();
        //INPUT ENTRY HOUR
        WebElement leavingHourField = driver.findElement(By.xpath("/html/body/div[10]/table/tbody/tr[2]/td[1]/input"));
        leavingHourField.click();
        leavingHourField.clear();
        leavingHourField.sendKeys("9");
        //INPUT ENTRY MINUTES
        WebElement leavingMinuteField = driver.findElement(By.xpath("//html/body/div[10]/table/tbody/tr[2]/td[3]/input"));
        leavingMinuteField.click();
        leavingMinuteField.clear();
        leavingMinuteField.sendKeys("1");
        //SELECT ENTRY AM/PM
        WebElement leavingTimeAMPM = driver.findElement(By.xpath("/html/body/div[10]/table/tbody/tr[2]/td[5]/input"));
        leavingTimeAMPM.click();
        leavingTimeAMPM.clear();
        leavingTimeAMPM.sendKeys("p");

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

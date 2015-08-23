package MAIN_VERIFICATION_TESTS_SET;


import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by LewdBenign on 08.08.2015.
 */
public class SELECT_ENTRY_TIME {
    private WebDriver driver;

    @Before
    public void setUp(){
        driver = new FirefoxDriver();
    }

    @Test
    public void selectEntryTime() {
        //LOAD THE CALCULATOR PAGE
        driver.get("http://www.grr.org/parking-calculator.php");

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

        //FIND AND CLICK CALCULATE BUTTON
        WebElement clickOnCalculateButton = driver.findElement(By.xpath("/html/body/div[4]/div/div[5]/form/ul/li[6]/div/div[2]/input[2]"));
        clickOnCalculateButton.click();

        //VERIFY RESULT
        WebElement verifyErrorDateMessage = driver.findElement(By.id("calcparkingresult"));
        Assert.assertEquals("Error: Enter Date", verifyErrorDateMessage.getText());

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

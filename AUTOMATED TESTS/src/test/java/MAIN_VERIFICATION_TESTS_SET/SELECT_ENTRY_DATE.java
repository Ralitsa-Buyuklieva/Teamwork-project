package MAIN_VERIFICATION_TESTS_SET;

import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by LewdBenign on 08.08.2015.
 */
public class SELECT_ENTRY_DATE {
    private WebDriver driver;

    @Before
    public void setUp(){
        driver = new FirefoxDriver();
    }

    @Test
    public void selectEntryDate() {
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

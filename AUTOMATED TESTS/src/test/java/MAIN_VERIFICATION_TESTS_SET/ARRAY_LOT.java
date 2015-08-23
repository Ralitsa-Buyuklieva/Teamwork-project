package MAIN_VERIFICATION_TESTS_SET;

import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by LewdBenign on 07.08.2015.
 */
public class ARRAY_LOT {
    private WebDriver driver;

    @Before
    public void setUp(){
        driver = new FirefoxDriver();
    }

    @Test
    public void selectLot(){
        //LOAD THE CALCULATOR PAGE
        driver.get("http://www.grr.org/parking-calculator.php");

        //SAMPLE DICTIONARY
        //Map<String, String> map = new HashMap<String, String>();
        //map.put("dog", "type of animal");

        //LOT OPTIONS ARRAY
        String[] lotOption = new String[5];
        lotOption[0] = "Short-Term Parking";
        lotOption[1] = "Economy Parking";
        lotOption[2] = "Long-Term Surface Parking";
        lotOption[3] = "Long-Term Garage Parking";
        lotOption[4] = "Valet Parking";

        //LOOP ARRAY LOT OPTION
        for (int i = 0; i < lotOption.length; i++) {

            new Select(driver.findElement(By.id("Lot"))).selectByVisibleText(lotOption[i]);


            driver.findElement(By.name("Submit")).click();

            //VERIFY COST
            WebElement costField = driver.findElement(By.xpath("/html/body/div[4]/div/div[5]/form/ul/li[7]/div/div[2]/div"));
            Assert.assertEquals("Error: Enter Date", costField.getText());


            //PAUSE FOR FEW SECONDS
            try {
                Thread.sleep(1500);
            } catch(InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
        }

        /* COMMENTED TILL END OF TESTS

        //CLICK ON CALCULATE BUTTON
        WebElement clickOnCalculateButton = driver.findElement(By.xpath("/html/body/div[4]/div/div[5]/form/ul/li[6]/div/div[2]/input[2]"));
        clickOnCalculateButton.click();
        //driver.findElement(By.name("Submit")).click();

        //VERIFY COST
        WebElement costField = driver.findElement(By.xpath("/html/body/div[4]/div/div[5]/form/ul/li[7]/div/div[2]/div"));
        Assert.assertEquals("$2.00 (0D/0H/0M)",costField.getText());
        */

    }

    /*NOT TO CLOSE BROWSER AFTER TESTS
    @After
    public void closureActivities(){
        driver.quit();
    }*/
}
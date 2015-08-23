package MAIN_VERIFICATION_TESTS_SET;

import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by LewdBenign on 07.08.2015.
 */
public class VERIFY_MAIN_PAGE {

    private WebDriver driver;

    @Before
    public void setUp(){
        driver = new FirefoxDriver();
    }

    @Test
    public void openMainPage(){
        //LOAD THE CALCULATOR PAGE
        driver.get("http://www.grr.org/parking-calculator.php");

        //VERIFY PAGE HEADER
        WebElement pageHeader = driver.findElement(By.xpath("/html/body/div[4]/div/div[1]/h1"));
        Assert.assertEquals("PARKING CALCULATOR", pageHeader.getText());

        WebElement clickOnCalculateButton = driver.findElement(By.xpath("/html/body/div[4]/div/div[5]/form/ul/li[6]/div/div[2]/input[2]"));
        clickOnCalculateButton.click();

        WebElement verifyErrorDateMessage = driver.findElement(By.id("calcparkingresult"));
        Assert.assertEquals("Error: Enter Date", verifyErrorDateMessage.getText());

        //PAUSE FOR FEW SECONDS
        try {
            Thread.sleep(3000);
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }

    @After
    public void closureActivities(){
        driver.quit();
    }
}
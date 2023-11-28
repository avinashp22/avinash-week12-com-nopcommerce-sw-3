package homepage;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class TopMenuTest extends Utility {

    String baseURL = "https://demo.nopcommerce.com/";

    @Before
    public void setUp(){openBrowser(baseURL);}

    // create method with name "selectMenu" it has one parameter name "menu" of type string
    public void selectMenu(String menu) {
        driver.findElement(By.linkText(menu)).click();
    }

    @Test
    //create the @Test method name verifyPageNavigation. use selectMenu method to select the Menu and click on it and verify the page navigation.
    public void verifyPageNavigation()
    {
        selectMenu("Computers");
        verifyText("Incorrect Text", "Computers", (By.xpath("//h1[contains(text(),'Computers')]")));
        selectMenu("Electronics");
        verifyText("Incorrect Text", "Electronics", (By.xpath("//h1[contains(text(),'Electronics')]")));
        selectMenu("Apparel");
        verifyText("Incorrect Text", "Apparel", (By.xpath("//h1[contains(text(),'Apparel')]")));
        selectMenu("Digital downloads");
        verifyText("Incorrect Text", "Digital downloads", (By.xpath("//h1[contains(text(),'Digital downloads')]")));
        selectMenu("Books");
        verifyText("Incorrect Text", "Books", (By.xpath("//h1[contains(text(),'Books')]")));
        selectMenu("Jewelry");
        verifyText("Incorrect Text", "Jewelry", (By.xpath("//h1[contains(text(),'Jewelry')]")));
        selectMenu("Gift Cards");
        verifyText("Incorrect Text", "Gift Cards", (By.xpath("//h1[contains(text(),'Gift Cards')]")));
    }

    @After
    public void tearDown(){closeBrowser();}

}

package computer;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class TestSuite extends Utility {

    String baseURL = "https://demo.nopcommerce.com/";

    @Before
    public void setUp(){openBrowser(baseURL);}

    @Test
    public void verifyProductArrangeInAlphabeticalOrder() {
        //1.1 Click on Computer Menu.
        mouseHoverToElement(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Computers']"));
        //1.2 Click on desktop
        mouseHoverAndClickOnElement(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Desktops']"));
        //1.3 Select Sort By position "Name: Z to A"
        clickOnElement(By.xpath("//select[@id='products-orderby']"));
        selectFromVisibleTextFromDropdown(By.xpath("//select[@id='products-orderby']"), "Name: Z to A");
        //1.4 Verify the Product will arrange in Descending order.
        verifyText("Incorrect Text", "Name: Z to A", By.xpath("//select[@id='products-orderby']/option[text()='Name: Z to A']"));
    }


    @Test
    public void verifyProductAddedToShoppingCartSuccessfully() throws InterruptedException {
        //2.1 Click on Computer Menu.
        clickOnElement(By.xpath("//a[@href='/computers']"));
        //2.2 Click on Desktop
        clickOnElement(By.xpath("//img[@alt='Picture for category Desktops']"));
        //2.3 Select Sort By position "Name: A to Z"
        selectFromVisibleTextFromDropdown(By.name("products-orderby"), "Name: A to Z");
        //2.4 Click on "Add To Cart"
        Thread.sleep(2000);
        clickOnElement(By.xpath("//button[@type='button' and  @class='button-2 product-box-add-to-cart-button']"));
        //2.5 Verify the Text "Build your own computer"
        verifyText("Incorrect Text", "Build your own computer", By.xpath("//h1[contains(text(),'Build your own computer')]"));
        //2.6 Select "2.2 GHz Intel Pentium Dual-Core E2200" using Select class
        selectFromVisibleTextFromDropdown(By.id("product_attribute_1"), "2.2 GHz Intel Pentium Dual-Core E2200");
        //2.7.Select "8GB [+$60.00]" using Select class.
        selectFromVisibleTextFromDropdown(By.id("product_attribute_2"), "8GB [+$60.00]");
        //2.8 Select HDD radio "400 GB [+$100.00]"
        clickOnElement(By.id("product_attribute_3_7"));
        //2.9 Select OS radio "Vista Premium [+$60.00]"
        clickOnElement(By.id("product_attribute_4_9"));
        //2.10 Check Two Check boxes "Microsoft Office [+$50.00]" and "Total Commander//[+$5.00]"
        clickOnElement(By.id("product_attribute_5_12"));
        //2.11 Verify the price "$1,475.00"
        Thread.sleep(2000);
        verifyText("Incorrect Price", "$1,470.00", By.id("price-value-1"));
        //2.12 Click on "ADD TO CARD" Button.
        clickOnElement(By.xpath("//button[@id='add-to-cart-button-1']"));
        //2.13 Verify the Message "The product has been added to your shopping cart" on Top green Bar
        verifyText("Incorrect Text", "The product has been added to your shopping cart", By.xpath("//p[@class='content']"));
        //close popup
        clickOnElement(By.xpath("//span[@title='Close']"));
        //2.14 Then MouseHover on "Shopping cart" and Click on "GO TO CART" button.
        mouseHoverToElement(By.xpath("//span[@class='cart-label']"));
        //2.15 Verify the message "Shopping cart"
        clickOnElement(By.xpath("//button[@class='button-1 cart-button']"));
        Thread.sleep(2000);
        //2.15 Verify the message "Shopping cart"
        verifyText("Incorrect Text", "Shopping cart", By.xpath("//h1[contains(text(),'Shopping cart')]"));
        Thread.sleep(2000);
        //2.16 Change the Qty to "2" and
        clearText(By.className("qty-input"));
        sendTextToElement(By.className("qty-input"), "2");
        Thread.sleep(2000);
        //Click on "Update shopping cart"
        clickOnElement(By.id("updatecart"));
        //2.17 Verify the Total"$2,950.00"
        verifyText("Incorrect Price", "$2,950.00", By.xpath("//span[@class='value-summary']//strong[text()='$2,950.00']"));
        //2.18 click on checkbox “I agree with the terms of service”
        clickOnElement(By.id("termsofservice"));
        // 2.19 Click on “CHECKOUT”
        clickOnElement(By.id("checkout"));
        //2.20 Verify the Text “Welcome, Please Sign In!”
        verifyText("Incorrect Text", "Welcome, Please Sign In!", By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]"));
        //2.21Click on “CHECKOUT AS GUEST” Tab
        clickOnElement(By.xpath("//button[contains(text(),'Checkout as Guest')]"));
        //2.22 Fill the all mandatory field
        sendTextToElement(By.id("BillingNewAddress_FirstName"), "Avinash");
        sendTextToElement(By.id("BillingNewAddress_LastName"), "Patel");
        sendTextToElement(By.id("BillingNewAddress_Email"), "aavvinashppatell22@gmail.com");
        sendTextToElement(By.id("BillingNewAddress_Company"), "Prime");
        selectFromVisibleTextFromDropdown(By.id("BillingNewAddress_CountryId"), "United Kingdom");
        sendTextToElement(By.id("BillingNewAddress_City"), "London");
        sendTextToElement(By.id("BillingNewAddress_Address1"), "Prime Road");
        sendTextToElement(By.id("BillingNewAddress_ZipPostalCode"), "NW108EJ");
        sendTextToElement(By.id("BillingNewAddress_PhoneNumber"), "+447729546859");
        //2.23 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@onclick='Billing.save()']"));
        //2.24 Click on Radio Button “Next Day Air($0.00)”
        clickOnElement(By.id("shippingoption_1"));
        //2.25 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@onclick='ShippingMethod.save()']"));
        Thread.sleep(2000);
        //2.26 Select Radio Button “Credit Card”
        clickOnElement(By.id("paymentmethod_1"));
        Thread.sleep(2000);
        //2.27 Select “Master card” From Select credit card dropdown
        clickOnElement(By.xpath("//button[@class='button-1 payment-method-next-step-button']"));
        //2.28 Fill all the details
        selectFromVisibleTextFromDropdown(By.id("CreditCardType"), "Master card");
        sendTextToElement(By.id("CardholderName"), "Avinash Patel");
        sendTextToElement(By.id("CardNumber"), "0000000000000000");
        selectFromVisibleTextFromDropdown(By.id("ExpireMonth"), "12");
        selectFromVisibleTextFromDropdown(By.id("ExpireYear"), "2024");
        sendTextToElement(By.id("CardCode"), "123");
        //2.29 Click on “CONTINUE”
        clickOnElement(By.xpath("(//button[@class='button-1 payment-info-next-step-button'])[1]"));
        //2.30 Verify “Payment Method” is “Credit Card”
        verifyText("Incorrect Text", "Credit Card", By.xpath("//span[contains(text(),'Credit Card')]"));
        //2.32 Verify “Shipping Method” is “Next Day Air”
        verifyText("Incorrect Text", "Next Day Air", By.xpath("//span[contains(text(),'Next Day Air')]"));
        //2.33 Verify Total is “$2,950.00”
        verifyText("Incorrect Price", "$2,950.00", By.xpath("//span[@class='value-summary']/strong[text()='$2,950.00']"));
        //2.34 Click on “CONFIRM”
        clickOnElement(By.xpath("//button[contains(text(),'Confirm')]"));
        //2.35 Verify the Text “Thank You”
        verifyText("Incorrect Text", "Thank you", By.xpath("//h1[contains(text(),'Thank you')]"));
        //2.36 Verify the message “Your order has been successfully processed!”
        verifyText("Incorrect Text", "Your order has been successfully processed!", By.xpath("//strong[contains(text(),'Your order has been successfully processed!')]"));
        //2.37 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[contains(text(),'Continue')]"));
        //2.37 Verify the text “Welcome to our store”
        verifyText("Incorrect Text", "Welcome to our store", By.xpath("//h2[contains(text(),'Welcome to our store')]"));

    }


    @After
    public void tearDown(){closeBrowser();}


}

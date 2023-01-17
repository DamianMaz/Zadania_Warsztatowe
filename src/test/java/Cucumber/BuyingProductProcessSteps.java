package Cucumber;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class BuyingProductProcessSteps {

    private WebDriver driver;

    @Given("user was registered on the: {string} page")
    public void userWasRegisteredOnThePage(String websiteUrl) {
        driver = new EdgeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(websiteUrl);

    }
    @When("clicks in Sign in button")
    public void clicksInSignInButton() {
        driver.findElement(By.xpath("//*[@id=\"_desktop_user_info\"]/div/a")).click();
    }

    @And("user is logging on with {string} and {string}")
    public void userIsLoggingOnWithAnd(String email, String password) {
        driver.findElement(By.id("field-email")).sendKeys(email);
        driver.findElement(By.id("field-password")).sendKeys(password);
        driver.findElement(By.id("submit-login")).click();
        driver.findElement(By.id("category-3")).click();
    }

    @When("user clicks on Hummingbird Printed Sweater button")
    public void userClicksOnHummingbirdPrintedSweaterButton() {
        driver.findElement(By.xpath("//*[@id=\"js-product-list\"]/div[1]/div[2]/article/div/div[2]/h2/a")).click();
    }

    @When("user select M size")
    public void userSelectMSize() {
        WebElement sizeSelectElement = driver.findElement(By.xpath("//*[@id=\"group_1\"]"));
        Select sizeSelect = new Select(sizeSelectElement);
        sizeSelect.selectByValue("2");
    }

    @And("user selects five pieces")
    public void userSelectsFivePieces() {
//        Opcja 1

//        driver.findElement(By.xpath("//*[@id=\"add-to-cart-or-refresh\"]/div[2]/div/div[1]/div/span[3]/button[1]/i")).click();
//        driver.findElement(By.xpath("//*[@id=\"add-to-cart-or-refresh\"]/div[2]/div/div[1]/div/span[3]/button[1]/i")).click();
//        driver.findElement(By.xpath("//*[@id=\"add-to-cart-or-refresh\"]/div[2]/div/div[1]/div/span[3]/button[1]/i")).click();
//        driver.findElement(By.xpath("//*[@id=\"add-to-cart-or-refresh\"]/div[2]/div/div[1]/div/span[3]/button[1]/i")).click();
//        driver.findElement(By.xpath("//*[@id=\"add-to-cart-or-refresh\"]/div[2]/div/div[1]/div/span[3]/button[1]/i")).click();
//        driver.findElement(By.xpath("//*[@id=\"add-to-cart-or-refresh\"]/div[2]/div/div[1]/div/span[3]/button[1]/i")).click();
//        driver.findElement(By.xpath("//*[@id=\"add-to-cart-or-refresh\"]/div[2]/div/div[1]/div/span[3]/button[1]/i")).click();

//        Opcja 2

        driver.findElement(By.xpath("//*[@id=\"quantity_wanted\"]")).sendKeys(Keys.chord(Keys.CONTROL,"a",Keys.DELETE),"5");

//        Opcja 3

//        driver.findElement(By.xpath("\"//*[@id=\\\"quantity_wanted\\\"]\"")).sendKeys(Keys.HOME, Keys.chord(Keys.SHIFT, Keys.END),"5");

    }

    @And("user add product to cart")
    public void userAddProductToCart() {
        driver.findElement(By.xpath("//*[@id=\"add-to-cart-or-refresh\"]/div[2]/div/div[2]")).click();
    }

    @When("user clicks on Proceed To Checkout button")
    public void userClicksOnProceedToCheckoutButton() {
        driver.findElement(By.xpath("//*[@id=\"blockcart-modal\"]/div/div/div[2]/div/div[2]/div/div/a")).click();
    }

    @And("clicks on Proceed To Checkout button again")
    public void clicksOnProceedToCheckoutButtonAgain() {
        driver.findElement(By.xpath("//*[@id=\"main\"]/div/div[2]/div[1]/div[2]/div/a")).click();
    }

    @When("user confirms address and clicks on Continue button")
    public void userConfirmsAddressAndClicksOnContinueButton() {
        driver.findElement(By.name("confirm-addresses")).click();
    }

    @When("user clicks on PrestaShop field in shipping method")
    public void userClicksOnPrestaShopFieldInShippingMethod() {
        WebElement shippingMethodCheckbox = driver.findElement(By.id("delivery_option_1"));
        if(!shippingMethodCheckbox.isSelected()){
            shippingMethodCheckbox.click();
        }
        driver.findElement(By.name("confirmDeliveryOption")).click();
    }

    @When("user ticks PayByCheck field")
    public void userTicksPayByCheckField() {
        WebElement paymentMethodCheckbox = driver.findElement(By.id("payment-option-1"));
        if(!paymentMethodCheckbox.isSelected()){
            paymentMethodCheckbox.click();
        }
    }

    @And("user ticks on terms of service agreement")
    public void userTicksOnTermsOfServiceAgreement() {
        WebElement termsAgreementService = driver.findElement(By.id("conditions_to_approve[terms-and-conditions]"));
        if(!termsAgreementService.isSelected()){
            termsAgreementService.click();
        }
    }

    @And("user clicks on Place Order button")
    public void userClicksOnPlaceOrderButton() {
        driver.findElement(By.xpath("//*[@id=\"payment-confirmation\"]/div[1]/button")).click();
    }

    @Then("user makes screenshot with order confirmation")
    public void userMakesScreenshotWithOrderConfirmation() throws IOException {

        File shot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(shot, new File("C:\\CodersLab\\Screenshots\\Shot1.jpg"));

    }
}

package Cucumber;

import Pages.CreateNewAddressPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;

public class NewUserAddressSteps {

    private WebDriver driver;

    @Given("user is registered on the: {string} page")
    public void userIsRegisteredOnThePage(String websiteUrl) {
        driver = new EdgeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get(websiteUrl);
    }

    @And("user clicks on Sing in button")
    public void userClicksOnSingInButton() {
        driver.findElement(By.xpath("//*[@id=\"_desktop_user_info\"]/div/a")).click();
    }

    @When("user logs on with {string} and {string}")
    public void userLogsOnWithAnd(String email, String password) {
        driver.findElement(By.id("field-email")).sendKeys(email);
        driver.findElement(By.id("field-password")).sendKeys(password);
        driver.findElement(By.id("submit-login")).click();
    }

    @When("user clicks on Addresses button")
    public void userClicksOnAddressesButton() {
        driver.findElement(By.xpath("//*[@id=\"footer_account_list\"]/li[4]/a")).click();
    }

    @When("user clicks on Create New Address")
    public void userClicksOnCreateNewAddress() {
        driver.findElement(By.xpath("//*[@id=\"content\"]/div[3]/a")).click();
    }

    @When("user fills in New Address {string}, {string}, {string}, {string}, {string}, {string} user clicks save button")
    public void userFillsInNewAddressUserClicksSaveButton(String alias, String address, String city, String zipPostalCode, String country, String phone) {

        CreateNewAddressPage createNewAddressPage = new CreateNewAddressPage(driver);
        createNewAddressPage.addNewAddress(alias, address, city, zipPostalCode, country, phone);
    }

    @Then("new address data is correct and contains {string}, {string}, {string}, {string}, {string}, {string}")
    public void newAddressDataIsCorrectAndContains(String alias, String address, String city, String zipPostalCode, String country, String phone) {

//        Opcja 1

//        driver.findElement(By.xpath("//*[@id=\"address-30458\"]/div[2]/a[1]")).click();
//
//        String aliasText = driver.findElement(By.id("field-alias")).getText();
//        aliasText.contains(alias);
//
//        String addressText = driver.findElement(By.xpath("//*[@id=\"field-address1\"]")).getText();
//        addressText.contains(address);
//
//        String cityText = driver.findElement(By.xpath("//*[@id=\"field-city\"]")).getText();
//        cityText.contains(city);
//
//        String zipPostalCodeText = driver.findElement(By.xpath("//*[@id=\"field-postcode\"]")).getText();
//        zipPostalCodeText.contains(zipPostalCodeText);
//
//        String countryText = driver.findElement(By.xpath("//*[@id=\"field-id_country\"]")).getText();
//        countryText.contains(country);
//
//        String phoneText = driver.findElement(By.xpath("//*[@id=\"field-phone\"]")).getText();
//        phoneText.contains(phoneText);

//        Opcja 2

//        String CheckAddress = driver.findElement(By.xpath("//*[@id=\"address-30458\"]/div[1]")).getText();
//
//        CheckAddress.contains(alias);
//        CheckAddress.contains(address);
//        CheckAddress.contains(city);
//        CheckAddress.contains(zipPostalCode);
//        CheckAddress.contains(country);
//        CheckAddress.contains(phone);

//        Opcja 3

        driver.findElement(By.xpath("//*[@id=\"address-30458\"]/div[2]/a[1]")).click();

        String aliasText = driver.findElement(By.id("field-alias")).getAttribute("value");
        Assertions.assertEquals(aliasText,alias);

        String addressText = driver.findElement(By.xpath("//*[@id=\"field-address1\"]")).getAttribute("value");
        Assertions.assertEquals(addressText,address);

        String cityText = driver.findElement(By.xpath("//*[@id=\"field-city\"]")).getAttribute("value");
        Assertions.assertEquals(cityText,city);

        String zipPostalCodeText = driver.findElement(By.xpath("//*[@id=\"field-postcode\"]")).getAttribute("value");
        Assertions.assertEquals(zipPostalCodeText,zipPostalCode);

//        String countryText = driver.findElement(By.xpath("//*[@id=\"field-id_country\"]")).getText();
//        Assertions.assertEquals(countryText,country);

        String phoneText = driver.findElement(By.xpath("//*[@id=\"field-phone\"]")).getAttribute("value");
        Assertions.assertEquals(phoneText,phone);

    }
}

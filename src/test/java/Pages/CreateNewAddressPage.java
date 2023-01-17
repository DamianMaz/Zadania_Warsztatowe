package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import javax.xml.xpath.XPath;

public class CreateNewAddressPage {
    private WebDriver driver;

    @FindBy(id = "field-alias")
    private WebElement aliasInput;

    @FindBy(id = "field-address1")
    private WebElement address1Input;

    @FindBy(id = "field-city")
    private WebElement cityInput;

    @FindBy(id = "field-postcode")
    private WebElement postcodeInput;


    @FindBy(id = "field-id_country")
    private WebElement countryInput;

    @FindBy(id = "field-phone")
    private WebElement phoneInput;

    @FindBy(xpath = "//*[@id=\"content\"]/div/div/form/footer/button")
    private WebElement saveButton;

    public CreateNewAddressPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    public void addNewAddress(
            String alias,
            String address,
            String city,
            String zipPostalCode,
            String country,
            String phone){
                aliasInput.clear();
                aliasInput.sendKeys(alias);
                address1Input.clear();
                address1Input.sendKeys(address);
                cityInput.clear();
                cityInput.sendKeys(city);
                postcodeInput.clear();
                postcodeInput.sendKeys(zipPostalCode);
                countryInput.sendKeys(country);
                phoneInput.clear();
                phoneInput.sendKeys(phone);

                saveButton.click();


    }
}

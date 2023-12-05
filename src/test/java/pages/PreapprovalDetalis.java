package pages;

import com.github.javafaker.Faker;
import lombok.Data;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;
@Data
public class PreapprovalDetalis {
    public PreapprovalDetalis(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "realtor1")
    private WebElement realterCheckbox;

    @FindBy(xpath = "(//div[@class=\"checkbox checkbox-danger checkbox-glow\"])[1]")
    private WebElement realtorNoButton;

    @FindBy(id = "realtorinfo")
    private WebElement realtorInfo;

    @FindBy(id = "select2-purpose_loan-of-container")
    private WebElement dropDown;

    @FindBy(id = "estimatedprice")
    private WebElement estimatedPrice;

    @FindBy(id = "downpayment")
    private WebElement downPayment;

    @FindBy(id = "loanofficer1")
    private WebElement checkboxLoanOfficer;

    @FindBy(linkText = "Next")
    private WebElement nextButton;

    @FindBy(xpath = "//input[@type=\"search\"]")
    private WebElement dropDownPurchaseHome;

    @FindBy(id = "select2-purpose_loan-5j-container")
    private WebElement loanPurpose;

    @FindBy(xpath= "(//span[@class=\"select2-selection select2-selection--single\"])[1]")
    private WebElement loanPurpose1;


}

package pages;

import lombok.Data;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;
@Data
public class PersonalInfoPage {

    public PersonalInfoPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "b_firstName")
    private WebElement firstName;

    @FindBy(id = "b_lastName")
    private WebElement lastName;

    @FindBy(id = "b_email")
    private WebElement email;

    @FindBy(id = "b_dob")
    private WebElement dataOfBirth;

    @FindBy(id = "b_ssn")
    private WebElement socialSecurity;

    @FindBy(id = "select2-b_marital-container")
    private WebElement maritalStatus;

    @FindBy(id = "b_cell")
    private WebElement cellPhone;

    @FindBy(xpath = "//div[@class=\"checkbox\"]")
    private WebElement consentBox;

    @FindBy(id = "select2-b_marital-result-s58p-Married")
    private WebElement married;

    @FindBy(id = "privacypolicy")
    private WebElement privacyCheckbox;

    @FindBy(linkText = "Next")
    private WebElement nextButton;

    @FindBy(xpath = "//input[@type=\"search\"]")
    private WebElement searchMarried;


    }


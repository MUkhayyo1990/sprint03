package stepDefinitions;

import com.github.javafaker.Faker;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import pages.*;
import utils.Driver;
import utils.SeleniumUtils;

import java.util.List;

public class EconsentStepDefs {

    private final EconsentPage econsentPage = new EconsentPage();
    @Given("the user is on the eConsent page of the mortgage loan application")
    public void the_user_is_on_the_eConsent_page_of_the_mortgage_loan_application() {
        MortgageApplicationPage mortgageApplicationPage = new MortgageApplicationPage();
        mortgageApplicationPage.getMortgageApplicationLink().click();
        SeleniumUtils.waitFor(2);


        Faker faker = new Faker();
        PreapprovalDetalis preApprovalPage = new PreapprovalDetalis();
        if (!preApprovalPage.getRealterCheckbox().isSelected()) {
            preApprovalPage.getRealterCheckbox().click();

        } else {
            System.out.println("Checkbox already checked");
        }
        preApprovalPage.getRealtorInfo().sendKeys(faker.name().fullName() + " ");
        preApprovalPage.getRealtorInfo().sendKeys(faker.internet().emailAddress());



        if (!preApprovalPage.getCheckboxLoanOfficer().isSelected()) {
            preApprovalPage.getCheckboxLoanOfficer().click();
        } else {
            System.out.println("Checkbox already checked");
        }

        SeleniumUtils.waitFor(1);

        preApprovalPage.getEstimatedPrice().sendKeys("620000");
        preApprovalPage.getDownPayment().sendKeys("25000", Keys.TAB, Keys.ENTER);
        preApprovalPage.getNextButton().click();
        SeleniumUtils.waitFor(2);

        PersonalInfoPage personalInfoPage = new PersonalInfoPage();
        personalInfoPage.getFirstName().sendKeys(faker.name().firstName());
        personalInfoPage.getLastName().sendKeys(faker.name().lastName());
        personalInfoPage.getEmail().sendKeys(faker.internet().emailAddress());
        personalInfoPage.getDataOfBirth().sendKeys("03121988");
        SeleniumUtils.waitFor(1);
        personalInfoPage.getSocialSecurity().sendKeys("777225555");

        personalInfoPage.getMaritalStatus().click();
        SeleniumUtils.waitFor(2);
        personalInfoPage.getSearchMarried().sendKeys("Married", Keys.ENTER);
        personalInfoPage.getCellPhone().sendKeys(faker.phoneNumber().cellPhone());



//        WebElement dropdownElement = personalInfoPage.getMaritalStatus();
//        Select select = new Select(dropdownElement);
//        select.selectByVisibleText("Married");
//        select.selectByIndex(1);
//
//        personalInfoPage.getPrivacyCheckbox().click();
        personalInfoPage.getNextButton().click();
        ExpensesPage expensesPage = new ExpensesPage();
        expensesPage.getMonthlyRent().sendKeys("2000");
        expensesPage.getNextButton().click();

        Faker faker1 = new Faker();
        EmploymentPage employementPage = new EmploymentPage();
        employementPage.getEmployerName().sendKeys(faker.company().name());
        employementPage.getPosition().sendKeys(faker.job().position());
        employementPage.getCity().sendKeys(faker.address().cityName());
        employementPage.getState().click();
        WebElement state = employementPage.getState();
        Select select = new Select(state);
        select.selectByVisibleText("Virginia (VA)");
        employementPage.getStartDate().sendKeys("01012023");

        int monthlyGross = faker.number().numberBetween(12000, 15000);
        employementPage.getMonthlyGross().sendKeys(String.valueOf(monthlyGross));
        employementPage.getMonthlyOvertime().sendKeys("3000");
        employementPage.getMonthlyComm().sendKeys("1500");
        employementPage.getMonthlyBonuses().sendKeys("1000");
        employementPage.getMonthlyDivident().sendKeys("500");
        employementPage.getNextButton().click();

        CreditReportPage creditReportPage = new CreditReportPage();
        creditReportPage.getCreditReporetYesCheck().isSelected();
        creditReportPage.getNextButton().click();

    }
    @When("the user enters valid first name {string}, last name {string}, and email address {string}")
    public void the_user_enters_valid_first_name_last_name_and_email_address(String firstName, String lastName, String email ) {

        econsentPage.getFirstName().sendKeys(firstName);
      econsentPage.getLastName().sendKeys(lastName);
      econsentPage.getEmail().sendKeys(email);
    }
    @When("the user reviews the necessary disclosures")
    public void the_user_reviews_the_necessary_disclosures() {
       econsentPage.assertEconsentLogo();
    }

    @When("the email address is in a valid format")
    public void the_email_address_is_in_a_valid_format() {

    }
    @When("reads the necessary disclosures displayed on the page")
    public void reads_the_necessary_disclosures_displayed_on_the_page() {

    }
    @When("explicitly selects the {string} radio button")
    public void explicitly_selects_the_radio_button(String string) {

    }

    @Then("the user should not be able to proceed, and an error should be displayed")
    public void the_user_should_not_be_able_to_proceed_and_an_error_should_be_displayed() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("the user selects the {string} radio button")
    public void the_user_selects_the_radio_button(String string) {
      econsentPage.getAgreeClick().isSelected();
      econsentPage.getNextButton().click();
    }


//    @When("the user submits the eConsent agreement")
//    public void the_user_submits_the_e_consent_agreement() {
//
//    }
//    @Then("the user should be redirected back to the main application flow")
//    public void the_user_should_be_redirected_back_to_the_main_application_flow() {
//
//    }


    @Then("User should be able to move to Summary page")
    public void user_should_be_able_to_move_to_summary_page() {
        Assert.assertEquals(Driver.getDriver().getCurrentUrl(),"http://qa-duobank.us-east-2.elasticbeanstalk.com/mortgage.php");
    }

}

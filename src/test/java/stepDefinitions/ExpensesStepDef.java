package stepDefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.an.E;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import pages.ExpensesPage;
import pages.MortgageApplicationPage;
import pages.PersonalInfoPage;
import pages.PreapprovalDetalis;
import utils.Driver;
import utils.SeleniumUtils;

public class ExpensesStepDef {

    @Given("User in expenses page")
    public void user_in_expenses_page() {
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
    }
    @When("User puts his\\/her expenses")
    public void user_puts_his_her_expenses() {
        ExpensesPage expensesPage = new ExpensesPage();
        expensesPage.getMonthlyRent().sendKeys("2000",Keys.ENTER);
        expensesPage.getNextButton().click();
    }
    @Then("User should be able to move to Employement page")
    public void user_should_be_able_to_move_to_employement_page() {
        Assert.assertEquals(Driver.getDriver().getCurrentUrl(),"http://qa-duobank.us-east-2.elasticbeanstalk.com/mortgage.php");
    }

}

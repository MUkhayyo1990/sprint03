package stepDefinitions;

import com.github.javafaker.Faker;
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

public class EmploymentStepDefi {
    @Given("User in Employement page")
    public void user_in_employement_page() {
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


    }
    @When("User completes employement and income info")
    public void user_completes_employement_and_income_info() {

        Faker faker = new Faker();
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

    }
    @Then("User should be able to move to credit report page")
    public void user_should_be_able_to_move_to_credit_report_page() {
        Assert.assertEquals(Driver.getDriver().getCurrentUrl(),"http://qa-duobank.us-east-2.elasticbeanstalk.com/mortgage.php");

    }

}

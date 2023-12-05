package stepDefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.checkerframework.checker.units.qual.K;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import pages.DashboardPage;
import pages.MortgageApplicationPage;
import pages.PreapprovalDetalis;
import utils.Driver;
import utils.SeleniumUtils;

import java.security.Key;

public class PreapprovalDetalisStepDef {

    private final PreapprovalDetalis preapprovalDetalis = new PreapprovalDetalis();
    private final DashboardPage dashboardPage = new DashboardPage();

    @Given("User on pre-approval page")
    public void user_on_pre_approval_page() {
//        LoginPage loginPage = new LoginPage();
//        loginPage.getUsername().sendKeys(ConfigReader.getProperty("username"));
//        loginPage.getPassword().sendKeys(ConfigReader.getProperty("password"));
//        loginPage.getSingInButton().click();
        MortgageApplicationPage mortgageApplicationPage = new MortgageApplicationPage();
        mortgageApplicationPage.getMortgageApplicationLink().click();
        SeleniumUtils.waitFor(3);

    }
    @When("User fills out personal info")
    public void user_fills_out_personal_info() {

        Faker faker = new Faker();
        PreapprovalDetalis preApprovalPage = new PreapprovalDetalis();
        if (!preApprovalPage.getRealterCheckbox().isSelected()) {
            preApprovalPage.getRealterCheckbox().click();

        } else {
            System.out.println("Checkbox already checked");
        }
        preApprovalPage.getRealtorInfo().sendKeys(faker.name().fullName() + " ");
        preApprovalPage.getRealtorInfo().sendKeys(faker.internet().emailAddress());

        preApprovalPage.getLoanPurpose1().click();
        preApprovalPage.getDropDownPurchaseHome().sendKeys("Purchase a Home", Keys.ENTER);
        SeleniumUtils.waitFor(1);

        if (!preApprovalPage.getCheckboxLoanOfficer().isSelected()) {
            preApprovalPage.getCheckboxLoanOfficer().click();
        } else {
            System.out.println("Checkbox already checked");
        }

        SeleniumUtils.waitFor(1);
//
//        preApprovalPage.getDropDown().click();
//        Select drop = new Select( preApprovalPage.getDropDown());
//        drop.selectByVisibleText("Purchase a Home");

        preApprovalPage.getEstimatedPrice().sendKeys("620000");
        preApprovalPage.getDownPayment().sendKeys("25000", Keys.TAB, Keys.ENTER);
        preApprovalPage.getNextButton().click();
        SeleniumUtils.waitFor(2);
    }


    @Then("User should be able to move next page")
    public void user_should_be_able_to_move_next_page() {
        Assert.assertEquals(Driver.getDriver().getTitle(), "Duobank Mortgage Application");
    }

}



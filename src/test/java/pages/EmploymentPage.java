package pages;

import lombok.Data;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;
@Data
public class EmploymentPage {
    public EmploymentPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(id = "employername1")
    private WebElement employerName;

    @FindBy(id = "position1")
    private WebElement position;

    @FindBy(id = "city")
    private WebElement city;

    @FindBy(id = "state1")
    private WebElement state;


    @FindBy(id = "start_date1")
    private WebElement startDate;

    @FindBy(id = "grossmonthlyincome")
    private WebElement monthlyGross;

    @FindBy(id = "monthlyovertime")
    private WebElement monthlyOvertime;

    @FindBy(id = "monthlybonuses")
    private WebElement monthlyBonuses;

    @FindBy(id = "monthlycommission")
    private WebElement monthlyComm;

    @FindBy(id = "monthlydividents")
    private WebElement monthlyDivident;

    @FindBy(id = "currentjob1")
    private WebElement currentJobBox;

    @FindBy(linkText = "Next")
    private WebElement nextButton;
}


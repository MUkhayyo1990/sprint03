package pages;

import lombok.Data;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;
@Data
public class CreditReportPage {
    public CreditReportPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "creditreport1")
    private WebElement CreditReporetYesCheck;

    @FindBy(id = "creditreport2")
    private WebElement CreditReporetNoCheck;

    @FindBy(linkText = "Next")
    private WebElement nextButton;
}

package stepDefinations;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java.it.Ma;
import cucumber.runtime.junit.Assertions;
import managers.WebdriverManager;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.w3c.dom.stylesheets.LinkStyle;
import pageObjects.LoanBorrowCalculatorPage;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class EstimateLoanBorrowStep {

    WebdriverManager webdriverManager;
    LoanBorrowCalculatorPage loanBorrowCalculatorPage;
    WebDriver driver;

    public EstimateLoanBorrowStep(){
        webdriverManager = new WebdriverManager();
        driver = webdriverManager.getDriver();
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        loanBorrowCalculatorPage = new LoanBorrowCalculatorPage(driver);
    }

    @Given("^user is at Home loan borrowing page$")
    public void user_is_at_Home_loan_borrowing_page(){
        loanBorrowCalculatorPage.navigateToEstimateLoanBorrowPage(webdriverManager.getUrl());
    }

    @When("^enters your details \"([^\"]*)\"$")
    public void enters_your_details(String numberOfDependent){
//        List<Map<String, String>> dataList = dataTable.asMaps(String.class, String.class);
        loanBorrowCalculatorPage.setApplicationTypeRadio();
        loanBorrowCalculatorPage.setNumberOFDependantDropDown(numberOfDependent);
        loanBorrowCalculatorPage.setHomeToLiveInRadio();
    }


    @And("^inputs earning info$")
    public void inputs_earning_info(DataTable dataTable) {
        List<Map<String, String>> dataList = dataTable.asMaps(String.class, String.class);
        loanBorrowCalculatorPage.setYourIncomeTextField(dataList.get(0).get("earning"));
        loanBorrowCalculatorPage.setYourOtherIncomeTextField(dataList.get(0).get("otherIncome"));
    }

    @And("^enters expenses data$")
    public void enters_expenses_data(DataTable dataTable){
        List<Map<String, String>> dataList = dataTable.asMaps(String.class, String.class);

        loanBorrowCalculatorPage.setLivingExpensesTextField(dataList.get(0).get("livingExpense"));
        loanBorrowCalculatorPage.setCurrentHomeLoanRepaymentTextField(dataList.get(0).get("currentHomeLoan"));
        loanBorrowCalculatorPage.setOtherLoanRepaymentTextField(dataList.get(0).get("otherLoan"));
        loanBorrowCalculatorPage.setOtherCommitmentsTextField(dataList.get(0).get("otherCommitment"));
        loanBorrowCalculatorPage.setTotalCreditCardLimitsTextField(dataList.get(0).get("creditLimit"));
    }

    @When("^clicks Work out how much I could borrow button$")
    public void clicks_Work_out_how_much_I_could_borrow_button(){
        loanBorrowCalculatorPage.clickWorkoutHowMuchIBorrowBtn();
    }

    @Then("^verify the estimated loan can be borrowed is \"([^\"]*)\"$")
    public void verify_the_estimated_loan_can_be_borrowed_is(String estimatedLoan){
        String actualEstimatedLoan = loanBorrowCalculatorPage.getBorrowResultAmountReadOnlyField();
        Assert.assertEquals("Estimated loan borrow amount does not matches ", actualEstimatedLoan, estimatedLoan);
    }


    @When("^clicks Start over button$")
    public void clicks_Start_over_button() throws Throwable {
        loanBorrowCalculatorPage.clickStartOverBtn();
    }

    @When("^enters living expense as \"([^\"]*)\"$")
    public void enters_living_expense_as(String livingExpense) {
        loanBorrowCalculatorPage.setLivingExpensesTextField(livingExpense);
    }

    @When("^hits Work out how much I could borrow button$")
    public void hits_Work_out_how_much_I_could_borrow_button() {
        loanBorrowCalculatorPage.clickWorkoutHowMuchIBorrowBtn();
    }

    @Then("^error message displayed with phone number \"([^\"]*)\"$")
    public void error_message_displayed_with_phone_number(String phoneNumber){
        String actualMessage = loanBorrowCalculatorPage.getErrorValidationText();
        Assert.assertEquals("Error message is not matching", phoneNumber, actualMessage);
    }

}

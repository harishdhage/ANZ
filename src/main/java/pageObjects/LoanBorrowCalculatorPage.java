package pageObjects;

import managers.Waits;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class LoanBorrowCalculatorPage {
    WebDriver driver;

    public LoanBorrowCalculatorPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@value='S']")
    WebElement applicationTypeRadio;

    @FindBy(xpath = "//Select[@title='Number of dependants']")
    WebElement numberOFDependantDropDown;

    @FindBy(xpath = "//input[@value='H']")
    WebElement homeToLiveInRadio;

    @FindBy(xpath = "//label[.='Your income (before tax)']/following-sibling::div/input")
    WebElement yourIncomeTextField;

    @FindBy(xpath = "//label[.='Your other income']/following-sibling::div/input")
    WebElement yourOtherIncomeTextField;

    @FindBy(xpath = "//label[.='Living expenses']/following-sibling::div/input")
    WebElement livingExpensesTextField;

    @FindBy(xpath = "//label[.='Current home loan repayments']/following-sibling::div/input")
    WebElement currentHomeLoanRepaymentTextField;

    @FindBy(xpath = "//label[.='Other loan repayments']/following-sibling::div/input")
    WebElement otherLoanRepaymentTextField;

    @FindBy(xpath = "//label[.='Other commitments']/following-sibling::div/input")
    WebElement otherCommitmentsTextField;

    @FindBy(xpath = "//label[.='Total credit card limits']/following-sibling::div/input")
    WebElement totalCreditCardLimitsTextField;

    @FindBy(xpath = "//button[.='Work out how much I could borrow']")
    WebElement workoutHowMuchIBorrowBtn;

    @FindBy(xpath = "//span[@id='borrowResultTextAmount']")
    WebElement borrowResultAmountReadOnlyField;

    @FindBy(xpath = "//button[@class='start-over']")
    WebElement startOverBtn;

    @FindBy(xpath = "//span[@class='borrow__error__text']")
    WebElement errorValidationTxt;

    public void navigateToEstimateLoanBorrowPage(String url){
        driver.get(url);
        driver.manage().window().maximize();
    }

    public void setApplicationTypeRadio(){
        if (!applicationTypeRadio.isSelected()) {
            applicationTypeRadio.click();
        }
    }

    public void setNumberOFDependantDropDown(String numberOFDependant){
        System.out.println("NOD - "+numberOFDependant);
        Select select = new Select(numberOFDependantDropDown);
        select.selectByVisibleText(numberOFDependant);
    }

    public void setHomeToLiveInRadio(){
        if (!homeToLiveInRadio.isSelected()){
            homeToLiveInRadio.click();
        }
    }

    //Incomes
    public void setYourIncomeTextField(String yourIncome){
        yourIncomeTextField.sendKeys(yourIncome);
    }

    public void setYourOtherIncomeTextField(String otherIncome){
        yourOtherIncomeTextField.sendKeys(otherIncome);
    }

    //Expenses
    public void setLivingExpensesTextField(String livingExpense){
        livingExpensesTextField.sendKeys(livingExpense);
    }

    public void setCurrentHomeLoanRepaymentTextField(String currentHomeLoan){
        currentHomeLoanRepaymentTextField.sendKeys(currentHomeLoan);
    }

    public void setOtherLoanRepaymentTextField(String otherLoan){
        otherLoanRepaymentTextField.sendKeys(otherLoan);
    }

    public void setOtherCommitmentsTextField(String otherCommitment){
        otherCommitmentsTextField.sendKeys(otherCommitment);
    }

    public void setTotalCreditCardLimitsTextField(String creditCardLimit){
        totalCreditCardLimitsTextField.sendKeys(creditCardLimit);
    }

    public void clickWorkoutHowMuchIBorrowBtn(){
        workoutHowMuchIBorrowBtn.click();
    }

    public String getBorrowResultAmountReadOnlyField(){
        return Waits.explicitWait(driver, 20, borrowResultAmountReadOnlyField).getText();
    }

    public void clickStartOverBtn(){
        startOverBtn.click();
    }

    public String getErrorValidationText(){
        return errorValidationTxt.getText();
    }

}

package pages;

import core.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class AccountPage extends BasePage {

    @FindBy(css = ".center[ng-hide='noAccount'] .ng-binding:nth-child(2)")
    private WebElement balance;
    @FindBy(css = "[ng-show='message']")
    private WebElement message;

    @FindBy(css = "[ng-click='deposit()']")
    private WebElement depositButton;
    @FindBy(css = "[ng-submit='deposit()'] input")
    private WebElement depositInput;
    @FindBy(css = "[ng-submit='deposit()'] [type='submit']")
    private WebElement depositSubmit;

    @FindBy(css = "[ng-click='withdrawl()']")
    private WebElement withdrawlButton;
    @FindBy(css = "[ng-submit='withdrawl()'] input")
    private WebElement withdrawlInput;
    @FindBy(css = "[ng-submit='withdrawl()']  [type='submit']")
    private WebElement withdrawlSubmit;

    @FindBy(css = "[ng-click='transactions()']")
    private WebElement transactionsButton;

    public WebElement getBalance() {
        return balance;
    }

    public AccountPage() {
        PageFactory.initElements(driver, this);
    }

    @Step("Пополнить баланса на {amount}")
    public AccountPage amountDeposited(long amount) {
        depositButton.click();
        depositInput.sendKeys(String.valueOf(amount));
        depositSubmit.click();
        return this;
    }

    @Step("Списание с баланса на  {amount}")
    public AccountPage amountWithdrawn(long amount) {

        withdrawlButton.click();
        withdrawlInput.sendKeys(String.valueOf(amount));
        withdrawlSubmit.click();
        return this;
    }

    @Step("Переход к списку транзакций на балансе")
    public TransactionPage goToTransactionsList() throws InterruptedException {
        Thread.sleep(Duration.ofSeconds(3));
        driver.navigate().refresh();
        transactionsButton.click();
        return new TransactionPage();
    }
}
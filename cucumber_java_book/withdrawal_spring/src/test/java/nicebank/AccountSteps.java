/***
 * Excerpted from "The Cucumber for Java Book",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material, 
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose. 
 * Visit http://www.pragmaticprogrammer.com/titles/srjcuc for more book information.
***/
package nicebank;

import cucumber.api.java.en.*;
import cucumber.api.Transform;

import org.junit.*;

import org.springframework.beans.factory.annotation.Autowired;

import transforms.MoneyConverter;

public class AccountSteps {

    @Autowired
    Account account;

    private Money originalBalance;

    @Given("^my account has been credited with (\\$\\d+\\.\\d+)$")
    public void myAccountHasBeenCreditedWith$(
        @Transform(MoneyConverter.class) Money amount)
        throws Throwable {
        account.credit(amount);
    }

    @Given("^my account is in credit$")
    public void myAccountIsInCredit$() throws Throwable {
        originalBalance = new Money(30, 00);
        account.credit(originalBalance);
    }

    @Then("^the balance of my account should be unchanged$")
    public void theBalanceOfMyAccountShouldBeUnchanged() throws InterruptedException {

        checkBalanceIs(originalBalance);
    }

    @Then("^the balance of my account should be (\\$\\d+\\.\\d+)$")
    public void theBalanceOfMyAccountShouldBe$(
        @Transform(MoneyConverter.class) Money amount) throws Throwable {

        checkBalanceIs(amount);
    }

    private void checkBalanceIs(Money amount) throws InterruptedException {
        int timeoutMilliSecs = 3000;
        int pollIntervalMilliSecs = 100;

        while (!account.getBalance().equals(amount) && timeoutMilliSecs > 0) {
            Thread.sleep(pollIntervalMilliSecs);
            timeoutMilliSecs -= pollIntervalMilliSecs;
        }

        Assert.assertEquals(
                "Incorrect account balance -",
                amount,
                account.getBalance());
    }
}

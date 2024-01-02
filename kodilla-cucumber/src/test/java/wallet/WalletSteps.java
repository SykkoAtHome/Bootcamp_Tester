package wallet;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WalletSteps {


    private final Wallet wallet = new Wallet();
    private final CashSlot cashSlot = new CashSlot();

    @Given("I have deposited {int} in my wallet")
    public void i_have_deposited_in_my_wallet(Integer int1) {
        wallet.deposit(int1);
    }

    @When("I request {int}")
    public void i_request(Integer int1) {
        Cashier cashier = new Cashier(cashSlot);
        cashier.withdraw(wallet, int1);
    }

    @Then("{int} should be dispensed")
    public void should_be_dispensed(Integer int1) {
        assertEquals(int1, cashSlot.getContents());
    }

    @And("the balance of my wallet should be {int}")
    public void the_balance_of_my_wallet_should_be(Integer int1) {
        assertEquals(int1, wallet.getBalance());

    }

    @And("I should get a {string} what is happening")
    public void i_should_get_a_what_is_happening(String string) {
        assertEquals(string, wallet.getWalletMassage());

    }
}
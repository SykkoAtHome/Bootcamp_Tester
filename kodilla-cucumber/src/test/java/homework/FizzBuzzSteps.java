package homework;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FizzBuzzSteps {
    private int number;
    private String answer;

    @Given("giving a number 3")
    public void giving_a_number_3() {
        this.number = 3;
    }

    @When("I ask is divisible")
    public void i_ask_is_divisible() {
        this.answer = NumberChecker.checkNumber(this.number);
    }

    @Then("I should get {string}")
    public void i_should_get_answer(String string) {
        assertEquals(string, this.answer);
    }

    @Given("giving a number 6")
    public void giving_a_number_6() {
        this.number = 6;
    }

    @Given("giving a number 15")
    public void giving_a_number_15() {
        this.number = 15;
    }

    @Given("giving a number 10")
    public void giving_a_number_10() {
        this.number = 10;
    }

    @Given("giving a number 30")
    public void giving_a_number_30() {
        this.number = 30;
    }

    @Given("giving a number 5")
    public void giving_a_number_5() {
        this.number = 5;
    }

    @Given("giving a number 7")
    public void giving_a_number_7() {
        this.number = 7;
    }

    @Given("giving a number 13")
    public void giving_a_number_13() {
        this.number = 13;
    }
}

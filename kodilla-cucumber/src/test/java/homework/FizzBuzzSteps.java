package homework;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FizzBuzzSteps {
    private int number;
    private String answer;

    @Given("giving a number {int}")
    public void giving_a_number(int number) {
        this.number = number;
    }

    @When("I ask is divisible")
    public void i_ask_is_divisible() {
        this.answer = NumberChecker.checkNumber(this.number);
    }

    @Then("I should get {string}")
    public void i_should_get_answer(String string) {
        assertEquals(string, this.answer);
    }
}
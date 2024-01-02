Feature: FizzBuzz Number Checker


  Scenario Outline: Number divisible by 3, 5 or both

    Given giving a number <number>
    When I ask is divisible
    Then I should get <answer>

    Examples:
      | number | answer     |
      | 3      | "Fizz"     |
      | 6      | "Fizz"     |
      | 15     | "FizzBuzz" |
      | 10     | "Buzz"     |
      | 30     | "FizzBuzz" |
      | 5      | "Buzz"     |
      | 7      | "None"     |
      | 13     | "None"     |
Feature: Cash Withdrawal

  Scenario Outline: Successful withdrawal from a wallet in credit
    Given I have deposited <money> in my wallet
    When I request <amount>
    Then <cash> should be dispensed
    And the balance of my wallet should be <balance>
    And I should get a <massage> what is happening
    Examples:
      | money | amount | cash | balance | massage                              |
      | 200   | 30     | 30   | 170     | "Withdraw Successful"                |
      | 20    | 20     | 20   | 0       | "Withdraw Successful"                |
      | 0     | 0      | 0    | 0       | "You can't withdraw zero amount"     |
      | 90    | 100    | 0    | 90      | "Not enough money"                   |
      | -100  | 100    | 0    | 0       | "You can't deposit negative values"  |
      | 100   | -100   | 0    | 100     | "You can't withdraw negative amount" |
Feature: Calculate loan amount
  Scenario: Calculate loan amount with data

    Given user is at Home loan borrowing page
    When enters your details "0"
    And inputs earning info
      |earning|otherIncome|
      |80000  |10000      |
    And enters expenses data
      |livingExpense|currentHomeLoan|otherLoan|otherCommitment|creditLimit|
      |500          |0              |100      |0              |10000      |
    When clicks Work out how much I could borrow button
    Then verify the estimated loan can be borrowed is "$507,000"
    When clicks Start over button
    And enters living expense as "1"
    And hits Work out how much I could borrow button
    Then error message displayed with phone number "Based on the details you've entered, we're unable to give you an estimate of your borrowing power with this calculator. For questions, call us on 1800 035 500."
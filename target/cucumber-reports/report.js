$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("CalculateLoan.feature");
formatter.feature({
  "line": 1,
  "name": "Calculate loan amount",
  "description": "",
  "id": "calculate-loan-amount",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 2,
  "name": "Calculate loan amount with data",
  "description": "",
  "id": "calculate-loan-amount;calculate-loan-amount-with-data",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 4,
  "name": "user is at Home loan borrowing page",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "enters your details \"0\"",
  "keyword": "When "
});
formatter.step({
  "line": 6,
  "name": "inputs earning info",
  "rows": [
    {
      "cells": [
        "earning",
        "otherIncome"
      ],
      "line": 7
    },
    {
      "cells": [
        "80000",
        "10000"
      ],
      "line": 8
    }
  ],
  "keyword": "And "
});
formatter.step({
  "line": 9,
  "name": "enters expenses data",
  "rows": [
    {
      "cells": [
        "livingExpense",
        "currentHomeLoan",
        "otherLoan",
        "otherCommitment",
        "creditLimit"
      ],
      "line": 10
    },
    {
      "cells": [
        "500",
        "0",
        "100",
        "0",
        "10000"
      ],
      "line": 11
    }
  ],
  "keyword": "And "
});
formatter.step({
  "line": 12,
  "name": "clicks Work out how much I could borrow button",
  "keyword": "When "
});
formatter.step({
  "line": 13,
  "name": "verify the estimated loan can be borrowed is \"$507,000\"",
  "keyword": "Then "
});
formatter.step({
  "line": 14,
  "name": "clicks Start over button",
  "keyword": "When "
});
formatter.step({
  "line": 15,
  "name": "enters living expense as \"1\"",
  "keyword": "And "
});
formatter.step({
  "line": 16,
  "name": "hits Work out how much I could borrow button",
  "keyword": "And "
});
formatter.step({
  "line": 17,
  "name": "error message displayed with phone number \"Based on the details you\u0027ve entered, we\u0027re unable to give you an estimate of your borrowing power with this calculator. For questions, call us on 1800 035 500.\"",
  "keyword": "Then "
});
formatter.match({
  "location": "EstimateLoanBorrowStep.user_is_at_Home_loan_borrowing_page()"
});
formatter.result({
  "duration": 123520995005,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "0",
      "offset": 21
    }
  ],
  "location": "EstimateLoanBorrowStep.enters_your_details(String)"
});
formatter.result({
  "duration": 5937492563,
  "status": "passed"
});
formatter.match({
  "location": "EstimateLoanBorrowStep.inputs_earning_info(DataTable)"
});
formatter.result({
  "duration": 2822052116,
  "status": "passed"
});
formatter.match({
  "location": "EstimateLoanBorrowStep.enters_expenses_data(DataTable)"
});
formatter.result({
  "duration": 2521177917,
  "status": "passed"
});
formatter.match({
  "location": "EstimateLoanBorrowStep.clicks_Work_out_how_much_I_could_borrow_button()"
});
formatter.result({
  "duration": 1614955870,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "$507,000",
      "offset": 46
    }
  ],
  "location": "EstimateLoanBorrowStep.verify_the_estimated_loan_can_be_borrowed_is(String)"
});
formatter.result({
  "duration": 796991748,
  "status": "passed"
});
formatter.match({
  "location": "EstimateLoanBorrowStep.clicks_Start_over_button()"
});
formatter.result({
  "duration": 693592242,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "1",
      "offset": 26
    }
  ],
  "location": "EstimateLoanBorrowStep.enters_living_expense_as(String)"
});
formatter.result({
  "duration": 497352673,
  "status": "passed"
});
formatter.match({
  "location": "EstimateLoanBorrowStep.hits_Work_out_how_much_I_could_borrow_button()"
});
formatter.result({
  "duration": 841905553,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Based on the details you\u0027ve entered, we\u0027re unable to give you an estimate of your borrowing power with this calculator. For questions, call us on 1800 035 500.",
      "offset": 43
    }
  ],
  "location": "EstimateLoanBorrowStep.error_message_displayed_with_phone_number(String)"
});
formatter.result({
  "duration": 194805668,
  "status": "passed"
});
});
$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/java/tests/Features/APITest.feature");
formatter.feature({
  "line": 1,
  "name": "Testing API using BDD",
  "description": "",
  "id": "testing-api-using-bdd",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 11,
  "name": "Test API POST Call",
  "description": "",
  "id": "testing-api-using-bdd;test-api-post-call",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 10,
      "name": "@api"
    }
  ]
});
formatter.step({
  "line": 12,
  "name": "I want to validate API",
  "keyword": "Given "
});
formatter.step({
  "line": 13,
  "name": "I make a POST call with data",
  "rows": [
    {
      "cells": [
        "user",
        "title"
      ],
      "line": 14
    },
    {
      "cells": [
        "ABC",
        "Manager"
      ],
      "line": 15
    }
  ],
  "keyword": "When "
});
formatter.step({
  "line": 16,
  "name": "response data should get added",
  "keyword": "Then "
});
formatter.match({
  "location": "testStepDef.i_want_to_validate_API()"
});
formatter.result({
  "duration": 190097665,
  "status": "passed"
});
formatter.match({
  "location": "testStepDef.i_make_a_POST_call_with_data(String,String\u003e\u003e)"
});
formatter.result({
  "duration": 3664219943,
  "status": "passed"
});
formatter.match({
  "location": "testStepDef.response_data_should_get_added()"
});
formatter.result({
  "duration": 2646831,
  "status": "passed"
});
});
Feature: Testing API using BDD

@api
Scenario: Test API Get Call
Given I want to validate API
When I make a get call
Then response should contain "Luke SkyWalker"


@api
Scenario: Test API POST Call
Given I want to validate API
When I make a POST call with data
|user|title|
|ABC|Manager|
Then response data should get added


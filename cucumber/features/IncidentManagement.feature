Feature: IncidentManagement

#Background:
#Given set the endpoint
#And set the authorization
@smoke
Scenario: Get all incident
 
When you send the request as get
Then verify the status code as 200
And print the response

Scenario: Create a new incident without body
 
When you send the request as post
Then verify the status code as 201
And print the response

Scenario Outline: Create a new incident with body
 
When create incident with short_description as '<short_description>' and category as '<category>'
Then verify the status code as 201
And print the response

Examples:
#header row |column1|column2|column3|
|short_description|category|
#data
|Display Issue|hardware|
|OS update|software|













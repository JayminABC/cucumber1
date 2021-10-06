Feature: amazon login feature


#Scenario: amazon login scenario

#Given user is on amazon login page
#When user enter <email> and <password>.
#| kachadiya | jaimin |
#Then validate user is correct account


#Scenario: amazon login scenario

#Given user is on amazon login page
#When user enter '5195050401' and 'jaimin@123'.
#Then validate user is correct account


Scenario Outline: amazon login scenario

Given user is on amazon login page
When user enter <username> and <password>.
Then validate user is correct account

Examples:
| username | password |
|	5195050401	|	jaimin@123 	|








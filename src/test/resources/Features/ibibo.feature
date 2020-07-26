
@tag
Feature: Goibibo

  @oneway
  Scenario: Book one-way flight
    Given I navigate the browser to Goibibo site
    And I select one-way trip
    And I select the From city as 'Bengaluru'
    And I select the Destination city as 'Frankfurt'
  	And I select the Departure date as '15/8/2020'
		And I select seat class as 'First class'
		And I book for '2' number of 'Adults' passengers
		And I click on Search button
		And I sort on price
		And I book the cheapest flight
		And I opt out of travel insurance
		And I enter the below passenger details
		|Passenger number|title|firstname|middlename|lastname|mobile|email|
		|1|Mr|Prince|tri|Paoluse|8553607878|prince.p@gmail.com|
		|2|Mrs|Mary|tri|Paoluse|8553607878|prince.p@gmail.com|
		And I enter 'prince.pri@gmail.com' and '8553608784' in the email and mobile number for the ticket section respectively
		And I click on Proceed button
		And I click on Proceed to Payment button
		
		@roundtrip
  Scenario: Book round trip flight
    Given I navigate the browser to Goibibo site
    And I select round trip
    And I select the From city as 'Bengaluru'
    And I select the Destination city as 'Frankfurt'
  	And I select the Departure date as '15/8/2020'
  	And I select the Return date as '25/8/2020'
		And I select seat class as 'Economy'
		And I book for '2' number of 'Adults' passengers
		And I click on Search button
		And I sort on price
		And I book the cheapest flight
		And I opt out of travel insurance
		And I enter the below passenger details
		|Passenger number|title|firstname|middlename|lastname|mobile|email|
		|1|Mr|Prince|tri|Paoluse|8553607878|prince.p@gmail.com|
		|2|Mrs|Mary|tri|Paoluse|8553607878|prince.p@gmail.com|
		And I enter 'prince.pri@gmail.com' and '8553608784' in the email and mobile number for the ticket section respectively
		And I click on Proceed button
		And I click on Proceed to Payment button
		
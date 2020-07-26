@tag
Feature: Title of your feature
  I want to use this template for my feature file
#
  #@registration
  #Scenario Outline: Registration
  #	Given I navigate the browser to Gillette '<region>' site
   #	And I click on Register link
   #	And I register the user with following details in the registration page
#		|Firstname|Lastname	|Email											|Password		|Zipcode	|Birthmonth	|Birthyear|
#		|<Firstname>|<Firstname>	|<Email>							|<Password>		|<Zipcode>	|<Birthmonth>	|<Birthyear>|
#		Examples:
#		|region|Firstname|Lastname	|Email											|Password		|Zipcode	|Birthmonth	|Birthyear|
#		|India|Prince		|Paulose	|prince.paulose@wipro.com		|12345@prin	|560058		|4					|1992			|
#		|Austria|Prince		|Paulose	|prince.paulose@wipro.com		|12345@prin	|560058		|4					|1992			|
#		
	@login
		Scenario Outline:Login
		Given I navigate the browser to Gillette '<region>' site
		And I login into the site with valid credentials
		Examples:
		|region|
		|India|
		|Austria|
#		
#			@forgot/resetpassword
#		Scenario Outline:Forgot/reset Password
#		Given I navigate the browser to Gillette 'India' site
#		And I click on forgot password and verify that mail is sent successfully
#		Examples:
#		|region|
#		|India|
#		|Austria|
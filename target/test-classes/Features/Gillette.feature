@gillette
Feature: Title of your feature
  I want to use this template for my feature file

  @registration
  Scenario Outline: Registration
    Given I navigate the browser to Gillette '<region>' site
    And I click on Register link
    And I register the user with following details in the registration page
      | Firstname   | Lastname    | Email   | Password   | Zipcode   | Birthmonth   | Birthyear   |
      | <Firstname> | <Firstname> | <Email> | <Password> | <Zipcode> | <Birthmonth> | <Birthyear> |
    Then I verify user is created successfully

    Examples: 
      | region  | Firstname | Lastname | Email                     | Password   | Zipcode | Birthmonth | Birthyear |
      | India   | Prince    | Charles  | prince.paulose11@gmail.com | 12345@Prin |  560058 |          4 |      1992 |
      | Austria | Prince    | John     | prince.paulose12@gmail.com | 12345@Prin |  560058 |          4 |      1992 |

  @login
  Scenario Outline: Login
    Given I start the driver
    Given I navigate the browser to Gillette '<region>' site
    And I login into the site with valid credentials

    Examples: 
      | region  |
      | India   |
      | Austria |

  @forgot/resetpassword
  Scenario Outline: Forgot/reset Password
    Given I navigate the browser to Gillette 'India' site
    And I click on forgot password and verify that mail is sent successfully

    Examples: 
      | region |
      | India   |
      | Austria |

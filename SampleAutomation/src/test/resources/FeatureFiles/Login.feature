#If the application enforces a password length limit of 50 characters instead of 60, it should display an error message indicating that the password exceeds the allowed length.
Feature: Login page of haboom website
@login
Scenario: If the application enforces a password length limit of Five Zero characters instead of Six Zero it should display an error message indicating that the password exceeds the allowed length.
Given a user signs up on the webpage
#When  the user enters "join now" with six zero characters in the joinnow field to register the account
#And the user tries to log in with the same six zero character account
#Then  the user should successfully log in to the account

#The user does not receive the proper error message when attempting to register with details that belong to an already registered account.

Scenario: The user does not receive the proper error message when attempting to register with details that belong to an already registered account.
  Given a user is on the join now page
    When the user fills in all valid fields on the join now page
    And the user clicks the register button
    And the user clicks the browser back button
    And the user clicks the register button again
    Then the user should receive a proper warning message
 #The username input box is accepting usernames with alphabetic characters only, which contradicts the expected behavior. However, it correctly rejects usernames with numeric characters only and displays an error message indicating that the username should be alphanumeric.  
      
    Scenario: The username input box is accepting usernames with alphabetic characters only, which contradicts the expected behavior. However, it correctly rejects usernames with numeric characters only and displays an error message indicating that the username should be alphanumeric.
    When the user fills in all valid fields on the join now page only alphabatic value in username field
    And the user clicks in the register button 
    Then the user should receive the proper warning message 
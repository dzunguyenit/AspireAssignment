Automation Page Object Model Framework - Using Java, Selenium, Maven, TestNG, Extent Report and Monte for screen recorder
Overview
This project is to provide a good starting structure point for those looking to use Java, Selenium and some other extensions. 
It is also intended to demonstrate how to implement design patterns in a test framework (Page Object Model), Where many test frameworks 
will give some solution demonstrates like scalable, maintainable, readable and repeatable.
Resources

Selenium
TestNg
Extent Report
Examples Demo suites:
Register successful with new account Incorporated/UnIncorporated
/*

SCENARIO: TC001_VerifyNewAccountCreatedSuccessfullyAndIncorporated
Precondition: An email valid
1: Goes to aspire login page
2: Click register link
3: Verify UI of Register page
4: Input valid info & submit (Singapore)
5: Verify user created successful
6: Click continue button to go business page
7: Select new account as director and click continue
8: Select more personal information details (Singapore)
9: Verify the Onboarding page shown successfully
10: Click button "Get Started" for Standard registration
11: Verify the Personal detail and input more info, then click continue
12: Verify the Business info and input valid date, then click continue
13: => I will ignore next steps for the onboarding with the KYC of Singapore */
/*

SCENARIO: REG_002_VerifyNewAccountUnincorporatedCountryForDirector
Precondition: An email valid
1: Goes to aspire login page
2: Click register link
3: Verify UI of Register page
4: Input valid info & submit (VietNam)
5: Verify user created successful
6: Click continue button to go business page
7: Select new account as director and click continue
8: Select more additional information details like company registered (Angola)
9: Verify the business unincorporated in Angola */
...

And data driven for register page
/*

SCENARIO: REG_007 to REG_015 Verity error messages for all register fields
Precondition:
1: Go to site https://feature-qa-automation.customer-frontend.staging.aspireapp.com/sg/
2: Click register link
3: Enter Valid All register fields and check term condition
4: Input invalid fields into the register form
5: Verify the error messages displayed correctly for all fields */
{
    {"REG_007 - Verity empty fullname", "fullname", "", "Full Name as per ID is required."},
    {"REG_008 - Verity empty email", "email", "", "Email address is required."},
    {"REG_009 - Verify empty phone number", "phone", "", "Mobile number is required."},
    {"REG_010 - Verify the email contains special character", "email", "#@%^%#$@#$@#.com", "Email address must be a valid email address."},
    {"REG_011 - Verify the email missing name", "email", "@gmail.com", "Email address must be a valid email address."},
    {"REG_012 - Verify the email mising @ domain", "email", "invalidemail.gmail.com", "Email address must be a valid email address."},
    {"REG_013 - Verify invalid email domain", "email", "invalidemaildomain@111.222.333", "Email address must be a valid email address." },
    {"REG_014 - Verify the invalid phone number with length more than 14 characters", "phone", "9785422155569", "Mobile number may not be greater than 14 digits."},
    {"REG_015 - Verify the invalid phone number contains string - fulfilled", "phone", "93789ghtrt", "Incorrect phone format for phone., The phone format is invalid."},
};
And data driven for login page
/*

SCENARIO: LOG_004 to LOG_012 Verity error message for invalid user login
Precondition:
1: Go to site https://feature-qa-automation.customer-frontend.staging.aspireapp.com/sg/
2: Enter Invalid Username
3: Click "Next" button
4: Verify the error message for invalid user */
{
    { "LOG_004 - Verity unregistered email", "email", "unregisteremail@gmail.com", "The entered email address is invalid." },
    { "LOG_005 - Verity unregistered phone number", "phone", "979566999", "The entered phone number is invalid." },
    { "LOG_006 - Verify empty username", "email", "", "The phone field is required when email is not present." },
    { "LOG_007 - Verify the email contains special character", "email", "#@%^%#$@#$@#.com", "Registered email or phone is invalid" },
    { "LOG_008 - Verify the email missing name", "email", "@gmail.com", "Registered email or phone is invalid" },
    { "LOG_009 - Verify the email mising @ domain", "email", "invalidemail.gmail.com", "Registered email or phone is invalid" },
    { "LOG_010 - Verify invalid email domain", "email", "invalidemaildomain@111.222.333", "The entered email address is invalid." },
    { "LOG_011 - Verify the invalid phone number with length more than 21 characters", "phone", "978542215554454544589663", "Registered email or phone is invalid" },
    { "LOG_012 - Verify the invalid phone number contains string", "phone", "93789ghtrt", "Registered email or phone is invalid" },
};
Pre-requisites
Tools & Libs:
Java 6 or Above
Right-click "Pom.xml" > Maven > Reimport
Intellij
Import Maven Project

Running Tests
Edit testng.xml to run suite, parallel or st else

Intellij menu, click Build > Build Project

$ mvn clean compile
Command Line
Run the test from file "RunProject.bat"
Run all tests through maven by testng.xml suites
$ mvn install or mvn test
Result
Report Overview GitHub Logo Format: Alt Text

Report Result GitHub Logo Format: Alt Text

Video Demo
Register 01 - new account incorporated

https://youtu.be/eEq9pwcZ4mc
Register 02 - new account unincorporated

https://youtu.be/g0jnGsZ7jT0
Register 07 - Data driven negative check

https://youtu.be/iX4X02J4Pho
Login 07 - Data driven negative check

https://youtu.be/boxtWvxSGas

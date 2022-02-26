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

SCENARIO: tc_01_LogInSuccessfully:
1: Go to aspire login page: https://aspireapp.odoo.com/
2: Log In with a username and password: user@aspireapp.com/@sp1r3app
3: Verify HomePage is open with url: https://aspireapp.odoo.com/web#cids=1&action=menu
and avatar user is displayed


SCENARIO: tc_02_CreateProductWithoutName:
Precondition: Log In Successfully
1. Click Inventory icon
2. Click Menu Products -> Products -> Go to Product Page
3. Click Create button
4. Click Save button
5. Verify error notification is displayed: "Invalid fields: Name"

SCENARIO: tc_03_CreateProductSuccessfully:
Precondition: Log In Successfully
1. Input random valid Product Name
2. Click tab Quantity: Update quantity > 10( data = 15)
3. Click Save button


SCENARIO: tc_04_CreateManufacturingOrderWithoutName:
Precondition: Log In Successfully and Create Manufacturing Order item
for the created Product on Scenerio: tc_03_CreateProductSuccessfully

1. Back to HomePage by clicking Application Icon
2. Click Manufacturing Menu
3. Click Create button
4. Click button Save Record
5. Verify error notification is displayed: "Invalid fields:"
6. Verify content notification is displayed: 
   Product
   Product Unit of Measure

SCENARIO: tc_05_CreateManufacturingOrderSuccessfully:
Precondition: Log In Successfully and Create Manufacturing Order item
for the created Product on Scenerio: tc_03_CreateProductSuccessfully

1. Input product name for the created Product on Scenario: tc_03_CreateProductSuccessfully
2. Get value of: quantity, scheduled date and responsible user -> Expected Result
3. Click Save
4. Status change -> draft -> Verify status draft is active
5. Click confirm -> Status change -> confirmed -> Verify status confirmed is active
5. Click Mark As Done -> Verify popup is displayed "There are no components to consume. Are you still sure you want to continue?"
6. Click Ok -> Verify popup is displayed "You have not recorded produced quantities yet, by clicking on apply Odoo will produce all the finished products and consume all components."
7. Click Apply -> Status change -> done -> Verify status done is active
8. Verify the new Manufacturing Order is created with corrected information includes: Product Name, Quantity, scheduledDate, responsibleUser

Pre-requisites
Tools & Libs:
Java 8 or Above
Right-click "Pom.xml" > Maven > Reimport
Intellij
Import Maven Project

Running Tests
Edit runAspire.xml to run suite

Intellij menu, click Build > Build Project

$ mvn clean compile

Command Line
Run the test from file "RunProject.bat"
Run all tests through maven by runAspire.xml suites

$ mvn test

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

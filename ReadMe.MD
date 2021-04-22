**Selenium WebDriver page object model in Java using TestNG and Maven as a build tool.**
following  Configuration Properties are used:
Url Base URL (https://www.contorion.de/)
Browser Name: (chrome)

**Pre-requisites:**
JVM
Maven
Chrome browser version on Mac machine: 89.0.4389.114  or below 89.0.4389.114 

Download git hub project and run the below command from project home folder - from the location where pom.xml is located.

`mvn clean install
`

After the successful execution of the test cases. Run the below command to open the reports and screenshots.

To open the reports. Run the below command

`open target/surefire-reports/index.html`


It will display all the test cases and its status

**To open the screenshots**

`open screenshots/<imagename>.png`
`
Images are generated with the time stamp.


######################################

**Following Tests are automated:**
1. Smoke Test: Verify when user hits the website in the browsers tab, it should get opened (independent on http or https protocols)
2. Smoke Test: Accepting cookies when the website is ready.
3. Sanity Test: Verify registered users are able to login successfully with valid credentials (username + password)


**Folder structure Explaination:**
1. `src/resources contains` -> config properties(Test DATA) and driver for the execution of tests on Mac or Windows OS.
2. `src/test/utilities` contains -> 
BaseTest which is responsible for initialising the browser, properties file (configurations+ Test Data).
Generate Screenshot utility will be responsible for taking the screenshots.
3. `src/test/pages` contains the webelements and actions on the webelements.

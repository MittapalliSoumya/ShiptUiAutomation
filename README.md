# ShiptUiAutomation

Tools Used For UI automation Framework : JAVA, selinium, testNg, Page object Model

Steps to use the frameworks
1. Checkout the git repo ShiptUiAutomation  Note: pom.xml will download all the respective dependancy
2. Navigate to Modules folder and click on testSelectedStore.java . 
   2 a. The summary of the test scenario is to login to application and choose a storeName for shopping
   2 b. Verify the store name based on the input given
3. testSelectedStore class extends Base test. All the test preconditions are handled in this file
4. All the pages and locators are in respective pages. Test class will call pages based on the scenario.
   Through this model we achieve code reusablity and encapsulation
5. For failed scenarios screen shots are taken

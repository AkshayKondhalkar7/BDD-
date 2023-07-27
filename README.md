Q. What is this repository for?
 This repository is created for Testing FP Applications. We will be writing Automation Test Scripts using 
1. Programming Language - Java (JDK 11)
2. Automation Tool - Selenium (4.x.x)
3. BDD Tool - Cucumber (7.x.x)

Q. How do I get set up?

Only One-time activity

Step 1 : From your IDE(Eclipse) Click on Help-->Eclipse Marketplace-->Search "Cucumber Eclipse PLugin"-->Click on Install

Step 2 :  From your IDE(Eclipse) Click on Help-->Install New Software-->Work with type "https://rlogiacco.github.io/Natural"-->Click on Natural Checkbox-->Next-->Install

Once both the plugins are installed we are done with the basic setup.

Step 3:Clone the Repo and start adding test scripts.


Q. How do I run tests?

To Run from the command line hit the below commands in sequential order

mvn clean
mvn compile
mvn test

Q. Contribution guidelines

Contributor has to create a branch with his name example (pavan-integration) on bitbucket and push code to your branch only
if this code is working or executing as per expected on Circleci then you will raise a Pull Request to the Integration branch.

Every Feature(Test Case) should have at least one tag.
A Feature can also have multiple tags as per requirement.

Make sure you are using code quality check tools. example - Sonarlint, SonarCube

Q.Functionality Of Each Class and Interface


Feature File- In this file, we are writing scenarios(test cases), by using gherkin keywords like Given, When, Then, And, But.
The extension of this file is .feature.These Files are shown in green color. A feature file contains scenarios in which we will be 
written by a combination of gherkin keywords and the English language. 

For Every module different feature folders will be created and we have to write scenarios accordingly.

Step Definition - This is basically our Java class where we are writing the implementation steps for scenarios that are declared in the feature file.
All step definition classes in the project will be stored module(separate Java packages) wise. example - stepdefination.user

Hooks - In this class have written code launching the browser, taking screenshots of failed scenarios, logout from the application, and closing the browser.

Runner - This Class will take care of execution. Here we have to provide a path for the feature file, step definition class, and hooks class.
	If we want to execute tagged scenarios then provide tags as well.


# SauceDemo
This project contains automated tests for the SauceDemo application using Selenium WebDriver. The tests are written in Java and use the TestNG framework.
The project aims to demonstrate how to perform automated UI testing for a web application; in this case: SauceDemo — a website for testing purposes where the main goal is to add items to cart and finish shopping.

## Dependencies
* Run on Windows 10 OS
* IDE for this project is IntelliJ Idea Community Edition 2024.1
* Browsers needed is Chrome (mandatory)

## Instalation

Open terminal in IDE and git clone the repository

```
git clone https://github.com/DamjanQA/SauceDemo-SeleniumAutomation.git
```
* java version "21" 2024-01-16 LTS
* Apache Maven 3.9.6

## Framework Walkthorugh
Packages:
* Base - Contains classes used throughout the app
* Pages - Contains classes for each page
* Tests - Contains test classes

Files:
* pom.xml - Contains all dependencies used in the project (last updated: 23.06.2024.)
* SauceDemoTestCases.xlsx - Contains all the test cases used for the project
* .gitignore - File used to store all items that are not pushed to github

## Naming Convention
* Classes are written in camel case with first character in upper case
* Methods are written in camel case with first character in lower case
* Class objects are named the same as a class name with lower case for first character
* Test methods are named as test case names

## Other
* Test methods are kept clean
* Each test should have at least 2 assertions with few test exceptions
* Priorities are set with 10 increment, if higher priority occur later in testing, priority of such tests are placed between the two priorities

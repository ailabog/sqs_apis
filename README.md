Solution for DXP Data
========================================
The **Solution holds the implementation for all the tests for DXP Data Project, 
it will be a placeholder for all the functionalities like SQS Message Queue, Bad Data Report API.

## Getting Started

* * **Minimum requirements** — To use the sample application, you'll need Java 7 (or later) and [Maven 3](http://maven.apache.org/)
* **Clone the project ** using the following command: git clone git@bitbucket.org:amcnds/java-test-framework-da.git.

## Requirements
* Install IntelliJIdea Community Edition 2021.
* Install Java 8.
* Install git (bash is important).
* A private key needs to be generated and added to BitBucket account 
* Clone the project from BitBucket using the command git clone git@bitbucket.org:amcnds/java-test-framework-da.git.
* Open IntelliJIdea and open the project just cloned.
* Go to Maven and run:
                * mvn clean
                * mvn install
* pom.xml file should include all the necessary dependencies (if not, go to the file and run Maven Download sources).

## Project Structure
* Project is structure as follows:
                               * main - contains all the necessary classes for the tests' implementation
                               * test - contains all the tests with resources (URLs, queues name, etc.)
                               * pom.xml with all the necessary dependencies used in the solution


## How to run a test
* Each test can be run from test/java/com.dxp.data package
* Just right-click on the wanted test and run
* The result of the test can be seen into the console in IntelliJIdea

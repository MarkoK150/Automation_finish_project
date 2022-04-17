# Automation_practice_project

### Requirements before starting application

Install Java, Maven and Allure report.


## Instruction


- Clone project on your computer.

- Open project in some IDE  (example: IntelliJ IDEA)

- Build Project (enter command in terminal: mvn clean install  and click button "Build Project") 

- Click button Add configuration 
 
    1.Add new configuration
    
    2.Click TestNG
     
    3.In Test king field - chose Suite 
    
    4.In Suite field upload GeneralTestNG.xml file from project folder.

- Click button Run and start all tests.

- After finish all tests you can see report. 

### - How open report Allure?


1. Right click on folder "allure-result" and click "Open In" and click "explorer". 
 
2. Now,click on folder "allure-result" and copy apsolut address .

Open Command Prompt and write allure serve apsolut address and press enter.

example: allure serve ...\Automation_practice_project\allure-results

### Note

If you first time use IntelliJ IDEA you must install plug in Cucumber for Java and Gherkin. (Click Fille-Setting-PlugIn)

In this Project default chromedriver version 100. If you use any another version you must copy that in Project Resource. And you must change Browser version in GeneralTestNG.xml File.

## Project name
* Spring Bulls & Cows game

## Authors
* Name: Ahmad Alyan
  
## Description
* This is Bulls and Cows game.
The program generates a 4-digits number, while the player tries to guess it.
Each digit appears at most once. e.g. 1234 is valid, but 1233 is not valid.
For every guess that the player makes, we display 2 values:
the number of bulls: 1 bull means the guess contains and the target number have 1 digit in common, and in the correct position.
the number of cows: 1 cow means the guess and the target have 1 digit in common, but not in correct position.
For example if the number to guess is 1234. Guessing 4321 will give 0 bulls and 4 cows. 3241 will give 1 bull and 3 cows.
4 bulls means that the user won the game.
* After winning, the winner will be shown his own score with a form in which he can fill out his name (new name that not exist before)
in order to be added to the database, and after sending the form, a table will be shown to the winner with the name and 
score of the best five winners. 
* In addition to the game, there is a login button where the administrator can log in, which gives him many features that
an ordinary user cannot see, such as first seeing the result without having to try, in order to check the game.
Secondly, he can see all the users who have entered their names, not just the best Five winners.
Third, he can delete the entire database, or he can delete a specific winner when clicking on him.

### Functionality
1) SpringBoot MVC (Model, View, Controller).
2) thymeleaf view engine.
3) Beans, dependency injection.
4) Storing persistent data with JPA - mySQL.
5) Spring security.
6) Maven.

## Installation
* In the first time:
1) start Apache and MySQL from XAMPP.
2) click on admin beside MySQL.
3) if dataBase note exist click on new then create a new dataBase with "ex5" name.

## Getting Started
* To run the application after finishing with Installation, follow these steps:
1) start Apache and MySQL from XAMPP.
2) run the Project (Run 'Ex5TemplateApplication') -> "mvn spring-boot:run".

## Useful information
* admin login details:
username: admin
password: password
* You can view the DataBase by "/debug/winners" (This endpoint is accessible to admin only).

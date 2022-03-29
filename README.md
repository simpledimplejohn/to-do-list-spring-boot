# To-Do List server

To-do-list server is a backend api written in Java Spring-Boot, built as a mavin project, and dockeried and depoloyed to an EC2 on AWS.  Supports the front end user interface that allows users to create accounts, login, make to-do lists, add items to these lists, and mark them as completed.

# Front End Repository

The front-end for this application has been written in Angular and can be found at this link:
_[FRONT END](https://github.com/simpledimplejohn/to-do-list-angular)_

## Tech Stack

This web app was developed using : 
  * Java, Junit , Mockito, Log4J , Maven .
  * PostgreSQL, Spring Data, Spring MVC, Spring Boot.
  * Angular 2+, TypeScript, JavaScript, Bootstrap , HTML , CSS.
  * AWS EC2, AWS RDS,  AWS CodePipeline, AWS S3, Docker.
  * REST,  Sonarcloud, Agile-Scrum. 



## User stories

As a user I can : 

- Register 
- Login
- Create a to-do list
- Add items to this list
- Delete items from the list
- View lists


## API Documentation

| Route                                                               | Method | Status Code | Description                                                         |
| ------------------------------------------------------------------- | ------ | ----------- | ------------------------------------------------------------------- |
| /users                                                          | GET    | 200         | Returns a list of all users                                         |
| /users/:id                                                      | GET    | 200         | Returns a the user with the id                                      |
| /users/add                                                      | POST   | 201         | Creates a new user                                                  |
| /users/find/<User>                                              | GET    | 200         | find a user by email and password                                   |
| /users/:id                                                      | DELETE | 200         | Delete the user for the given ID                                    |
| /users/{id}/findLists                                           | GET    | 200         | Returns a list of the users to-do-lists                             |
| /users/{id}/addListToList                                       | PUT    | 201         | Adds a to-do-list to the users lists                                |  | /users/deleteListFromUserList{id}                               | Delete | 204         | delete a users to-do-list                                           |
| /items/                                                         | GET    | 200         | Returns a list of all items                                         |
| /items/:id                                                      | GET    | 200         | Returns an item with the id                                         |
| /items/delete/:id                                               | DELETE | 204         | Deletes the item with that id                                       |
| /items/:lid/add/<Item>                                          | PUT    | 200         | Adds an item to a list by the list id (lid)                         |
| /lists/                                                         | GET    | 200         | Returns a list of all lists                                         |
| /lists/:id                                                      | GET    | 200         | Returns an list with the id                                         |
| /lists/add/<ToDoList>                                           | POST   | 201         | Creates a new list                                                  |
| /lists/:id/itemList                                             | GET    | 200         | Returns a list of items by that list id                             |
| /lists/:id/add/<Item>                                           | PUT    | 201         | Adds an item to that list by list id                                |
| /lists/:id/addArray/List<Item>                                  | PUT    | 201         | Adds an array of items to a list by that lists id                   |
| /lists/delete/:id                                               | DELETE | 204         | Deletes a list by its id                                            |

## Setup/Installation

* _Download repo from github_
* _In the root folder run the command line command `mvn clean install`_
* _Run the mavin file_
* _Access on localhost://5000_

## Known Bugs and Future Changes

* _Add validation to models_
* _Add DTO's for increased security_

## License

_[MIT](https://opensource.org/licenses/MIT)_

_Copyright (c) 2022 John Blalock_

## Contact Information

_simpledimplejohn@gmail.com_
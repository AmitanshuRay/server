
# Server API

This is a Java application that provides a REST API with endpoints for searching, creating and deleting "server" objects. Spring web framework and a mongodb server are used in this project to provide this API.

Project developed as part of an assignment by Kaiburr.

## Table of contents
- Usage
- Endpoints
- Examples

## Installation
1. Download **server.jar** file into your local repository and cd into it
2. Make sure you have jdk 19 and mongodb 6 installed on your machine
3. start mongodb on your machine. On linux that would be using:
    > sudo sytemctl start mongod
4. run **server.jar** file

## Usage
 Use **postman** to get, post and delete

## Endpoints
- GET **'/'** - returns all server objects as json
- GET **'/{id}'** - returns the server object that matches that id else returns a 404
- GET **'/name/{name}'** - returns all server objects with names that contain the {name} string, else returns a 404
- PUT **'/'** - takes in a JSON encoded message body and stores it in a mongodb server
- DELETE **'/{id}'** - deletes the serves that the has {id} as its id

## Examples
Examples of the API using **Postman**
- GET **'/'** :
  ![img_1.png](img_1.png)
- GET **'/{id}'** :
  - when id is found:
      ![img_2.png](img_2.png)
  - when id is not found:
      ![img_3.png](img_3.png)
- GET **'/name/{name}'** :
  - when name is found:
      ![img_4.png](img_4.png)
  - when name is not found:
      ![img_5.png](img_5.png)
- PUT **'/'**: 
   ![img_6.png](img_6.png)
- DELETE **'/{id}'**:
   ![img_7.png](img_7.png)
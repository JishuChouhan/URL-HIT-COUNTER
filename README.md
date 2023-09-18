# Project Name

Project Name is a Url Hit Counter Api 
## Table of Contents

- [Frameworks and Language Used](#frameworks-and-language-used)
- [Dataflow](#dataflow)
- [Data Structure](#data-structure)
- [Project Summary](#project-summary)

## Frameworks and Language Used

- **Java**: The primary programming language used for developing the application.
- **Maven**: A build automation tool and dependency management tool used for managing the project's dependencies and building the application.
- **Spring Boot**: A framework built on top of the Spring framework, providing rapid application development features for creating stand-alone, production-grade Spring-based applications.

## Dataflow

The Url Hit Counterfollows the following data flow:

1. **Client Interaction**: The client, such as Postman, sends requests to the Localhost server using url provider .

2. **Controller Layer**: In the Spring Boot application, the incoming requests are handled by the Controller layer. The Controller receives the requests and delegates them to the appropriate methods in the service layer.

3. **Service Layer**: The Service layer contains the business logic of the application and handles Counting and Storing Part. When a request is received from the Controller, the Service layer performs the necessary actions. 

4. **Database**: The database stores the username and count. 
This is done uing hashmap.

5. **Response**: After the data operation is completed, the response flows back through the layers in the reverse order. The Service layer receives the response from the Data Access layer, performs any necessary post-processing or formatting, and sends it back to the Controller.

6. **Controller Response**: The Controller layer receives the response from the Service layer and returns an appropriate HTTP response to the client, indicating the success or failure of the requested operation.

## Data Structure

1.  **HashMap**  : This is used for as a DataBase and stores the User InforMation in form of User class.


## Project Summary

The Project is used as a simple url hit counting api and helps client revisit/analyse/check url activity . 

## Installation and Usage

Run code using an ide and check workings on postman.

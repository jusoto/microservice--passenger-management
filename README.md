# Passenger Management Micro Service

This Micro Service takes care of the information of the passengers.

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

### Prerequisites

The following applications must have been installed in your system previous to run this application.

 - Java8
 - RabbitMQ
 - MySQL Server 5
 
### Installing

Check MySQL root and username and password on file:
   src/main/resources/application.properties
   
Create DB on MySQL:
   passengermanagementdb

To build the microservice run command on root directory of the project:
   ./gradlew clean build bootRun
   

## Running the tests

Test http://localhost:8081/api/passengers -GET

## Deployment

This Micro Service is part of a group of Micro Services that work together as a Taxi App

## Built With

* [Spring Boot](https://spring.io/docs) - Application Framework
* [Gradle](https://docs.gradle.org/4.2/release-notes.html) - Dependency Management

## Authors

* **Juan Sotomayor**

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details



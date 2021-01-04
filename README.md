# Online shopping application backend-skeleton
- [System Design](#system-design)
- [Software development principles](#software-development-principles)
    - [DRY](#dry)
    - [KISS](#kiss)
    - [SOLID](#solid)
    - [Clean Architecture](#clean-architecture)
- [Project folder structure and framework](project-folder-structure-and-framework)
- [How to run the application](#how-to-run-the-application)
- [APIs Document](#apis-document)

## System Design

![System Design](images/system_design.png)

- **Product Service**: Manages our products. This service also provides the ability to allow user could filter, sort and search for products based on dynamic criteria.
- **Userlog Service**: Records customers activities (updating, filtering, sorting, viewing product detail).
- **ShopCart Service**: Manages customer's shopping carts.
- **Order Service**: Manages customer orders.
- **Keycloak Service**: Identity and access management, manages user, roles and scopes. [Have not implemented yet]
- **API Gateway**: Route requests to multiple services using a single endpoint.

## Software development principles

### DRY
DRY stand for "Don't Repeat Yourself," a basic principle of software development aimed at reducing repetition of information

### KISS
The KISS principle is descriptive to keep the code simple and clear, making it easy to understand

### SOLID
The SOLID Principles are five principles of Object-Oriented class design. They are a set of rules and best practices to follow while designing a class structure
- **The Single Responsibility Principle (S)**: A class should do one thing and therefore it should have only a single reason to change.
- **The Open-Closed Principle (O)**: Classes should be open for extension and closed to modification.
- **The Liskov Substitution Principle (L)**: Subclasses should be substitutable for their base classes.
- **The Interface Segregation Principle (I)**: Keeping things separated, and the Interface Segregation Principle is about separating the interfaces.
- **The Dependency Inversion Principle (D)**: Our classes should depend upon interfaces or abstract classes instead of concrete classes and functions.

### Clean Architecture
Clean architecture refers to organizing the project so that it's easy to understand and easy to change as the project grows. This doesn't happen by chance. It takes intentional planning.

![Clean Architecture](images/clean_architecture.jpg)


## Project folder structure and framework

![Project structure](images/project_folder.png)

- **Configuration package**: Contains logics to tie bussiness rule and external framework or library
- **Delivery package**: Contains logic to send/receive request from user/service for handling 
- **Persistence package**: Contains logic for saving data into database or file server...
- **Core package**: Contains bussiness model and bussiness rule only, it does not use any library or framework for supporting

## How to run the application

- Install Java 11
- Install Docker
- Install Maven
- Clone source, go to folder ../icom and continue as below
- Open terminal and run command: docker-compose up (ensure docker-compose.yml file in the same folder)
- Configuration RabbitMQ
- Go to: http://localhost:15672/ and login with account: rabbitmq/rabbitmq
- Create Queue, Exchange and Binding as below

Create Queue
![Create Queue](images/create_rabbitmq_queue.png)

Create Exchange
![Create Exchange](images/create_rabbitmq_exchange.png)

Create Binding
![Create Binding](images/create_rabbitmq_binding.png)

## APIs Document

**Product service**

**Order service**

**Shopcard service**

**Userlog service**
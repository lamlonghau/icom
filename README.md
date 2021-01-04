# Online shopping application backend-skeleton
- [System Design](#system-design)
- [Software development principles](#software-development-principles)
    - [DRY](#dry)
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
- **Keycloak Service**: identity and access management, manages user, roles and scopes. [Have not implemented yet]
- **API Gateway**: Route requests to multiple services using a single endpoint.

## Software development principles

### DRY

### SOLID

### Clean Architecture

## Project folder structure and framework
## How to run the application
## APIs Document
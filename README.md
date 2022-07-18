# Av2 :books:

Kotlin web application

## About this project :bulb:

Web application with CRUD operations by access level

### Database Schema:

![MySQL_demo_physical_data_model-2022-07-03_00-30](https://user-images.githubusercontent.com/56542755/177023400-e839c0d5-42e2-45b6-9599-5a9b480b607a.png)

## User functionalities :robot:

Login, CRUD operations and access level verifications as described bellow

### Login:

- Login with username and password
- If successful the browser will store a cookie to maintain the user logged

### CRUD operations:

- Animals

  - Create, read, update and delete
  
- Species and sub-species

  - Create, read, update and delete
  
- Diet and movement

  - Read
  
### Access Level:

- Admin: all operations in the system
- User: only read operations

## Instructions :gear:

Follow this to install and run this project

### Install Kotlin

Depending on your IDE:

- [Netbeans](https://github.com/JetBrains/kotlin-netbeans)

### Change db config

You can go to **DbConfig class** and change the following values as you like to change db name, user and password respectively

``` kotlin
private const val dbName = "av2"
private const val user = "root"
private const val password = "gremio10"
```

## Built With :bricks:
- [Kotlin](https://kotlinlang.org/)
- [Hibernate](https://hibernate.org/orm/documentation/6.0/)
- [Servlets](https://jakarta.ee/specifications/servlet/5.0/)
- [Maven](https://maven.apache.org/guides/index.html)



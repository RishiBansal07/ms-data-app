# DATA API

This project allows manage the details of the person and the pet. It should allow adding,
updating, removing, and fetching the details of the person and pet. 

##########################################################################
### Table Definition
##########################################################################

We have created the below table:

##Users table:

    | ID  | First Name | Last Name | Date of Birth | Address

Further, we have one more referenced tables from Users

##Address table:

    | ID  | Street name | House Number | Zip code | City | Country

There is another standalone pet table:
##Pet table:

    | ID  | Age | Name 

###########################################################################
## Design Thought
###########################################################################

```
1. Use of Simple Approach with diiferent layers of Access using Controller and Service layer.
2. There are different API points.
3. Possible Scenarios Cover in order and Keeping Future Approach of implementation
4. JUnit Followed Mocking of Object verification using Mockito 
5. Integration tests are present in integration folder inside the test directory.
6. To Test Swagger Configured to test and verify Output of the APIs
7. Maven for Build of project and Configuration of Dependencies
```

##########################################################################
## API points
##########################################################################

The project need to expose 4 endpoints, that can talk to database layer.

| OPERATION | ENDPOINT             | DESCRIPTION                                                                                   |
|-----------|----------------------|-----------------------------------------------------------------------------------------------|
| GET       | /public/users        | Endpoint fetches all the users                                                                |
| GET       | /public/users/{id}   | Endpoint fetches the required data based on the input variables                               |
| POST      | /public/users        | Endpoint inserts the new records based on the data from external provider                     |
| PUT       | /public/users/{id}   | Endpoint updates the existing data based on the input data that has to be changed             |
| GET       | /public/users/search | Endpoint fetches the required data based on the input variables i.e. First name and last name |
| POST      | /public/pet          | Endpoint inserts the new records based on the data from external provider                     |
| PUT       | /public/pet/{id}     | Endpoint updates the existing data based on the input data that has to be changed             |
| GET       | /public/pet          | Endpoint fetches all the pets                                                                 |


> - **Authorization of API**<br />
    > **Required:** Table User, every-request will go through a @PreAuthorize method that will communicate with the user
    table with the UUID coming from the JWT token or specific header value or admin credentials can be used.

##########################################################################
## Skill set used
##########################################################################

- Java 17
- Spring Boot 3.2.1
- H2
- Test Driven Development
- Junit

##########################################################################
## STEPS To Execute
##########################################################################

```
1. Import project in your workspace
2. mvn clean install
3. After Successful build, launch Spring build Application using command 
	mvn spring-boot:run or initiate your application using Intellij for Spring boot
4. once Spring boot initiated, launch Swagger using http://localhost:8080/swagger-ui.html#
5. Execute and perform your API Invocation
7. Cheers and Enjoy API Processing :)
```

## WE ARE READY?

let's start the microservice project, so by default it will start on the port localhost:8080 now!

## Swagger API

> Access Swagger API page on the URL **http://localhost:8080/swagger-ui.html**

###########################################################################
## Enhancements
###########################################################################

> - Tracing of API logs with use of ELK approach
> - Jacoco for code coverage tool - execution can be defined as Min to 80%
> - **Dockerizing the APP**<br />
> - **Using a definitive instance of DB (POSTGRES, ORACLE)**<br />
> - Relation between user and pet. A pet must have a user assigned while a single user can have multiple pet.

###########################################################################
## Testing
###########################################################################

```
1. Postman
2. Swagger
3. Junit
```

###########################################################################
## Contact Email
###########################################################################

- brishi2806@gmail.com

###########################################################################
## Thank You
###########################################################################


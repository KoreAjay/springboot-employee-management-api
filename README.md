# springboot-employee-management-api
A RESTful Employee Management API built with Java and Spring Boot, implementing CRUD operations, DTO pattern, validation, layered architecture, and Spring Data JPA.

# Employee Management CRUD API

A RESTful Employee Management application built using **Java and Spring Boot**. This project demonstrates a clean layered architecture and implements CRUD operations using the **DTO (Data Transfer Object) pattern** to separate API models from persistence entities.

## 🚀 Features

* Create Employee
* Get Employee by ID
* Get All Employees
* Update Employee
* Delete Employee
* Request and Response DTOs
* DTO to Entity mapping
* Entity to Response DTO mapping
* Input validation using Jakarta Validation
* Email uniqueness validation
* Layered architecture
* Spring Data JPA integration
* MySQL database integration
* Password excluded from API responses

## 🛠️ Tech Stack

* Java
* Spring Boot
* Spring Web
* Spring Data JPA
* MySQL
* Hibernate
* Lombok
* Jakarta Validation
* Maven

## 🏗️ Project Architecture

```text
Client / Postman
        ↓
Controller Layer
        ↓
Service Layer
        ↓
Mapper Layer
        ↓
Repository Layer
        ↓
MySQL Database
```

### DTO Flow

```text
CREATE / UPDATE

JSON Request
      ↓
EmployeeRequestDTO
      ↓
EmployeeMapper
      ↓
Employee Entity
      ↓
Repository
      ↓
Database
```

```text
GET Operations

Database
      ↓
Employee Entity
      ↓
EmployeeMapper
      ↓
EmployeeResponseDTO
      ↓
JSON Response
```

## 📂 Project Structure

```text
src
└── main
    ├── java
    │   └── in.strikes.Crud_Dto_Demo_Eample
    │       ├── controller
    │       │   └── EmployeeController.java
    │       ├── dto
    │       │   ├── EmployeeRequestDTO.java
    │       │   ├── EmployeeResponseDTO.java
    │       │   └── mapper
    │       │       └── EmployeeMapper.java
    │       ├── entity
    │       │   └── Employee.java
    │       ├── repositary
    │       │   └── EmployeeRepository.java
    │       ├── service
    │       │   └── EmployeeService.java
    │       └── CrudDtoDemoEampleApplication.java
    │
    └── resources
        └── application.properties
```

## 🔄 DTO Pattern

### Employee Entity

The Entity represents the database table and contains all employee-related fields.

```text
id
name
email
password
department
salary
```

### EmployeeRequestDTO

Used to receive data from the client.

```text
name
email
password
department
salary
```

### EmployeeResponseDTO

Used to return safe data to the client.

```text
id
name
email
department
salary
```

The password is intentionally excluded from the response DTO to avoid exposing sensitive information.

## 🔗 API Endpoints

| Method | Endpoint              | Description           |
| ------ | --------------------- | --------------------- |
| POST   | `/api/employees`      | Create a new employee |
| GET    | `/api/employees`      | Get all employees     |
| GET    | `/api/employees/{id}` | Get employee by ID    |
| PUT    | `/api/employees/{id}` | Update employee       |
| DELETE | `/api/employees/{id}` | Delete employee       |

## 📌 Create Employee

### Request

**POST** `/api/employees`

```json
{
  "name": "Ajay Kore",
  "email": "ajay@example.com",
  "password": "password123",
  "department": "Engineering",
  "salary": 60000
}
```

### Response

```json
{
  "id": 1,
  "name": "Ajay Kore",
  "email": "ajay@example.com",
  "department": "Engineering",
  "salary": 60000.0
}
```

## 🔍 Get Employee by ID

**GET** `/api/employees/1`

### Response

```json
{
  "id": 1,
  "name": "Ajay Kore",
  "email": "ajay@example.com",
  "department": "Engineering",
  "salary": 60000.0
}
```

## ✏️ Update Employee

**PUT** `/api/employees/1`

### Request

```json
{
  "name": "Ajay Kore Updated",
  "email": "ajayupdated@example.com",
  "password": "newpassword123",
  "department": "Java Development",
  "salary": 75000
}
```

### Response

```json
{
  "id": 1,
  "name": "Ajay Kore Updated",
  "email": "ajayupdated@example.com",
  "department": "Java Development",
  "salary": 75000.0
}
```

## 🗑️ Delete Employee

**DELETE** `/api/employees/1`

### Response

```text
Employee deleted successfully
```

## ⚙️ Database Configuration

Create the MySQL database:

```sql
CREATE DATABASE employee_db;
```

Configure `application.properties`:

```properties
spring.application.name=employee-management

server.port=8080

spring.datasource.url=jdbc:mysql://localhost:3306/employee_db
spring.datasource.username=root
spring.datasource.password=YOUR_PASSWORD

spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
```

Replace `YOUR_PASSWORD` with your local MySQL password.

## 🧪 Validation

The application uses Jakarta Bean Validation for request validation.

Examples:

```java
@NotBlank(message = "Name is required")
private String name;

@Email(message = "Invalid email")
private String email;

@NotBlank(message = "Password is required")
private String password;

@Positive(message = "Salary must be greater than 0")
private double salary;
```

The controller uses `@Valid` to trigger validation before processing the request.

```java
@PostMapping
public ResponseEntity<EmployeeResponseDTO> createEmployee(
        @Valid @RequestBody EmployeeRequestDTO requestDTO) {
    // ...
}
```

## 💡 Key Concepts Demonstrated

* REST API design
* CRUD operations
* Layered architecture
* DTO pattern
* Request and Response DTO separation
* DTO to Entity mapping
* Entity to DTO mapping
* Input validation
* Exception handling using `orElseThrow`
* Spring Data JPA
* MySQL integration
* API security fundamentals by preventing password exposure

## 🔮 Future Improvements

* Global Exception Handling using `@RestControllerAdvice`
* Custom exceptions
* Standard API error responses
* Password encryption using BCrypt
* Spring Security
* JWT Authentication and Authorization
* Role-based access control
* Pagination and Sorting
* Search and filtering
* MapStruct for automated DTO mapping
* Swagger / OpenAPI documentation
* Unit and Integration Testing
* Docker support

## 👨‍💻 Author

**Ajay Kore**

Java Developer | Spring Boot | REST APIs | Spring Data JPA | MySQL

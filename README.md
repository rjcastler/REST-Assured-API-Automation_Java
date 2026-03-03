# 🚀 RestAssured API Automation Framework (Java + JUnit 4)

A robust and scalable **API Test Automation Framework** built using **Java, RestAssured, and JUnit 4**, designed for validating RESTful web services including CRUD operations, authentication mechanisms, and response validations.

----

## 📌 Tech Stack

- Java 8+
- RestAssured
- JUnit 4
- Maven
- Hamcrest
- JSON Path
- IntelliJ IDEA

---

## 📁 Project Structure


RestAssured_API_Automation_Java

│

├── src

│   ├── main

│   │   └── java

│   │       ├── authentication.methods

│   │       ├── crud.operations

│   │       └── org

│   │

│   └── test

│

├── pom.xml

└── README.md


---

## 📦 Package Description

### 🔹 authentication.methods
Contains API authentication implementations such as:
- Basic Authentication
- Bearer Token Authentication
- OAuth (if applicable)

### 🔹 crud.operations
Contains test implementations for:
- Create (POST)
- Read (GET)
- Update (PUT/PATCH)
- Delete (DELETE)

### 🔹 org
Contains:
- Utility classes
- Configuration handling
- Common reusable methods

---

## ⚙️ Framework Features

✔ CRUD API validation
✔ Authentication handling
✔ Response status code validation
✔ Response body validation
✔ Header validation
✔ JSON Schema validation support
✔ Logging of request & response
✔ Reusable API utility methods
✔ Maven-based execution

---

## 🧪 Sample Test Case

```java
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.junit.Test;

public class CreateUserTest {

@Test
public void createUserTest() {

String requestPayload = "{ \"name\": \"John\", \"job\": \"QA Engineer\" }";

given()
.baseUri("https://reqres.in/api")
.header("Content-Type", "application/json")
.body(requestPayload)
.when()
.post("/users")
.then()
.statusCode(201)
.body("name", equalTo("John"));
}
}



🏃 How to Run the Tests


▶ Using IntelliJ IDEA
Right-click on the test class

Click Run



▶ Using Maven (Command Line)
mvn clean test


📊 Validations Covered
✅ Status Code Validation (200, 201, 400, 401, 404, 500)

✅ Response Body Assertions

✅ JSON Path Validation

✅ Response Time Validation

✅ Headers Validation

✅ Schema Validation (if implemented)



🔐 Authentication Supported
Basic Authentication

Bearer Token Authentication

OAuth 2.0 (extendable)


🔧 Prerequisites
Java installed and configured

Maven installed

IDE (IntelliJ Recommended)


To verify installations:


java -version
mvn -version


🚀 Future Enhancements
Integration with Cucumber (BDD Framework)

Allure Reporting

CI/CD Integration (GitHub Actions / Jenkins)

Dockerized Test Execution

Environment-based Configuration

Parallel Test Execution

TestNG Migration Option



🎯 Framework Objective


This project demonstrates:

Strong REST API automation knowledge

Clean project structure

Reusable & maintainable framework design

Industry-level best practices


👨‍💻 Author


Raghavendra J

Senior QA Automation Engineer

API & UI Test Automation Specialist

⭐ If you found this project helpful, feel free to star the repository!


---

### 🔥 Next Level (Optional Upgrade)

If you want, I can now:

- Add **GitHub badges**
- Add **CI/CD workflow YAML**
- Add **Allure report integration**
- Make it look like a Germany-interview-level enterprise repo**
- Convert it into a BDD + RestAssured hybrid README**

Tell me — do you want to make this repo look 🔥🔥 enterprise-grade?

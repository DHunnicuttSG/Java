Module: Maven and Spring Fundamentals for Enterprise Java Development
Module Overview

This module introduces learners to two of the most important technologies in modern Java development: Apache Maven and the Spring Framework. Students will learn how Maven manages project builds and dependencies, understand the Maven lifecycle, explore Spring's role in enterprise application development, and implement dependency injection using Spring. The module concludes by examining how dependency injection and programming to interfaces work together to create flexible, maintainable, and testable applications.

Learning Outcomes

By the end of this module, learners will be able to:

Describe and demonstrate the functions of Maven as a programming tool.
Explain the Maven lifecycle.
Explain how Spring fits into Java development.
Use Spring for dependency injection.
Explain how dependency injection and programming to interfaces work together.
Section 1: Introduction to Maven
What is Maven?

Apache Maven is a project management and build automation tool used primarily for Java projects. Maven simplifies common development tasks such as:

Managing project dependencies
Compiling source code
Running tests
Packaging applications
Generating documentation
Deploying artifacts

Maven follows the principle of Convention over Configuration, reducing the amount of configuration developers must write.

Why Use Maven?

Without Maven, developers must:

Download libraries manually
Manage dependency versions themselves
Configure compilation processes manually
Handle build scripts separately

Maven automates these tasks, creating a consistent development process.

Benefits
Dependency management
Standardized project structure
Automated builds
Integration with CI/CD pipelines
Plugin ecosystem
Reproducible builds
Maven Project Structure

A typical Maven project follows this structure:

my-project/
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   └── resources/
│   │
│   └── test/
│       ├── java/
│       └── resources/
│
├── pom.xml
└── target/

Key Directories
Directory	Purposesrc/main/java	Application source code
src/main/resources	Configuration files
src/test/java	Unit tests
src/test/resources	Test resources
target	Generated build output
The POM File

The heart of a Maven project is the Project Object Model (POM) file.

Example:

<project>
    <modelVersion>4.0.0</modelVersion>

    <groupId>com.example</groupId>
    <artifactId>inventory-app</artifactId>
    <version>1.0.0</version>

    <dependencies>
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-context</artifactId>
            <version>6.0.0</version>
        </dependency>
    </dependencies>
</project>

Key Elements
Element	DescriptiongroupId	Organization identifier
artifactId	Application identifier
version	Project version
dependencies	Required libraries
Common Maven Commands
Compile Project
mvn compile

Run Tests
mvn test

Package Application
mvn package

Install to Local Repository
mvn install

Clean Build Artifacts
mvn clean

Practice Activity

Create a Maven project and:

Generate a project using Maven archetypes.
Add a dependency for JUnit.
Compile the project.
Run tests.
Package the application into a JAR file.
Section 2: Understanding the Maven Lifecycle
What is the Maven Lifecycle?

A lifecycle is a sequence of build phases that Maven executes in a specific order.

When a phase is executed, Maven also executes all previous phases.

Example:

mvn package


Automatically executes:

validate
compile
test
package

Maven Default Lifecycle
Validate

Checks project structure and configuration.

mvn validate

Compile

Compiles application source code.

mvn compile

Test

Runs unit tests.

mvn test

Package

Packages compiled code into an artifact.

Examples:

JAR
WAR
mvn package

Verify

Runs additional checks on the package.

mvn verify

Install

Places artifact in local repository.

mvn install

Deploy

Publishes artifact to a remote repository.

mvn deploy

Maven Lifecycle Diagram
validate
    ↓
compile
    ↓
test
    ↓
package
    ↓
verify
    ↓
install
    ↓
deploy

Understanding Plugins

Maven uses plugins to perform work during lifecycle phases.

Examples:

Plugin	FunctionCompiler Plugin	Compiles Java code
Surefire Plugin	Runs tests
JAR Plugin	Creates JAR files
Spring Boot Plugin	Packages Spring Boot applications
Practice Activity

For an existing Maven project:

Execute mvn compile.
Execute mvn test.
Execute mvn package.
Examine the generated artifact in the target directory.
Compare outputs from each phase.
Section 3: Spring and Modern Java Development
What is Spring?

The Spring Framework is an application framework that simplifies enterprise Java development.

Spring addresses common challenges:

Object creation and management
Dependency management
Configuration
Database access
Web development
Testing
Why Spring?

Traditional Java applications often contain tightly coupled classes.

Example:

public class OrderService {

    private EmailService emailService =
            new EmailService();
}


Problems:

Difficult to test
Difficult to replace implementations
High coupling

Spring helps solve this problem.

Core Features of Spring
Inversion of Control (IoC)

Spring manages object creation instead of application code creating objects directly.

Dependency Injection

Dependencies are supplied to classes rather than created internally.

Aspect-Oriented Programming

Allows separation of cross-cutting concerns such as:

Logging
Security
Transactions
Spring Ecosystem
Component	PurposeSpring Core	Dependency injection
Spring MVC	Web applications
Spring Data	Data access
Spring Security	Authentication and authorization
Spring Boot	Rapid application development
Spring Boot

Spring Boot simplifies application setup through:

Auto-configuration
Embedded servers
Starter dependencies
Reduced configuration

Example dependency:

<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
</dependency>

Discussion Activity

Discuss:

How Spring reduces boilerplate code.
Why large organizations frequently use Spring.
Benefits of Spring Boot compared to traditional Spring configuration.
Section 4: Dependency Injection with Spring
What is Dependency Injection?

Dependency Injection (DI) is a design pattern where dependencies are provided to a class instead of being created by the class.

Without Dependency Injection
public class CustomerService {

    private CustomerRepository repository =
            new CustomerRepository();
}


Problems:

Tight coupling
Difficult testing
Limited flexibility
With Dependency Injection
public class CustomerService {

    private CustomerRepository repository;

    public CustomerService(CustomerRepository repository) {
        this.repository = repository;
    }
}


Dependencies are provided externally.

Spring Bean Management

A bean is an object managed by the Spring container.

Repository
@Repository
public class CustomerRepository {
}

Service
@Service
public class CustomerService {

    private final CustomerRepository repository;

    public CustomerService(CustomerRepository repository) {
        this.repository = repository;
    }
}


Spring automatically creates and injects the dependency.

Constructor Injection

Preferred method for dependency injection.

@Service
public class PaymentService {

    private final LoggerService logger;

    public PaymentService(LoggerService logger) {
        this.logger = logger;
    }
}

Advantages
Immutable dependencies
Easier testing
Promotes clean design
Makes dependency requirements explicit
Spring Container Process
Application Starts
        ↓
Component Scan
        ↓
Bean Creation
        ↓
Dependency Resolution
        ↓
Dependency Injection
        ↓
Application Ready

Lab Activity

Build a Spring application containing:

One repository bean
One service bean
Constructor injection
A main class that retrieves and uses the service bean
Section 5: Dependency Injection and Programming to Interfaces
What is Programming to Interfaces?

Programming to interfaces means relying on abstractions rather than concrete implementations.

Interface
public interface NotificationService {

    void sendMessage(String message);
}

Implementation 1
public class EmailNotificationService
        implements NotificationService {

    public void sendMessage(String message) {
        System.out.println("Email: " + message);
    }
}

Implementation 2
public class SmsNotificationService
        implements NotificationService {

    public void sendMessage(String message) {
        System.out.println("SMS: " + message);
    }
}

Dependency Injection with Interfaces
@Service
public class AlertService {

    private final NotificationService service;

    public AlertService(NotificationService service) {
        this.service = service;
    }

    public void sendAlert(String message) {
        service.sendMessage(message);
    }
}


The AlertService does not know which implementation it receives.

Why This Matters
Loose Coupling

Classes depend on contracts rather than implementations.

Easier Testing

Mock implementations can easily replace real services.

NotificationService mockService =
        new MockNotificationService();

Easier Maintenance

Implementations can change without affecting consumers.

Greater Flexibility

New implementations can be added later.

Example:

NotificationService
│
├── EmailNotificationService
├── SmsNotificationService
└── TeamsNotificationService

Relationship Between DI and Interfaces

Dependency Injection and Programming to Interfaces complement each other.

Programming to Interfaces

Defines what functionality is required.

Dependency Injection

Determines which implementation is provided.

Together they produce:

Flexible systems
Testable systems
Maintainable systems
Extensible systems
Capstone Exercise

Create a Spring application that:

Defines a NotificationService interface.
Implements:
EmailNotificationService
SmsNotificationService
Uses Spring dependency injection to inject an implementation into AlertService.
Demonstrates swapping implementations through configuration without changing business logic.
Module Summary

In this module, students learned to:

Use Maven for dependency management and build automation.
Explain and apply phases within the Maven lifecycle.
Describe Spring's role in enterprise Java development.
Implement dependency injection using Spring-managed beans.
Understand how dependency injection and programming to interfaces work together to create loosely coupled, maintainable applications.
Knowledge Check
What problem does Maven solve in Java development?
What is the purpose of the pom.xml file?
Which Maven phase creates distributable artifacts?
What is Inversion of Control?
Why is constructor injection preferred?
What is the difference between dependency injection and inversion of control?
Why should developers program to interfaces?
How does Spring manage object creation?
What benefits result from combining interfaces with dependency injection?
How does Spring Boot improve developer productivity?
Recommended Duration
Topic	TimeMaven Fundamentals	60 min
Maven Lifecycle	45 min
Spring Overview	45 min
Dependency Injection	60 min
DI and Interfaces	45 min
Lab Activities	90 min
Capstone Exercise	90 min

Total Duration: Approximately 7-8 instructional hours.
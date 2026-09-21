# Java Unit Testing with JUnit 5
Testing the Service Layer in a Contact List Application
Learning Objectives

By the end of this lesson, students will be able to:

* Explain what unit testing is and why it is important.
* Create and run JUnit 5 tests.
* Follow the Arrange-Act-Assert (AAA) testing pattern.
* Test business logic inside a Service Layer.
* Verify valid and invalid phone numbers.
* Test update functionality.
* Test exceptions using JUnit.
* Build confidence in code changes through automated testing.

## What is Unit Testing?

A **unit test** verifies that a single piece of functionality works correctly.

Think of it like testing a single part on a car before assembling the entire vehicle.

Examples

Test:

✅ Phone validation

✅ Email validation

✅ Update contact logic

✅ Duplicate email detection

Don't Test:

❌ The entire application in one test

❌ The database connection

❌ The user interface

## Why Do We Write Unit Tests?

Suppose your Contact List application is working today.

A month later another developer changes the code.

Without tests:
```text
Change Code
    ↓
Deploy
    ↓
Hope Nothing Breaks
```

With tests:
```text
Change Code
    ↓
Run Tests
    ↓
Verify Application Still Works
```

Tests act as a safety net.

## What is JUnit?

JUnit is the most widely used testing framework for Java.

A typical JUnit test looks like this:
```java
@Test
void shouldAddNumbers() {

    int result = 2 + 2;

    assertEquals(4, result);
}
```

## Add JUnit Dependency
### Maven
```xml
<dependency>
    <groupId>org.junit.jupiter</groupId>
    <artifactId>junit-jupiter</artifactId>
    <version>5.10.2</version>
    <scope>test</scope>
</dependency>
```

### Gradle
```java
testImplementation 'org.junit.jupiter:junit-jupiter:5.10.2'
```

## Test Project Structure
```text
src
├── main
│   └── java
│       ├── model
│       ├── repository
│       └── service
│
└── test
    └── java
        └── service
            └── ContactServiceTest.java
```

## Business Rules to Test

Our ContactService currently has:
```java
addContact()
updateContact()
findById()
getAllContacts()
deleteContact()
```

Let's add one additional validation rule.

## Add Phone Validation

In ContactService:
```java
private void validatePhone(String phone) {

    if(phone == null || phone.length() < 7) {
        throw new IllegalArgumentException(
            "Phone number must contain at least 7 digits"
        );
    }
}
```

Update addContact():
```java
public void addContact(Contact contact) {

    validateEmail(contact.getEmail());
    validatePhone(contact.getPhone());

    repository.save(contact);
}
```

Update updateContact():
```java
public void updateContact(Long id,
                          String email,
                          String phone) {

    Contact contact =
        repository.findById(id);

    if(contact == null) {
        throw new RuntimeException(
            "Contact not found"
        );
    }

    validateEmail(email);
    validatePhone(phone);

    contact.setEmail(email);
    contact.setPhone(phone);
}
```

## Understanding the AAA Pattern

Most unit tests follow:

### Arrange

Create test data

### Act

Execute the code

### Assert

Verify results

Example:
```java
@Test
void shouldAddContact() {

    // Arrange
    Contact contact = new Contact(
            1L,
            "John",
            "Smith",
            "john@email.com",
            "5551234");

    // Act
    service.addContact(contact);

    // Assert
    assertEquals(
        1,
        service.getAllContacts().size()
    );
}
```
## Step 1: Create the Test Class
ContactServiceTest.java
```java
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ContactServiceTest {

    private ContactRepository repository;
    private ContactService service;

    @BeforeEach
    void setup() {

        repository = new ContactRepository();

        service = new ContactService(repository);
    }
}
```
## What Does @BeforeEach Do?

Before every test:
```text
Test 1
 ↓
Creates New Repository

Test 2
 ↓
Creates New Repository

Test 3
 ↓
Creates New Repository
```

This prevents tests from affecting each other.

## Test 1: Verify a Contact is Added
```java
import static org.junit.jupiter.api.Assertions.*;

@Test
void shouldAddContactSuccessfully() {

    Contact contact = new Contact(
            1L,
            "John",
            "Smith",
            "john@email.com",
            "5551234");

    service.addContact(contact);

    assertEquals(
        1,
        service.getAllContacts().size()
    );
}
```

## Test 2: Verify Invalid Email Throws Exception
```java
@Test
void shouldThrowExceptionForInvalidEmail() {

    Contact contact = new Contact(
            1L,
            "John",
            "Smith",
            "bad-email",
            "5551234");

    assertThrows(
            IllegalArgumentException.class,
            () -> service.addContact(contact)
    );
}
```

## Test 3: Verify Invalid Phone Number

Business rule:
```text
Phone must contain at least 7 digits
```

Test:
```java
@Test
void shouldRejectShortPhoneNumber() {

    Contact contact = new Contact(
            1L,
            "John",
            "Smith",
            "john@email.com",
            "555");

    assertThrows(
            IllegalArgumentException.class,
            () -> service.addContact(contact)
    );
}
```

## Test 4: Verify Valid Phone Number
```java
@Test
void shouldAcceptValidPhoneNumber() {

    Contact contact = new Contact(
            1L,
            "John",
            "Smith",
            "john@email.com",
            "5551234");

    service.addContact(contact);

    assertEquals(
            1,
            service.getAllContacts().size()
    );
}
```

## Testing the Update Function

Remember our method:
```java
public void updateContact(Long id,
                          String email,
                          String phone)
```

We need to verify that:

1. Contact exists
2. Values change successfully
3. Changes are saved

## Test 5: Update Contact Successfully
```java
@Test
void shouldUpdateContactSuccessfully() {

    Contact contact = new Contact(
            1L,
            "John",
            "Smith",
            "john@email.com",
            "5551234");

    service.addContact(contact);

    service.updateContact(
            1L,
            "new@email.com",
            "9999999");

    Contact updated =
            service.findById(1L);

    assertEquals(
            "new@email.com",
            updated.getEmail());

    assertEquals(
            "9999999",
            updated.getPhone());
}
```

## Test 6: Update Non-Existing Contact

Expected behavior:
```java
Contact not found
```

Test:
```java
@Test
void shouldThrowExceptionWhenContactNotFound() {

    assertThrows(
            RuntimeException.class,
            () -> service.updateContact(
                    999L,
                    "new@email.com",
                    "5551234")
    );
}
```

## Test 7: Update With Invalid Phone Number
```java
@Test
void shouldNotUpdateWhenPhoneIsInvalid() {

    Contact contact = new Contact(
            1L,
            "John",
            "Smith",
            "john@email.com",
            "5551234");

    service.addContact(contact);

    assertThrows(
            IllegalArgumentException.class,
            () -> service.updateContact(
                    1L,
                    "new@email.com",
                    "12")
    );
}
```

## Test 8: Verify Contact Count

Suppose students completed the exercise:
```java
public int countContacts() {
    return repository.findAll().size();
}
```

Test:
```java
@Test
void shouldReturnCorrectContactCount() {

    service.addContact(
        new Contact(
            1L,
            "John",
            "Smith",
            "john@email.com",
            "5551234"
        )
    );

    service.addContact(
        new Contact(
            2L,
            "Jane",
            "Brown",
            "jane@email.com",
            "5555678"
        )
    );

    assertEquals(
        2,
        service.countContacts()
    );
}
```

## Verifying Exception Messages

Junior developers often stop at:
```java
assertThrows(...)
```

A stronger test verifies the message.

Example:
```java
@Test
void shouldReturnCorrectErrorMessage() {

    Contact contact = new Contact(
            1L,
            "John",
            "Smith",
            "john@email.com",
            "123");

    IllegalArgumentException exception =
        assertThrows(
            IllegalArgumentException.class,
            () -> service.addContact(contact)
        );

    assertEquals(
        "Phone number must contain at least 7 digits",
        exception.getMessage()
    );
}
```

## Complete Test Class Example

Students should eventually have a test suite that validates:
```text
✓ Add Contact

✓ Invalid Email

✓ Invalid Phone

✓ Valid Phone

✓ Update Contact

✓ Contact Not Found

✓ Contact Count

✓ Exception Messages
```

# Common Junior Developer Mistakes
## Mistake #1

Testing multiple behaviors in one test.

Bad:
```java
@Test
void testEverything() {
   ...
}
```

Good:
```java
@Test
void shouldAddContact() {
}

@Test
void shouldRejectInvalidPhone() {
}
```

One test = One behavior.

## Mistake #2

No assertions.

Bad:
```java
@Test
void shouldAddContact() {

    service.addContact(contact);
}
```

The test never verifies anything.

## Mistake #3

Testing repository and service together.

Focus on a single unit.

Ask:
```text
What behavior am I proving?
```

## Mistake #4

Poor test names.

Bad:
```java
@Test
void test1()
```

Good:
```java
@Test
void shouldRejectPhoneNumberShorterThanSevenDigits()
```

The test name should describe expected behavior.

## Interview Questions
**Question**

What are the three parts of a unit test?

**Answer**
```text
Arrange
Act
Assert
```

**Question**
```text
What does assertThrows() do?
```
**Answer**
```text
It verifies that a specific exception is thrown during execution.
```
**Question**
```text
Why use @BeforeEach?
```
**Answer**
```text
It provides a clean setup before every test and prevents tests from sharing state.
```
**Question**
```text
What should unit tests focus on?
```
**Answer**
```text
One small piece of functionality at a time.
```

## Student Lab Exercise
### Exercise 1

Create a test named:
```java
shouldDeleteContactSuccessfully()
```

Requirements:

* Add a contact
* Delete the contact
* Verify list size is zero

### Exercise 2

Create:
```java
shouldFindContactById()
```

Requirements:

* Add contact
* Search for ID
* Verify returned object

### Exercise 3

Add a business rule:
```text
First name cannot be blank.
```

Create:
```java
shouldRejectBlankFirstName()
```

# Lesson Summary

Unit testing helps developers verify that business logic works correctly and continues working as applications evolve.

In our Contact List application, we tested:
```text
ContactService
    ├── addContact()
    ├── updateContact()
    ├── validation rules
    └── exception handling
```

Key skills junior developers should remember:

* Use the AAA pattern (Arrange, Act, Assert)
* Test one behavior at a time
* Verify both successful and failure scenarios
* Use assertEquals() for expected values
* Use assertThrows() for validation rules
* Write descriptive test names

A strong interview answer:

"Unit testing verifies that a single unit of code behaves correctly. In Java, JUnit allows us to automate testing of business logic, catch regressions early, and improve confidence when making code changes."
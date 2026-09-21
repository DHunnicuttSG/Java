Java Service Layer Lesson
Contact List Application Example 
Learning Objectives

By the end of this lesson, students will be able to:

Explain the purpose of the Service Layer in a Java application.
Understand how the Service Layer separates business logic from data access logic.
Create a Service Layer for a Contact List application.
Implement CRUD (Create, Read, Update, Delete) operations using a service.
Understand the relationship between Controller, Service, and Repository layers.
Build a simple application structure that follows industry best practices.
What is a Service Layer?

The Service Layer acts as the middleman between:

Controller (UI/API)
        ↓
     Service
        ↓
   Repository
        ↓
     Database

Responsibilities of the Service Layer

✅ Contains business rules

✅ Validates data

✅ Coordinates operations

✅ Calls repositories

✅ Prevents controllers from becoming too large

What the Service Layer Does NOT Do

❌ Display UI

❌ Directly manage HTTP requests

❌ Store data permanently

Real World Example

Imagine a Contact List application.

A user wants to:

Add a contact
View contacts
Update a contact
Delete a contact

Without a Service Layer:

```text
Controller  
    ├── Validation  
    ├── Business Rules  
    ├── Database Calls  
    └── Error Handling  
```

The controller becomes messy.

```text
With a Service Layer:

Controller  
    ↓
Service  
    ↓
Repository  
```

Each class has a clear responsibility.

Application Requirements

Our Contact List application will support:

Contact Fields
id
firstName
lastName
email
phone

Operations
Add Contact
Get All Contacts
Find Contact By ID
Update Contact
Delete Contact

```text
Project Structure
contact-list-app
│
├── model
│   └── Contact.java
│
├── repository
│   └── ContactRepository.java
│
├── service
│   └── ContactService.java
│
└── Main.java
```

## Step 1: Create the Contact Model

The model represents our business object.

Contact.java
public class Contact {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;

    public Contact(Long id,
                   String firstName,
                   String lastName,
                   String email,
                   String phone) {

        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }
}

## Step 2: Create the Repository

The repository is responsible for storing and retrieving data.

For this lesson, we'll use an in-memory list instead of a database.

ContactRepository.java
import java.util.ArrayList;
import java.util.List;

public class ContactRepository {

    private List<Contact> contacts = new ArrayList<>();

    public void save(Contact contact) {
        contacts.add(contact);
    }

    public List<Contact> findAll() {
        return contacts;
    }

    public Contact findById(Long id) {

        for(Contact contact : contacts) {
            if(contact.getId().equals(id)) {
                return contact;
            }
        }

        return null;
    }

    public void delete(Contact contact) {
        contacts.remove(contact);
    }
}

## Step 3: Create the Service Layer

This is where the business logic lives.

ContactService.java
import java.util.List;

public class ContactService {

    private ContactRepository repository;

    public ContactService(ContactRepository repository) {
        this.repository = repository;
    }

    public void addContact(Contact contact) {

        validateEmail(contact.getEmail());

        repository.save(contact);
    }

    public List<Contact> getAllContacts() {
        return repository.findAll();
    }

    public Contact findById(Long id) {
        return repository.findById(id);
    }

    public void deleteContact(Long id) {

        Contact contact = repository.findById(id);

        if(contact != null) {
            repository.delete(contact);
        }
    }

    private void validateEmail(String email) {

        if(email == null || !email.contains("@")) {
            throw new IllegalArgumentException(
                "Invalid email address"
            );
        }
    }
}

Why Put Validation in the Service?

Student Question:

Why not validate in the repository?

Answer:

Because validation is a business rule.

The repository's only job is data storage.

Repository = Data Access
Service = Business Rules


This separation makes the code easier to maintain.

## Step 4: Create the Main Class

This simulates a controller.

Main.java
public class Main {

    public static void main(String[] args) {

        ContactRepository repository =
            new ContactRepository();

        ContactService service =
            new ContactService(repository);

        service.addContact(
            new Contact(
                1L,
                "John",
                "Smith",
                "john@email.com",
                "555-1234"
            )
        );

        service.addContact(
            new Contact(
                2L,
                "Jane",
                "Brown",
                "jane@email.com",
                "555-6789"
            )
        );

        service.getAllContacts()
               .forEach(contact ->
                    System.out.println(
                        contact.getFirstName()
                    )
               );
    }
}

Output  
```text
John  
Jane
```
## Step 5: Add More Business Logic

As applications grow, services become more valuable.

Suppose the business requirement says:
```text
No duplicate email addresses are allowed.
```
Add that logic to the Service Layer.

public void addContact(Contact contact) {

    validateEmail(contact.getEmail());

    boolean duplicateFound =
        repository.findAll()
                  .stream()
                  .anyMatch(c ->
                        c.getEmail()
                         .equalsIgnoreCase(
                             contact.getEmail()
                         )
                  );

    if(duplicateFound) {
        throw new IllegalArgumentException(
            "Email already exists"
        );
    }

    repository.save(contact);
}

Service Layer Flow

When a user adds a contact:

```text
User
 ↓
Controller
 ↓
ContactService.addContact()
 ↓
Business Validation
 ↓
Repository.save()
 ↓
Contact Stored
```

Example Interview Question
Question

Why should a controller not access the repository directly?

Good Answer

The controller should focus on handling requests and responses.

Business rules belong in the Service Layer. Keeping business logic in services makes applications easier to test, maintain, and reuse.

Refactoring for Update Functionality

Add an update method to the service.

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

    contact.setEmail(email);
    contact.setPhone(phone);
}
```

Students will notice setter methods are now needed.

Update the Contact model:

```java
public void setEmail(String email) {
    this.email = email;
}

public void setPhone(String phone) {
    this.phone = phone;
}
```

Benefits of the Service Layer

### 1. Separation of Concerns
```text
Controller → Request Handling
Service    → Business Logic
Repository → Data Access
```

### 2. Easier Testing

You can test business rules without involving a UI or database.
```java
@Test
void shouldRejectInvalidEmail() {

    ContactRepository repository =
        new ContactRepository();

    ContactService service =
        new ContactService(repository);

    assertThrows(
        IllegalArgumentException.class,
        () -> service.addContact(
            new Contact(
                1L,
                "John",
                "Smith",
                "bad-email",
                "555-1234"
            )
        )
    );
}
```

### 3. Reusability

Multiple controllers can use the same service.
```text
Web Controller
      ↓
ContactService
      ↑
REST Controller
```

Both share the same business logic.

Guided Student Exercise
### Task 1

Create a method:

```java
findByEmail(String email)
```
Requirements
Add it to Repository
Call it from Service
Return matching Contact

### Task 2

Create a method:
```java
countContacts()
```
Expected Output
```java
Total Contacts: 5
```

### Task 3

Add a business rule.

Phone number must contain at least 7 digits.


Implement the validation in the Service Layer.

## Common Junior Developer Mistakes
**Mistake #1**

Putting validation in the repository.
```java
// BAD
repository.validateEmail();
```

**Mistake #2**

Calling repositories directly from the UI.
```java
// BAD
repository.save(contact);
```

**Mistake #3**

Putting everything in one class.
```text
Main.java
├── Validation
├── Business Logic
├── Data Access
└── UI
```

This violates separation of concerns.

## Service Layer Best Practices
Keep Services Focused

Good:
```java
ContactService
```

Bad:
```java
EverythingService
```
---
**Validate Before Saving**
```java
validate();

repository.save();
```

**Reuse Methods**

Good:
```java
validateEmail();
validatePhone();
```

Avoid duplicated validation logic.  

---

**Keep Repositories Simple**

Repositories should focus on:
```java
save()
find()
update()
delete()
```

Business decisions belong in services.

## Lesson Summary

The Service Layer sits between the Controller and Repository and is responsible for business logic.

In the Contact List application:
```text
Contact Model
      ↓
Contact Service
      ↓
Contact Repository
```

The service:

* Validates email addresses
* Prevents duplicate contacts
* Coordinates CRUD operations
* Protects repositories from business rules

A common interview answer to remember:

"The Service Layer encapsulates business logic and acts as a bridge between the presentation layer and the data access layer. It improves maintainability, testability, and separation of concerns."

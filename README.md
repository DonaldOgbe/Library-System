# 📚 Library System

A Java-based book library system where members (teachers and students) can borrow books. The borrowing follows defined rules of priority and availability. This project demonstrates the use of OOP principles.

## 🛠️ Features
- Add books to a library
- Prioritized borrowing based on member roles
- Request queues with optional FIFO behavior
- Exception handling and validation
- Optimized with Java 8 lambdas and functional interfaces
- Unit tests included

## 🎓 Roles and Priority
1. **Teacher** → highest priority
2. **Senior Student**
3. **Junior Student**

In the default implementation, teachers are prioritized over students even if students requested first.

## 📄 Class Structure Overview

### Librarian (Service)
- `addBook(Book book, Library library)`
- `addRequestToQueue(BaseQueue queue, Member member)`
- `processQueue(BaseQueue queue, Library library, String bookTitle)`

### Models
- **Book**: `Book(String title, int copies)`
- **Member**: `Member(String name, Role role)`
  - Subclasses: `Teacher`, `SeniorStudent`, `JuniorStudent`
- **Role**: Enum for member type and priority

### Repository
- **Library**: `Map<String, Book>` to store book catalog

### Queues
- **HierarchyQueue**: Prioritizes members by role
- **RequestTimeQueue**: Simple FIFO queue (alternative)

### Exceptions
- `CollectionException`
- `InvalidInputException`

### Validation
- `CollectionValidator`
- `InputValidator`

### Entry Point
- `LibrarySystem.java`

## 🧰 Tech Stack
- Java 17+
- JUnit for testing

## 🚫 Exception Handling
- Custom exceptions are thrown for invalid requests, such as invalid input or borrowing unavailable books.

## 🔧 Run Locally
```bash
# Compile
javac -d out src/main/java/**/*.java

# Run the app
java -cp out LibrarySystem
```

## 🧾 Usage Example
```java
Library library = new Library();
Book book = new Book("Clean Code", 2);
Member teacher = new Teacher("Alice");

Librarian librarian = new Librarian();
librarian.addBook(book, library);
librarian.addRequestToQueue(new HierarchyQueue(), teacher);
librarian.processQueue(new HierarchyQueue(), library, "Clean Code");
```
## 🧬 Running Tests

To run tests, use the IDE test runner or mvn test

```bash
  mvn test
```
- Unit tests are located in the `src/test` directory
- Test classes cover model logic, queue processing, and exception handling

## 📅 Decagon curriculum

- ✅ Decagon curriculum Week 3 Complete: Core collection and sorting/searching logic implemented
- ✅ Decagon curriculum Week 4 Complete: Functional refactor, stream usage, and exception handling

---


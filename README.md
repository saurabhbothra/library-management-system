# Library Management System

## Overview

The **Library Management System** is a Java-based application designed to manage books, members, and borrowing transactions in a library environment. It supports adding and searching books, registering members, borrowing and returning books, and tracking due dates.

This project demonstrates clean architecture with decoupled layers, in-memory repositories, and comprehensive unit testing.

---

## Table of Contents

- [Features](#features)
- [Project Structure](#project-structure)
- [Getting Started](#getting-started)
- [Building and Testing](#building-and-testing)
- [Usage](#usage)
- [Future Enhancements](#future-enhancements)
- [Contributing](#contributing)
- [License](#license)

---

## Features

- Add, update, and search books with availability tracking
- Register and manage library members
- Borrow and return books with due date calculation
- Track borrowing transactions and return status
- Simple in-memory data storage for demonstration
- Unit tests covering core functionalities

---

## Getting Started

### Prerequisites

- Java JDK 11 or higher
- Apache Maven 3.6 or higher

### Installation

1. Clone the repository: `git clone https://github.com/saurabhbothra/library-management-system.git && cd library-management-system`
2. Build the project and run tests: `mvn clean test`
3. Package the application (optional): `mvn package`


---

## Building and Testing

The project uses Maven for dependency management and build automation. Unit tests are written with JUnit 5.

- To compile the code: `mvn compile`
- To run unit tests: `mvn test`
- To create a JAR package: `mvn package`

---

## Future Enhancements

- Persistent storage with a database (e.g., MySQL, PostgreSQL)
- User authentication and role-based access control
- Overdue fine calculation and notifications
- Search and filter functionality for books and members
- RESTful API and web interface
- Integration with external library services

---

## Contributing

Contributions are welcome! Please follow these steps:

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/your-feature`)
3. Commit your changes (`git commit -m 'Add some feature'`)
4. Push to the branch (`git push origin feature/your-feature`)
5. Open a pull request

Please ensure your code follows existing style and includes tests.

---

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

---

## Contact

For questions or feedback, please open an issue or contact the maintainer.

---

*Thank you for using the Library Management System!*















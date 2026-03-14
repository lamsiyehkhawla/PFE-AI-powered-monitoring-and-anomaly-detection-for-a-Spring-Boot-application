# 🏦 eBanking Backend

A Spring Boot application providing RESTful APIs for a digital banking system.

## 🚀 Features

- Manage customers and bank accounts
- Perform debit, credit, and transfer operations
- RESTful API with DTOs and error handling
- H2 or MySQL database support
- Swagger or Postman-ready endpoints

## ⚙️ Tech Stack

- Spring Boot
- Spring Data JPA
- Spring Web
- Lombok
- H2/MySQL
- Maven

## 🛠️ Run the Backend

```bash
cd ebanking-backend
./mvnw spring-boot:run
```
📚 Example Endpoints
Method	Endpoint	Description
GET	/api/customers	Get all customers
POST	/api/accounts	Create a new account
POST	/api/operations	Perform a transaction

🧪 Sample Data
Some fake customers and accounts are loaded at startup using CommandLineRunner.

📝 Author
Khawla Lamsiyeh


# 🍬 Sweet Shop Management System

A full-stack **Spring Boot + JSP + PostgreSQL** based Sweet Shop application with **role-based authentication** using Spring Security.

---

## 🚀 Features
- User Registration & Login
- Role-based access (ADMIN / USER)
- Admin can:
  - Add sweets
  - Edit sweets
  - Delete sweets
- Users can:
  - View sweets
  - Purchase sweets
  - Search sweets
- Secure login using Spring Security
- PostgreSQL database integration

---

## 🛠️ Technologies Used
- Java
- Spring Boot
- Spring MVC
- Spring Security
- JSP & JSTL
- Hibernate / JPA
- PostgreSQL
- Maven
- Git & GitHub

---

## 📂 Project Structure
src/main/java
├── controller
├── service
├── repository
├── model
└── config

src/main/webapp
└── WEB-INF/jsp

yaml
Copy code

---

## ▶️ How to Run the Project
1. Install **Java 17+**
2. Install **PostgreSQL**
3. Create database:
   ```sql
   CREATE DATABASE sweetshop;
Update application.properties

Run SweetShopApplication

Open browser:

bash
Copy code
http://localhost:8080/login
🔐 Sample Login Credentials
Admin
Username: user

Password: 123

User
Username: postgres

Password: pg123


🤖 My AI Usage
I used AI tools (ChatGPT) to:

Understand Spring Boot + Spring Security configuration
Debug authentication and redirect loop issues
Generate sample JUnit & Mockito test cases
Improve README structure and documentation clarity
All business logic, integration, debugging, and final implementation were reviewed, modified, and implemented by me.

AI was used strictly as an assistant, not as a replacement for learning.

🔐 Authentication & Authorization
Authentication implemented using Spring Security (Session-based)
Form login with username & password
Roles supported:
ROLE_ADMIN
ROLE_USER
Access Control:
Admin: Add / Edit / Delete sweets
User: View & Purchase sweets
Note: JWT-based authentication can be added as a future enhancement.

---

👨‍💻 Author
Prashant Rajput
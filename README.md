# 🏢 Spring Boot Department & Employee Management API

This project is a simple **Spring Boot REST API** for managing Departments, Employees, and Salaries. It demonstrates entity relationships, DTO mappings, pagination, filtering, and API structuring using best practices.

---

## 📦 Features

- ✅ Create Department
- ✅ Create Employee under a Department
- ✅ Get Employees by Department
- ✅ Get Employees by Designation
- ✅ Get Employees within a Salary Range
- ✅ Paginated Employee List with Filters

---

## 🧱 Tech Stack

- Java 17+
- Spring Boot
- Spring Data JPA
- MySQL (configurable)
- Lombok 
- Postman for testing

---

## 🗃️ Database Structure

### 🔸 Department
- `id`: Long
- `name`: String
- `location`: String
- `employees`: List<Employee>

### 🔸 Employee
- `id`: Long
- `name`: String
- `designation`: Enum (`MANAGER`, `DEVELOPER`, etc.)
- `joiningDate`: LocalDate
- `department`: Department
- `salary`: Salary

### 🔸 Salary
- `id`: Long
- `amount`: Double
- `employee`: Employee

---

## 🚀 API Endpoints

### 📁 Department APIs

| Method | Endpoint                        | Description                  |
|--------|----------------------------------|------------------------------|
| POST   | `/api/department`                | Create a new department      |
| GET    | `/api/department/{id}`           | Get employees in department  |

---

### 👨‍💼 Employee APIs

| Method | Endpoint                           | Description                                 |
|--------|-------------------------------------|---------------------------------------------|
| POST   | `/employees/department/{deptId}`    | Create employee under department            |
| GET    | `/employees/designation/{type}`     | Get employees by designation                |
| GET    | `/employees/salary-range`           | Filter employees by salary range            |
| GET    | `/employees/filter`                 | Paginated employees (with optional filters) |

> Example: `/api/employees/filter?page=0&size=5&designation=DEVELOPER&minSalary=50000&maxSalary=100000`

---

## 🛠️ Setup Instructions

1. **Clone the repo**
   ```bash
   git clone https://github.com/yourusername/employee-department-api.git
   cd employee-department-api


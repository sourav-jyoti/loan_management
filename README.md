# FinFlow Loan Management System


## Overview

**FinFlow** is a scalable, microservices-based loan management system that enables users to apply for loans, upload documents, track application status, and receive real-time notifications. Admin users can review applications, verify documents, and approve or reject loans.

This project is designed using **Spring Boot Microservices Architecture** with **API Gateway**, **JWT Security**, and **separate databases per service**.

---

## Key Features

### Applicant Features

* User Registration & Login (JWT based authentication)
* Create and manage loan applications (Draft → Submit)
* Upload and manage documents
* Track loan application status
* Receive email notifications (submission, approval, rejection)

### Admin Features

* View all loan applications
* Verify uploaded documents
* Approve or reject applications
* Manage users
* Generate reports (basic)

---

## Architecture

This system follows a **Microservices Architecture**:

* API Gateway (Single entry point)
* Auth Service (Authentication & JWT)
* Application Service (Loan lifecycle management)
* Document Service (Document handling)
* Admin Service (Approval & admin workflows)
* Notification Service (Email notifications)

Each service is:

* Independently deployable
* Connected via API Gateway
* Using its own database

---

## System Flow

```
User → API Gateway → Auth Service (JWT)
     → Application Service → Document Service
     → Admin Service → Notification Service → Email
```

---

## Loan Application Lifecycle

```
Draft → Submitted → Docs Pending → Docs Verified → Under Review → Approved / Rejected → Closed
```

---

## Tech Stack

### 🔹 Backend

* Java 17
* Spring Boot
* Spring Security (JWT)
* Spring Cloud Gateway
* Spring Data JPA (Hibernate)

### 🔹 Database

* MySQL / PostgreSQL

### 🔹 Tools

* Postman (API Testing)
* Maven
* Git & GitHub

### 🔹 Notification

* Spring Mail (Email Service)

---

## Microservices Breakdown

###  Auth Service

* User signup & login
* JWT token generation
* Role-based authentication (Applicant/Admin)

---

###  Application Service

* Create loan application (Draft)
* Update application
* Submit application
* Track application status

---

###  Document Service

* Upload documents
* Replace documents
* Manage document status

---

###  Admin Service

* View all applications
* Verify documents
* Approve / Reject applications
* Manage users

---

###  Notification Service

* Sends email notifications:

  * Application Submitted
  * Loan Approved / Rejected

---

## Security

* JWT-based authentication
* Role-based access control using `@PreAuthorize`
* Secured API routes via API Gateway

---

## API Endpoints (Gateway Routes)

```
/gateway/auth/*
/gateway/applications/*
/gateway/documents/*
/gateway/admin/*
```

---

## Project Structure

```
finflow/
│
├── api-gateway/
├── eureka-server/
├── auth-service/
├── application-service/
├── document-service/
├── admin-service/
├── notification-service/
└── README.md
```

---

##  Setup Instructions


### Run Services in Order

1. Eureka Server
2. API Gateway
3. All Microservices

---

### Configure Database

Update `application.properties` in each service:


spring.datasource.url=jdbc:mysql://localhost:3306/db_name
spring.datasource.username=root
spring.datasource.password=your_password


### Run Application

Use:


mvn spring-boot:run


---

## Testing

* API testing using **Postman**
* Unit testing using **JUnit & Mockito**

### End-to-End Flow Tested:

```
Login → Apply Loan → Upload Docs → Submit → Admin Review → Decision → Notification
```


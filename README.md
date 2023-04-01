# LIBRARY MANAGEMENT SYSTEM

This is a library management system API for users to borrow books, track empty seats in halls. 

Users can borrow books from library and return them within specified dates. They can also track empty seats of halls to check if there is an available place.

Subscription system is implemented within API. A subscribed user can borrow book limitless books at the same time while unsubscribed user can borrow only 3 books.

Before book borrows, there is also a stock validation check for books so every book can't be borrowed indefinitely.


# Dependecies and Tools

- Java Spring Boot 2.7.9
- Spring Data JPA
- Spring Security 6
- MySQL
- Jsonwebtoken
- Lombok


# Database Design

<img width="827" alt="image" src="https://user-images.githubusercontent.com/73110402/229303802-2f409010-c629-428c-92bb-093520838b39.png">

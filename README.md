# pholib - Photos Online Share Website

This is a Java Spring MVC web application. It uses Spring framework, and manages data with Hibernate. It has a backend of Java and a front end of HTML, CSS.

### What this app does:

- Serves dynamic web content according to URI, including index and detail pages for categories and photos
- Uses Spring Security to implement user authentication and authorization
- Includes database connectivity, where photo data is stored, and interacts with a database
- Allows a user to perform CRUD (create, read, update, delete) operations on photo and category data
- Performs server-side form validation, and displays flash messages or form validation messages when logging in, adding/editing photos/categories.
- Serves static assets, such as images, fonts, CSS, and JS

### How to run this app:
1. Download this project;
2. Set up a database service:
```
java -cp h2-1.4.194.jar org.h2.tools.Server
```
3. Compile and run this project
4. Try on the browser:
```
localhost:8080
```

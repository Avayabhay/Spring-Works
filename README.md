Annotation to be learnt - 
	1. Repository (supports component scanning & translates JDBC exception)
	2. Transactional - from springFrameWork
	
----------------------------------------------------------------------------------------------------------------------------------------------------

Section 4

11 December 2023
23:24

Building Basic Employee CRUD App

The task is to implement a basic CRUD app where we can store employee details, update, get and delete the details of the Employees.

The Dependencies installed:
	1. Dev Tools- restart feature.
	2. Web - Since its a web project
	3. JPA - for hibernate
	4. Mysql - we'll be using mysql database

The architecture of the App:

	Employee Rest Controll  ---> employee Service ---->Employee DAO  ------>Database
	
	
Things we code:
	1. Entity class - Employees
	2. DAO - EmployeeDAO (interface) & EmployeeDAOImpl(class to implement DAO)
		a. Its implementation uses an EntityMangaer to createQueries and get the results
	3. Define EmployeeRestCOntroller to expose endpoints.
	4. Use EmployeeDAO in RestCOntroller to CRUD Data.

	Code Refactoring (Best Practices)
	5. Add Service Layer - EmployeeService (interface) & EmployeeServiceIMpl(class)
		a. Use Inject EMployeeDAO in this classs
	6. Refactor the code in the Controller to use EmployeeService class instead of EmployeeDAO
		a. Note : We use Service because there can be multiple DAO class but only one service class to handle all the DAO Class.
	
	
	
	
But it becomes be cumbersome to make a DAO for every entity in the database. The Actual code is almost (99%) same.
There we use SpringJPARepository instead of each DAO as :
publicinterfaceEmployeeRepositoryextendsJpaRepository<Employee,Integer>{
}

Thats it, the above is enough


Now, for every entity do we need to create a repository and service class?
The ans is no.
All we need to is Spring Data Rest packages to be added in the POM xml file and we get the crud operation by default.
So we can remove the service and repository class for alll the entities

----------------------------------------------------------------------------------------------------------------------------------------------------

Section 5 - Security

27 January 2024
23:51

Security starter helps provide us with different authentication and autherization techniques of our App.
The security class should be marked as @Configuration.  And then we InMemoryUserDetailsManager function to create  new user with roles and password. Please Note the InMemoryUserDetailsManager uses Builder design pattern.

The above is enough for authentication.
But to authorize the users to access API based on the roles, we need to do the following:
SecurityFilterChain is the function that takes HTTPSecurity as input which calls the authorizeHttpRequests() to match request API with the specific roles that can accses it.

httpBasic()
Csfr (Cross Site Request Forgery) can be disabled for stateless REST API![image](https://github.com/Avayabhay/Spring-Works/assets/39983140/868722eb-648b-4c41-86c0-a3a8ec548fbb)


So far we have the user and their roles details hard coded. But in real life this information is stored in Database.
So, now we will learn about authorizing the user based on the details read from the database.

Spring Security can read the user account info from database.
By default, we have to follow the Spring Security's predefined table scheme.
We can also customize the table schemes and then we will be responsible for writing the code to access the data using JDBC, Hibernate, etc and also read the user roles. In this course we wont be using the custom schema but the spring security's out of the box feature.

Steps:



We need to create 2 tables as:

Also note that the name should be exact same. Reference key is username.


To authorize the user by reading info from data base, we comment/remove the code creating hard-coded user.
Then we use the UserDetailsManager()  function that takes a datasource(which is auto-wired) and returns JdbcUserDetailsManager. That all that we have to do!
Now the app read details from user and authenticates and authorizes the user based on the details from the Database.
 


![image](https://github.com/Avayabhay/Spring-Works/assets/39983140/000e3c3d-9ca0-4062-9ebb-b3de30e46f41)


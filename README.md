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


In the above lectures/codes, we store password as a simple/plain text. Now If any hacker gets access of the Database he will have access to the passwords. So, we should always encrypt the password before saving it. In this course we will use bcrypt for this and bcrypt is the recommended way of storing password by spring.

The spring security login process:

Note: bcrypt is a one-way algorithm. Passwords from the database is never decrypted. But the password enter by the user is encrypted and then compared with encrypted password stored in the database.

To do so, we just have to changes {noop} -> {bcrypt} in the database for the users. Also the password now stored in encrypted by bcrypt. Eg of the store password :
{bcrypt}$2a$10$jfpwgA6IJ7QlG7UAARxtkeG6AavhVawFJf8pj8O8aGlD1eRKxZCwW

Here, the first part tells that we are using brcypt to encrypt the password. {noop} means no opertation, menaing storing the pwd as a plain text.

Rest Spring handles everything on its own(dont know how need to do some research).![image](https://github.com/Avayabhay/Spring-Works/assets/39983140/d806dbac-2e1a-45a3-9989-5d4829b58df3)


	Now we will use Spring Security to use Custom Tables:
	To use Custom Table, we need to tell springBoot how to find users and roles
	
	
	We tell spring about the user :
	jdbcUserDetailsManager.setUsersByUsernameQuery(
	"selectuser_id,pw,activefrommemberswhereuser_id=?"
	);
	
	In the above code, the "?" will be populated by the form while login
	
	For Roles:
	jdbcUserDetailsManager.setUsersByUsernameQuery(
	"selectuser_id,rolefrommemberswhereuser_id=?"
	);
	 Note: The Custom Table used are : members & roles
	
	That's all the changes we need to do.
![image](https://github.com/Avayabhay/Spring-Works/assets/39983140/d805d18d-e2f0-468f-840d-cb077abb9e0a)


-----------------------------------------------------------------------------------------------------------------------------------------------------------


Section 8- MVC Security


Adding Custom Login Page

	![image](https://github.com/Avayabhay/Spring-Works/assets/39983140/556b640e-1662-485e-a8ce-02f4f6b9eef8)

	We take the HttpSecurity as input paramter and then use the authorizeHttpRequests() to configure it as shown
	
	
	We create the login-page.html for logging in the user.
	Note: the fields should be "username" & "password" for the inputs.
	
	After the form is created make sure that the action is set to :
	![image](https://github.com/Avayabhay/Spring-Works/assets/39983140/5b6ff539-40c2-42de-889d-6e42c17f18dc)

	
	Note: action  is given by html but it will not used in our, rather we have to put th:action for it to work
	Also, the @{/}  as points to relative path to root.
	Also /authenticateTheUser will automatically authenicate the user based on the security config.
	
	
	Now, we will show error in case of invalid authentication:
![image](https://github.com/Avayabhay/Spring-Works/assets/39983140/a9f5e3a8-cab4-49aa-abf5-b9ecae0972c1)

 
	If there is any error message, the error parameter is set, else its null
	Error parameter is passed by spring security automatically incase of error
	
![image](https://github.com/Avayabhay/Spring-Works/assets/39983140/10b4e372-8342-4a5f-8134-e23aa92b2120)

	
	Logout:
	Now we will be logging out the user and show the logout message.
	
	TO log out the user we need to do the following in the Security Configuration
	
	
	And add the following in the UI(html)
	
	Note: we put the action ="/logout" which is given and handled by SpringBoot
	
	Also if the user is logged out, springboot adds a logout  parameter to the param same as in error as:
	
	

Print the Username and Role:
Fist of all add the following dependency to the pom.xml file. 
Note: this was not mentioned in the course, I had a hard time figuing it out:
<dependency>
<groupId>org.springframework.boot</groupId>
<artifactId>spring-boot-starter-thymeleaf</artifactId>
</dependency>

And then to display the username and password:







Restricting access based on roles



The full code:



Custom access denied Page :


We need to create the "access-denied" api in the controller


![image](https://github.com/Avayabhay/Spring-Works/assets/39983140/5e57ad21-4391-4455-95b6-c54bcc0a83f4)



JDBC
Spring security has default schema for login - users and authorities.
Previously we hard coded the users and the roles that we being used of authorization but now
We will fetch the data from database and based on the same we will authorize the users.
To do so, first we need to add the following dependency to the pom file:
We also need to add the spring-boot-starter-data-jpa.
 we are added the jdbc driver that is mysql.


Next we need to configure the properties as :
	
	
Now we need to use the jdbc authentication as :

Notice the datasource is being autoconfigured


Just Mentioning: We can see the relationship between different table using some menu
Check lec 260 for same
![image](https://github.com/Avayabhay/Spring-Works/assets/39983140/55b48da2-0e2a-4824-9cff-25ce08c5a92c)

Password Encryption


The above is the changes for using the encrypting the pass.
Please check more about encrypting the password. Here, we are only reading the encrypted password
And thats all we are doing. I'm not sure how but springboot itself is encrypting our plain/text password and comparing with the encrypted password in the Database. 

In the above, the first part denotes the encryption.

![image](https://github.com/Avayabhay/Spring-Works/assets/39983140/8712db45-c767-46b3-b71c-5e045101f112)

Authentication using Custom Tables - lec 267



We need to tell spring boot to find the table as shown in the above diagram.
We need to tell provide query to find user by username and also to find authorities/roles by user name a shown in the above snap
![image](https://github.com/Avayabhay/Spring-Works/assets/39983140/b5b3b603-b8b2-4cf7-8855-f2d19fb78273)


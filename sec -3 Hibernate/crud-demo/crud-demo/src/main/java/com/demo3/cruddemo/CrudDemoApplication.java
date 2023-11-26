package com.demo3.cruddemo;

import com.demo3.cruddemo.dao.StudentDAO;
import com.demo3.cruddemo.dao.StudentImplement;
import com.demo3.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CrudDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudDemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return runner -> {
			//creating student
			createStudent(studentDAO);

			//read Student
			//readStudent(studentDAO);

			//Query For Students
			//queryForStudent(studentDAO);

			//Query for lastName
			//queryForStudentsForLastName(studentDAO);7

			//Update the Student
			//updateStudentName(studentDAO);

			//Delete the Student
			//deleteStudentByID(studentDAO);

			//Delete All the entries
			deleteAllStudent(studentDAO);
		};
	}

	private void deleteAllStudent(StudentDAO studentDAO) {
		System.out.println("Deleting All Students!");
		int rows = studentDAO.deleteStudentAll();
		System.out.println("DELETED");
	}

	private void deleteStudentByID(StudentDAO studentDAO) {
		int ID = 2;


//		//Fetching the Student
//		Student student = studentDAO.findByID(ID);
//
//		//Displaying the Student
//		System.out.println(student);

		//Removing the Student
		studentDAO.deleteStudent(ID);

		//Displaying the Table
		System.out.println("Deletion completed!");

	}

	private void updateStudentName(StudentDAO studentDAO) {

		//get the student using the ID
		Student myStudent = studentDAO.findByID(1);

		//Display the Student
		System.out.println(myStudent);
		//Update Student's last Name
		myStudent.setLastName("Singh");
		//Push the changes to Database
		studentDAO.updateStudent(myStudent);
		//Display the updated student
		System.out.println(myStudent);
	}

	private void queryForStudentsForLastName(StudentDAO studentDAO) {

		//get the list of student
		List<Student> studentList = studentDAO.findByLastName("Shawn");

		//display the list of students
		for(Student student : studentList){
			System.out.println(student);
		}
	}

	private void queryForStudent(StudentDAO studentDAO) {
		//get all the list of students
		List<Student> queriedStudents = studentDAO.findAll();
		//Display the list of students
		for (Student student: queriedStudents)
		{
			System.out.println(student);
		}

	}

	private void readStudent(StudentDAO studentDAO) {
		//create a student
		System.out.println("Creating a new Student called Ash");
		Student tempStudent = new Student("Ash","Shawn","ash.shaw02@gmail.com");

		// save the student Object
		System.out.println("Saving the Student Object");
		studentDAO.save(tempStudent);

		// display the id of the student
		System.out.println("The ID of the student is : "+tempStudent.getId());

		//retrieve the student based on id:primary key
		System.out.println("retieving the student");
		Student retriveStudent = studentDAO.findByID(tempStudent.getId());

		//display the student\
		System.out.println(retriveStudent.toString());

	}

	private void createStudent(StudentDAO studentDAO) {
		// create the Student Object
		System.out.println("Creating the student object");
		Student tempStudent = new Student("Abhay","Sharma","avay.abhay002@gmail.com");

		// save the student Object
		System.out.println("Saving the Student Object");
		studentDAO.save(tempStudent);

		// display the id of the student
		System.out.println("The ID of the student is : "+tempStudent.getId());
	}

}

package com.student.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.student.model.Student;
import com.student.utillity.DBUtil;

public class StudentDataImplementation implements StudentDataInterface {
	
	private Connection conn;

	public StudentDataImplementation() {
		conn = DBUtil.getConnection();
	}
	public void addStudent( Student student ) {
		try {
			String query = "insert into student (firstName, lastName, gender, age,mail,address) values (?,?,?,?,?,?)";
			PreparedStatement preparedStatement = conn.prepareStatement( query );
			preparedStatement.setString( 1, student.getFirstName() );
			preparedStatement.setString( 2, student.getLastName() );
			preparedStatement.setString( 3, student.getGender() );
			preparedStatement.setInt( 4, student.getAge() );
			preparedStatement.setString(5,student.getMail());
			preparedStatement.setString(6, student.getAddress());
			preparedStatement.executeUpdate();
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<Student> getAllStudents() {
		List<Student> students = new ArrayList<Student>();
		try {
			Statement statement = conn.createStatement();
			ResultSet resultSet = statement.executeQuery( "select * from student" );
			while( resultSet.next() ) {
				Student student = new Student();
				student.setStudentId( resultSet.getInt( "studentId" ) );
				student.setFirstName( resultSet.getString( "firstName" ) );
				student.setLastName( resultSet.getString( "lastName" ) );
				student.setGender( resultSet.getString( "gender" ) );
				student.setAge( resultSet.getInt( "age" ) );
				student.setMail(resultSet.getString("mail"));
				student.setAddress(resultSet.getString("address"));
				students.add(student);
			}
			resultSet.close();
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return students;
	}
	
	public List<Student> searchStudents(String searchvalue) {
		List<Student> students = new ArrayList<Student>();
		try {
			Statement statement = conn.createStatement();
			String query = "select * from student WHERE firstName LIKE '%"+searchvalue+"%' OR lastName LIKE '%"+searchvalue+"%'";
			ResultSet resultSet = statement.executeQuery(query);
			while( resultSet.next() ) {
				Student student = new Student();
				student.setStudentId( resultSet.getInt( "studentId" ) );
				student.setFirstName( resultSet.getString( "firstName" ) );
				student.setLastName( resultSet.getString( "lastName" ) );
				student.setGender( resultSet.getString( "gender" ) );
				student.setAge( resultSet.getInt( "age" ) );
				student.setMail(resultSet.getString("mail"));
				student.setAddress(resultSet.getString("address"));
				students.add(student);
			}
			resultSet.close();
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return students;
	}
}
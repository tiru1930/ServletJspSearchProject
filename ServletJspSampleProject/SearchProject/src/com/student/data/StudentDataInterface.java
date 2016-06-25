package com.student.data;

import java.util.List;

import com.student.model.Student;

public interface StudentDataInterface {
	public void addStudent( Student student );
	public List<Student> getAllStudents();
	public List<Student> searchStudents(String value);
}
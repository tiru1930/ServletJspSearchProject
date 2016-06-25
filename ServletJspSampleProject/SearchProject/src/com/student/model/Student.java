package com.student.model;

public class Student {

	private int studentId;
	private String firstName;
	private String lastName;
	private String gender;
	private int age;
	private String mail;
	private String address;
	
	public void setGender(String gender) {
		this.gender = gender;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public int getAge() {
		return age;
	}
	public String getMail() {
		return mail;
	}
	public String getAddress() {
		return address;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", gender=" + gender + ", age="
				+ age + "]";
	}
		
}

package com.student.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.student.data.StudentDataInterface;
import com.student.data.StudentDataImplementation;
import com.student.model.Student;

@WebServlet("/StudentController")
public class StudentController extends HttpServlet {
	
	private StudentDataInterface dao;
	private static final long serialVersionUID = 1L;
	public static final String add_student = "/student.jsp";
	public static final String search_student = "/search.jsp";
       
    public StudentController() {
    	dao = new StudentDataImplementation();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String forward = "";
		String action = request.getParameter( "action" );		
	    if( action.equalsIgnoreCase( "insert" ) ) {
			forward = add_student;
		}
		else if(action.equalsIgnoreCase("searchStudent")){
			forward = search_student;
			request.setAttribute("students", dao.getAllStudents() );
		}
		RequestDispatcher view = request.getRequestDispatcher( forward );
		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action =  request.getParameter( "action" );
		if(action.equalsIgnoreCase("search")){
			String searchValue =  request.getParameter("searhvalue");
			RequestDispatcher view = request.getRequestDispatcher(search_student);
			request.setAttribute("students", dao.searchStudents(searchValue));
			view.forward(request, response);
		}else if(action.equalsIgnoreCase("addstudent")){
			Student student = new Student();
			student.setFirstName( request.getParameter( "firstName" ) );
			student.setLastName( request.getParameter( "lastName" ) );
			student.setGender( request.getParameter( "gender" ) );
			student.setAge( Integer.parseInt( request.getParameter( "age" ) ) );
			student.setMail(request.getParameter("mail"));
			student.setAddress(request.getParameter("address"));
			dao.addStudent(student);
			RequestDispatcher view = request.getRequestDispatcher(search_student);
			request.setAttribute("students", dao.getAllStudents());
			view.forward(request, response);
		}
	}
}

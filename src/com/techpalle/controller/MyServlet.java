package com.techpalle.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.techpalle.dao.DataAccess;
import com.techpalle.model.Customer;
import com.techpalle.util.SuccessPage;


@WebServlet("/")
public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getServletPath();
		switch (path) {
			case "/regCustomer":
				insertCustomer(request, response);
				break;
			case "/log":
				getLoginPage(request, response);
				break;
			case "/reg":
				getRegistrationPage(request, response);
			case"/logCustomer":
				validateCustomer(request, response);
				break;
			default:
				getStartUpPage(request,response);
				break;
		}
	}

	
	private void validateCustomer(HttpServletRequest request, HttpServletResponse response) {
		//Read the email and password from login.jsp page:
		String email = request.getParameter("tbEmaillog");
		String password = request.getParameter("tbPasslog");
		
		//Call the method present in DAO:
		boolean b = DataAccess.validateCustomer(email, password);
		
		//Condition and Redirect user to destination page (success):
		if (b) {
			try {
				RequestDispatcher rd = request.getRequestDispatcher("success.jsp");
				//Store the SuccessPage class data inside RD:
				SuccessPage sp = new SuccessPage();
				request.setAttribute("successDetails", sp);
				rd.forward(request, response);
			} 
			catch (ServletException e) {
				e.printStackTrace();
			} 
			catch (IOException e) {
				e.printStackTrace();
			}
		}
		else {
			getLoginPage(request, response);
		}
	}


	private void insertCustomer(HttpServletRequest request, HttpServletResponse response) {
		
		//Read the data from jsp page:
		String name = request.getParameter("tbName");
		String email = request.getParameter("tbEmail");
		Long mobile = Long.parseLong(request.getParameter("tbMobile"));
		String password = request.getParameter("tbPass");
		String state = request.getParameter("ddlStates");
		
		//Store the above data in Customer object:
		Customer customer = new Customer(name, email, mobile, password, state);
		
		//Call insertCustomer method present in dao by passing above object:
		DataAccess.insertCustomer(customer);
		
		//Redirect user to login page with email and password:
		try {
			RequestDispatcher rd = request.getRequestDispatcher("customer_login.jsp");
			rd.forward(request, response);
		} 
		catch (ServletException e) {
			e.printStackTrace();
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
	}


	private void getRegistrationPage(HttpServletRequest request, HttpServletResponse response) {
		try {
			RequestDispatcher rd = request.getRequestDispatcher("customer_registration.jsp");
			rd.forward(request, response);
		} 
		catch (ServletException e) {
			e.printStackTrace();
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
	}


	private void getLoginPage(HttpServletRequest request, HttpServletResponse response) {
		try {
			RequestDispatcher rd = request.getRequestDispatcher("customer_login.jsp");
			rd.forward(request, response);
		} 
		catch (ServletException e) {
			e.printStackTrace();
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
	}


	private void getStartUpPage(HttpServletRequest request, HttpServletResponse response) {
		try {
			RequestDispatcher rd = request.getRequestDispatcher("customer_management.jsp");
			rd.forward(request, response);
		} 
		catch (ServletException e) {
			e.printStackTrace();
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}